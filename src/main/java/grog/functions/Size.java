package grog.functions;

import grog.GrogBaseVisitor;
import grog.Lambda;
import grog.Parameter;
import grog.SymbolsTable;
import java.util.Collection;
import java.util.List;

public class Size implements Lambda {

    @Override
    public List<Parameter> parameters() {
        return List.of(new Parameter("collection"));
    }

    @Override
    public Object evaluate(SymbolsTable symbolsTable, GrogBaseVisitor visitor) {
        var collection = (Collection) symbolsTable.get("collection");
        if (collection == null) {
            throw new RuntimeException("Parameter \"collection\" not found.");
        }
        return collection.size();
    }

}
