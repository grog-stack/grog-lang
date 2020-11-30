package grog;

import java.util.HashMap;
import java.util.Map;

public class SymbolsTable {
    private final SymbolsTable parent;
    private final Map<String, Object> symbols = new HashMap<>();
    private final Map<String, Type> types = new HashMap<>();
    private final Map<String, Function> functions = new HashMap<>();

    public SymbolsTable(SymbolsTable parent) {
        this.parent = parent;
    }
    
    public Object get(String name) {
        if (!symbols.containsKey(name) && parent != null) {
            return parent.get(name);
        }
        return symbols.get(name);
    }
    
    public void put(String name, Object value) {
        if (symbols.containsKey(name)) {
            throw new RuntimeException(String.format("Symbol already defined: \"%s\"", name));
        }
        symbols.put(name, value);
    }

    public Type type(String name) {
        return types.get(name);
    }

    public void add(Type type) {
        if (types.containsKey(type.name())) {
            throw new RuntimeException(String.format("Type %s already defined.", type.name()));
        }
        types.put(type.name(), type);
    }

    public Function function(String name) {
        if (!functions.containsKey(name)) {
            return parent != null ? parent.function(name) : null;
        }
        return functions.get(name);
    }

    public void add(Function function) {
        if (types.containsKey(function.name())) {
            throw new RuntimeException(String.format("Function %s already defined.", function.name()));
        }
        functions.put(function.name(), function);
    }

    public void add(String name, Object value) {
        if (symbols.containsKey(name)) {
            throw new RuntimeException(String.format("The symbol %s is already defined.", name));
        }
        symbols.put(name, value);
    }
    
}
