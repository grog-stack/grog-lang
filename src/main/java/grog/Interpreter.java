package grog;

import java.io.IOException;
import java.nio.file.Path;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Interpreter {

    public Object interpret(Path file) throws IOException {
        return interpret(CharStreams.fromPath(file));
    }

    public Object interpret(String program) throws IOException {
        return interpret(CharStreams.fromString(program));
    }

    public Object interpret(CharStream charStream) {
        var lexer = new GrogLexer(charStream);
        var parser = new GrogParser(new CommonTokenStream(lexer));
        var program = parser.program();
        return new InterpreterVisitor().visitProgram(program);
    }

}
