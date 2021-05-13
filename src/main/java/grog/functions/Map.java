package grog.functions;

import grog.GrogBaseVisitor;
import grog.InterpreterVisitor;
import grog.Lambda;
import grog.Parameter;
import grog.SymbolAlreadyDefined;
import grog.SymbolsTable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Map implements Lambda {

    @Override
    public List<Parameter> parameters() {
        return List.of(new Parameter("collection"), new Parameter("function"));
    }

    @Override
    public Object evaluate(SymbolsTable symbolsTable, GrogBaseVisitor visitor) {
        var collection = (Collection) symbolsTable.get("collection");
        var function = (Lambda) symbolsTable.get("function");
        var newCollection = newCollection(collection);
        for (Object element : collection) {
            var symbols = ((InterpreterVisitor) visitor).pushNewSymbolsTable();
            try {
                symbols.put(function.parameters().get(0).name(), element);
                newCollection.add(function.evaluate(symbols, visitor));
            } catch (SymbolAlreadyDefined ex) {
                throw new RuntimeException("This should never happen...");
            }
        }
        return newCollection;
    }

    private Collection newCollection(Collection collection) {
        if (collection instanceof Set) {
            return new HashSet();
        } else if (collection instanceof List) {
            return new ArrayList<>(collection.size());
        } else {
            throw new RuntimeException("Invalid collection type.");
        }
    }

}
