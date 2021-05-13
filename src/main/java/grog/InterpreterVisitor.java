package grog;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import grog.GrogParser.IndexedReferenceExprContext;
import grog.GrogParser.TypeContext;
import grog.functions.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

public class InterpreterVisitor extends GrogBaseVisitor<Object> {

    private final Map<String, Lambda> STANDARD_FUNCTIONS = Map.of(
        "size", new Size(),
        "map", new grog.functions.Map()
    );
    
    private final Stack<SymbolsTable> symbols = new Stack<>();
    
    public InterpreterVisitor() {
        symbols.push(new SymbolsTable(null));
        STANDARD_FUNCTIONS.entrySet().forEach((e) -> {
            try {
                putInSymbolsTableOrThrowError(e.getKey(), e.getValue());
            } catch (SymbolAlreadyDefined ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    @Override
    public Object visitTypeDeclaration(GrogParser.TypeDeclarationContext ctx) {
        return super.visitTypeDeclaration(ctx);
    }

    @Override
    public Object visitParameter(GrogParser.ParameterContext ctx) {
        return new Parameter(ctx.name.getText());
    }

    @Override
    public Object visitLambda(GrogParser.LambdaContext ctx) {
        var parameters = ctx.parameters.stream().map((p) -> (Parameter) p.accept(this)).collect(toList());
        return new LambdaExpr(parameters, ctx.expression());
    }

    @Override
    public Object visitBooleanExpr(GrogParser.BooleanExprContext ctx) {
        var left = (Boolean) ctx.left.accept(this);
        var right = (Boolean) ctx.right.accept(this);
        switch (ctx.operator.getText()) {
            case "&":
                return left && right;
            case "|":
                return left || right;
            default:
                throw new RuntimeException(String.format("Unsupported operator: ", ctx.operator.getText()));
        }
    }

    @Override
    public Object visitTimesExpr(GrogParser.TimesExprContext ctx) {
        var left = (BigDecimal) ctx.left.accept(this);
        var right = (BigDecimal) ctx.right.accept(this);
        switch (ctx.operator.getText()) {
            case "*":
                return left.multiply(right);
            case "/":
                return left.divide(right);
            default:
                throw new RuntimeException(String.format("Unsupported operator: ", ctx.operator.getText()));
        }
    }

    @Override
    public Object visitLambdaExpr(GrogParser.LambdaExprContext ctx) {
        return (LambdaExpr) ctx.lambda().accept(this);
    }

    @Override
    public Object visitComparisonExpr(GrogParser.ComparisonExprContext ctx) {
        var left = (BigDecimal) ctx.left.accept(this);
        var right = (BigDecimal) ctx.right.accept(this);
        switch (ctx.operator.getText()) {
            case ">":
                return left.compareTo(right) > 0;
            case ">=":
                return left.compareTo(right) >= 0;
            case "<":
                return left.compareTo(right) < 0;
            case "<=":
                return left.compareTo(right) <= 0;
            case "==":
                return left.compareTo(right) == 0;
            case "!=":
                return left.compareTo(right) != 0;
            default:
                throw new RuntimeException(String.format("Unsupported operator: ", ctx.operator.getText()));
        }
    }

    @Override
    public Object visitNumberExpr(GrogParser.NumberExprContext ctx) {
        return new BigDecimal(ctx.NUMBER().getText());
    }

    @Override
    public Object visitPlusExpr(GrogParser.PlusExprContext ctx) {
        var left = (BigDecimal) ctx.left.accept(this);
        var right = (BigDecimal) ctx.right.accept(this);
        switch (ctx.operator.getText()) {
            case "+":
                return left.add(right);
            case "-":
                return left.subtract(right);
            default:
                throw new RuntimeException(String.format("Unsupported operator: ", ctx.operator.getText()));
        }
    }

    @Override
    public Object visitReferenceExpr(GrogParser.ReferenceExprContext ctx) {
        var symbolsTable = symbols.peek();
        var value = symbolsTable.get(ctx.value.getText());
        return value instanceof Expression ? ((Expression) value).evaluate(symbolsTable) : value;
    }

    @Override
    public Object visitFunctionCall(GrogParser.FunctionCallContext ctx) {
        var symbolsTable = symbols.peek();
        var name = ctx.name.getText();
        var evaluable = lambdaOrFunction(symbolsTable, name);
        var parameters = evaluable.parameters();
        var newSymbolsTable = new SymbolsTable(symbolsTable);
        for (int i = 0; i < parameters.size(); i++) {
            try {
                newSymbolsTable.put(parameters.get(i).name(), ctx.parameters.get(i).accept(this));
            } catch (SymbolAlreadyDefined e) {
                throw new RuntimeException(
                    String.format(
                        "[%d:%d] Symbol %s is already defined.",
                        ctx.name.getLine(),
                        ctx.name.getCharPositionInLine(),
                        name
                    )
                );
            }
        }
        try {
            symbols.push(newSymbolsTable);
            return evaluable.evaluate(symbols.peek(), this);
        } finally {
            symbols.pop();
        }
    }

    private Lambda lambdaOrFunction(SymbolsTable symbolsTable, String name) {
        var symbol = symbolsTable.get(name);
        if (symbol == null) {
            throw new RuntimeException(String.format("Symbol %s not found.", name));
        } else if (!(symbol instanceof Lambda)) {
            throw new RuntimeException(String.format("Symbol \"%s\" is not a lambda nor a function.", name));
        }
        return (Lambda) symbol;
    }

    @Override
    public Object visitFunctionCallExpr(GrogParser.FunctionCallExprContext ctx) {
        return ctx.functionCall().accept(this);
    }

    @Override
    public Object visitNegativeExpr(GrogParser.NegativeExprContext ctx) {
        return !((Boolean) ctx.value.accept(this));
    }

    @Override
    public Object visitPowerExpr(GrogParser.PowerExprContext ctx) {
        var base = (BigDecimal) ctx.left.accept(this);
        var exponent = (BigDecimal) ctx.right.accept(this);
        return base.pow(exponent.intValue());
    }

    @Override
    public Object visitFunction(GrogParser.FunctionContext ctx) {
        var name = ctx.name.getText();
        var function = new Function(name, (LambdaExpr) ctx.lambda().accept(this));
        putInSymbolsTableOrThrowError(ctx.name, function);
        return function;
    }

    @Override
    public Object visitProgram(GrogParser.ProgramContext ctx) {
        symbols.push(new SymbolsTable(symbols.peek()));
        Object lastValue = null;
        for (ParseTree child : ctx.children) {
            lastValue = child.accept(this);
        }
        return lastValue;
    }

    @Override
    public Object visitBooleanLiteralExpr(GrogParser.BooleanLiteralExprContext ctx) {
        return new Literal(Boolean.valueOf(ctx.value.getText()));
    }

    @Override
    public Object visitType(TypeContext ctx) {
        var name = ctx.name.getText();
        var type = new Type(
            name,
            ctx.functions.stream().map((f) -> (Function) f.accept(this)).collect(toSet())
        );
        putInSymbolsTableOrThrowError(ctx.name, type);
        return type;
    }

    @Override
    public Object visitVariableDecl(GrogParser.VariableDeclContext ctx) {
        var value = ctx.value.accept(this);
        putInSymbolsTableOrThrowError(ctx.name, value);
        return value;
    }

    @Override
    public Object visitSetLiteralExpr(GrogParser.SetLiteralExprContext ctx) {
        return ctx.values.stream().map((v) -> v.accept(this)).collect(toSet());
    }

    @Override
    public Object visitListLiteralExpr(GrogParser.ListLiteralExprContext ctx) {
        return ctx.values.stream().map((v) -> v.accept(this)).collect(toList());
    }

    @Override
    public Object visitMapLiteralExpr(GrogParser.MapLiteralExprContext ctx) {
        return ctx.entries.stream()
            .map((e) -> (MapEntry) e.accept(this))
            .collect(
                toMap(
                    (e) -> e.key(),
                    (e) -> e.value()
                )
            );
    }

    @Override
    public Object visitMapEntry(GrogParser.MapEntryContext ctx) {
        return new MapEntry(ctx.key.accept(this), ctx.value.accept(this));
    }

    @Override
    public Object visitStringLiteralExpr(GrogParser.StringLiteralExprContext ctx) {
        var text = ctx.value.getText();
        return text.substring(1, text.length() - 1);
    }

    @Override
    public Object visitIndexedReferenceExpr(IndexedReferenceExprContext ctx) {
        var value = ctx.value.accept(this);
        var index = ctx.index.accept(this);
        if (value instanceof List) {
            return ((List) value).get(((BigDecimal) index).intValue());
        } else if (value instanceof java.util.Map) {
            return ((Map) value).get(index);
        } else {
            var start = ctx.value.start;
            throw new RuntimeException(
                String.format("[%d:%d] Not an indexed value.", start.getLine(), start.getCharPositionInLine())
            );
        }
    }

    @Override
    public Object visitConstant(GrogParser.ConstantContext ctx) {
        var constant = new Constant(ctx.name.getText(), ctx.value.accept(this));
        putInSymbolsTableOrThrowError(ctx.name, constant);
        return constant;
    }

    private void putInSymbolsTableOrThrowError(Token name, Object value) {
        try {
            putInSymbolsTableOrThrowError(name.getText(), value);
        } catch (SymbolAlreadyDefined ex) {
            throw new RuntimeException(
                String.format(
                    "[%d:%d] Symbol %s is already defined.",
                    name.getLine(),
                    name.getCharPositionInLine(),
                    name.getText()
                )
            );
        }
    }
    
    private void putInSymbolsTableOrThrowError(String name, Object value) throws SymbolAlreadyDefined {
        symbols.peek().put(name, value);
    }

    public SymbolsTable pushNewSymbolsTable() {
        var symbolsTable = new SymbolsTable(symbols.peek());
        symbols.push(symbolsTable);
        return symbolsTable;
    }
    
    public SymbolsTable popSymbolsTable() {
        return symbols.pop();
    }
    
}
