package grog;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import static java.util.stream.Collectors.toList;

public class Interpreter extends GrogBaseVisitor<Object> {

    private final Map<String, Function> functions = new HashMap<>();
    private final Stack<SymbolsTable> symbols = new Stack<>();

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
        var parameters = ctx.parameters
                .stream()
                .map((p) -> (Parameter) p.accept(this))
                .collect(toList());
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
                throw new RuntimeException(
                        String.format("Unsupported operator: ", ctx.operator.getText())
                );
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
                throw new RuntimeException(
                        String.format("Unsupported operator: ", ctx.operator.getText())
                );
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
                throw new RuntimeException(
                        String.format("Unsupported operator: ", ctx.operator.getText())
                );
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
                throw new RuntimeException(
                        String.format("Unsupported operator: ", ctx.operator.getText())
                );
        }
    }

    @Override
    public Object visitReferenceExpr(GrogParser.ReferenceExprContext ctx) {
        return symbols.peek().get(ctx.value.getText());
    }

    @Override
    public Object visitFunctionCallExpr(GrogParser.FunctionCallExprContext ctx) {
        var symbolsTable = new SymbolsTable(symbols.peek());
        var name = ctx.name.getText();
        var evaluable = (Lambda) functions.get(name);
        if (evaluable == null) {
            var lambda = symbolsTable.get(name);
            if (!(lambda instanceof Lambda)) {
                throw new RuntimeException(String.format("Symbol \"%s\" is not a function.", name));
            }
            evaluable = (Lambda) lambda;
        }
        var parameters = evaluable.parameters();
        for (int i = 0; i < parameters.size(); i++) {
            symbolsTable.put(parameters.get(i).name(), ctx.parameters.get(i).accept(this));
        }
        try {
            symbols.push(symbolsTable);
            return evaluable.evaluate(this);
        } finally {
            symbols.pop();
        }
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
        if (functions.containsKey(name)) {
            throw new RuntimeException(String.format("Function \"%s\" already defined.", name));
        }
        var function = new Function(
                name,
                (LambdaExpr) ctx.lambda().accept(this)
        );
        functions.put(name, function);
        return function;
    }

    @Override
    public Object visitProgram(GrogParser.ProgramContext ctx) {
        symbols.push(new SymbolsTable(null));
        ctx.function().forEach((f) -> f.accept(this));
        return ctx.expression().accept(this);
    }

    @Override
    public Object visitBooleanLiteralExpr(GrogParser.BooleanLiteralExprContext ctx) {
        return Boolean.valueOf(ctx.value.getText());
    }

    
}
