package grog;

import java.util.Set;

public class Type {
    private final String name;
    private final Set<Function> functions;

    public Type(String name, Set<Function> functions) {
        this.name = name;
        this.functions = functions;
    }

    public String name() {
        return name;
    }
    
}
