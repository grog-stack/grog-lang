package grog;

import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InterpreterTest {

    public static List<Arguments> standardFunctions() {
        return List.of(
            Arguments.of("var s <- size({1,2,3})", 3)
        );
    }
    
    @ParameterizedTest
    @MethodSource("standardFunctions")
    public void testInterpreter(String program, Object expectedResult) throws IOException {
        assertEquals(expectedResult, new Interpreter().interpret(program));
    }
    
}
