import com.truffle.lama.LamaLanguage;
import com.truffle.lama.nodes.LamaRootNode;
import org.graalvm.polyglot.Context;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleTests {
    Object evaluate(String code) {
        var node = LamaLanguage.parse(code);
        var rootNode = new LamaRootNode(node);
        return rootNode.getCallTarget().call();
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
    void assignmentTest() {
        try (Context context = Context.create()) {
            var result = context.eval("lml", "var x = 3; x");
            assertEquals(3, result.asInt());
        }

    }
}
