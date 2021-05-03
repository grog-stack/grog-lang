package grog;

import java.util.List;

public interface Lambda {

    List<Parameter> parameters();

    Object evaluate(SymbolsTable symbolsTable, GrogBaseVisitor visitor);
}
