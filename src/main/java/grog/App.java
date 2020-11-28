package grog;

import java.io.IOException;
import java.nio.file.Paths;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        var lexer = new GrogLexer(CharStreams.fromPath(Paths.get(args[0])));
        var parser = new GrogParser(new CommonTokenStream(lexer));
        var program = parser.program();
        var result = new Interpreter().visitProgram(program);
        System.out.printf("Result: %s%n", result != null ? result.toString() : "null");
    }
}
