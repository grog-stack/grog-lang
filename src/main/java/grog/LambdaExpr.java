package grog;

import java.util.List;
import org.antlr.v4.runtime.ParserRuleContext;

public class LambdaExpr implements Lambda {

    private final List<Parameter> parameters;
    private final ParserRuleContext expression;

    public LambdaExpr(List<Parameter> parameters, ParserRuleContext expression) {
        this.parameters = parameters;
        this.expression = expression;
    }

    public Object evaluate(SymbolsTable symbolsTable, GrogBaseVisitor visitor) {
        return expression.accept(visitor);
    }

    public List<Parameter> parameters() {
        return parameters;
    }
}
