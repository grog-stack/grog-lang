package grog;

import java.util.List;

public class Function implements Lambda {
    private final String name;
    private final LambdaExpr lambda;

    public Function(String name, LambdaExpr lambda) {
        this.name = name;
        this.lambda = lambda;
    }

    public String name() {
        return name;
    }
    
    public List<Parameter> parameters() {
        return lambda.parameters();
    }
    
    public Object evaluate(SymbolsTable symbolsTable, GrogBaseVisitor visitor) {
        return lambda.evaluate(symbolsTable, visitor);
    }
}
