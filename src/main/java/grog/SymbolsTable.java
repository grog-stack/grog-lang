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
        if (!symbols.containsKey(name) && parent != null) {
            return parent.get(name);
        }
        return symbols.get(name);
    }
    
    public void put(String name, Object value) throws SymbolAlreadyDefined {
        if (symbols.containsKey(name)) {
            throw new SymbolAlreadyDefined(String.format("Symbol already defined: \"%s\"", name));
        }
        symbols.put(name, value);
    }
    
}
