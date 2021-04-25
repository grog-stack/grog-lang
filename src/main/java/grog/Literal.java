package grog;

public class Literal implements Expression {
    private final Object value;

    public Literal(Object value) {
        this.value = value;
    }

    @Override
    public Object evaluate(SymbolsTable symbolsTable) {
        return value;
    }
}
