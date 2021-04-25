package grog;

public class Constant implements Expression {
    private final String name;
    private final Object value;

    public Constant(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public Object evaluate(SymbolsTable symbolsTable) {
        return value;
    }
    
    
}
