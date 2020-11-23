package grog;

import java.util.HashMap;
import java.util.Map;

public class SymbolsTable {
    private final SymbolsTable parent;
    private final Map<String, Object> symbols = new HashMap<>();

    public SymbolsTable(SymbolsTable parent) {
        this.parent = parent;
    }
    
    public Object get(String name) {
        if (!symbols.containsKey(name)) {
            if (parent != null) {
                return parent.get(name);
            }
            throw new RuntimeException(String.format("Could not resolve reference \"%s\"", name));
        }
        return symbols.get(name);
    }
    
    public void put(String name, Object value) {
        if (symbols.containsKey(name)) {
            throw new RuntimeException(String.format("Symbol already defined: \"%s\"", name));
        }
        symbols.put(name, value);
    }
    
}
