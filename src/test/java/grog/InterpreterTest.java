package grog;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InterpreterTest {

    public static List<Arguments> standardFunctions() {
        return List.of(
            Arguments.of("var s <- size({1,2,3})", 3)
        );
    }
    
    public static List<Arguments> collectionsFunctions() {
        return List.of(
            Arguments.of(
                "var m <- map([1,2,3], (x) <- x+1)",
                List.of(new BigDecimal(2), new BigDecimal(3), new BigDecimal(4))
            )
        );
    }
    
    @ParameterizedTest
    @MethodSource("standardFunctions")
    public void testInterpreterResults(String program, Object expectedResult) throws IOException {
        assertEquals(expectedResult, new Interpreter().interpret(program));
    }
    
    
    @ParameterizedTest
    @MethodSource("collectionsFunctions")
    public void testInterpreterCollectionResults(String program, Collection expectedResult) throws IOException {
        var expectedCollection = (Collection) expectedResult;
        var actualResult = (Collection) new Interpreter().interpret(program);
        assertTrue(expectedCollection.containsAll(actualResult));
        assertTrue(actualResult.containsAll(expectedCollection));
    }
    
}
