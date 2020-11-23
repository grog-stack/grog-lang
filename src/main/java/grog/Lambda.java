package grog;

import java.util.List;

public interface Lambda {

    List<Parameter> parameters();

    Object evaluate(GrogBaseVisitor visitor);
}
