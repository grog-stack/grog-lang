package grog;

import java.io.IOException;
import java.nio.file.Paths;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        var result = new Interpreter().interpret(Paths.get(args[0]));
        System.out.printf("Result: %s%n", result != null ? result.toString() : "null");
    }
}
