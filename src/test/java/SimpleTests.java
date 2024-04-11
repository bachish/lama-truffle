import com.truffle.lama.LamaLanguage;
import com.truffle.lama.nodes.LamaRootNode;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleTests {

    Object evaluate(String code) {
        var node = LamaLanguage.parse(code);
        var rootNode = new LamaRootNode(node);
        return rootNode.getCallTarget().call();
    }

    Value evaluateCtx(String code) {
        try (Context context = Context.create()) {
            return context.eval("lml", code);
        }
    }
    @Test
    void simpleIntTest() {
        assertEquals(7, evaluate("3 + 4"));
    }


    @Test
    void simpleBoolTest() {
        assertEquals(true, evaluate("false !! true"));
    }

    @Test
    void simpleStringTest() {
        assertEquals("abba", evaluate("\"abba\""));
    }


    @Test
    void simpleDefinitionTest() {
        assertEquals(3, evaluateCtx("var x = 3; x").asInt());
    }

    @Test
    void simpleAssignmentTest() {
        assertEquals(4, evaluateCtx("var x = 3; x := 4; x").asInt());
    }


    @ParameterizedTest
    @CsvSource(value = {"3 $ var x = 3, y = \"12\"; x",
            "123 $ var x = 3, y = 123; y"
    }, delimiter = '$')
    void simpleTestWithContext(Integer result, String code) {
        assertEquals(result, evaluateCtx(code).asInt());
    }
}
