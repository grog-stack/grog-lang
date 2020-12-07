package grog;

import grog.GrogParser.TypeContext;
import java.math.BigDecimal;
import java.util.Stack;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.Collections.emptyMap;

public class Interpreter extends GrogBaseVisitor<Object> {

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
        return symbols.peek().get(ctx.value.getText());
    }

    @Override
    public Object visitFunctionCall(GrogParser.FunctionCallContext ctx) {
        var symbolsTable = symbols.peek();
        var name = ctx.name.getText();
        var evaluable = lambdaOrFunction(symbolsTable, name);
        var parameters = evaluable.parameters();
        var newSymbolsTable = new SymbolsTable(symbolsTable);
        for (int i = 0; i < parameters.size(); i++) {
            newSymbolsTable.put(parameters.get(i).name(), ctx.parameters.get(i).accept(this));
        }
        try {
            symbols.push(newSymbolsTable);
            return evaluable.evaluate(this);
        } finally {
            symbols.pop();
        }
    }

    private Lambda lambdaOrFunction(SymbolsTable symbolsTable, String name) {
        var symbol = symbolsTable.get(name);
        if (symbol != null) {
            if (!(symbol instanceof Lambda)) {
                throw new RuntimeException(String.format("Symbol \"%s\" is not a lambda.", name));
            }
            return (Lambda) symbol;
        } else {
            var function = symbolsTable.function(name);
            if (function == null) {
                throw new RuntimeException(String.format("Symbol \"%s\" not found.", name));
            }
            return function;
        }
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
        var symbolsTable = symbols.peek();
        if (symbolsTable.function(name) != null) {
            throw new RuntimeException(String.format("Function \"%s\" already defined.", name));
        }
        var function = new Function(name, (LambdaExpr) ctx.lambda().accept(this));
        symbolsTable.add(function);
        return function;
    }

    @Override
    public Object visitProgram(GrogParser.ProgramContext ctx) {
        symbols.push(new SymbolsTable(null));
        ctx.function().forEach((f) -> f.accept(this));
        Object lastValue = null;
        for (GrogParser.StatementContext statement : ctx.statements) {
            lastValue = statement.accept(this);
        }
        return lastValue;
    }

    @Override
    public Object visitBooleanLiteralExpr(GrogParser.BooleanLiteralExprContext ctx) {
        return Boolean.valueOf(ctx.value.getText());
    }

    @Override
    public Object visitType(TypeContext ctx) {
        var type = new Type(
            ctx.name.getText(), 
            ctx.functions.stream().map((f) -> (Function) f.accept(this)).collect(toSet())
        );
        symbols.peek().add(type);
        return type;
    }

	@Override
	public Object visitVariableDecl(GrogParser.VariableDeclContext ctx) {
        var value = ctx.value.accept(this);
		symbols.peek().put(ctx.name.getText(), value);
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
		return text.substring(1, text.length()-1);
	}

}
