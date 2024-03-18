import com.truffle.lama.nodes.CompilationUnitNode;
import com.truffle.lama.nodes.expression.BooleanLiteral;
import com.truffle.lama.nodes.expression.DecimalLiteral;
import com.truffle.lama.nodes.expression.InfixNodeGen;
import com.truffle.lama.nodes.expression.StringLiteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleTests {
    @Test
    void simpleIntTest() {
        var x = new DecimalLiteral(1);
        var y = new DecimalLiteral(1);
        var op = new StringLiteral("+");
        var node = InfixNodeGen.create(x, op, y);
        var rootNode = new CompilationUnitNode(node);

        var result = rootNode.getCallTarget().call();
        assertEquals(2, result);

    }

    @Test
    void simpleBoolTest() {
        var x = new BooleanLiteral(false);
        var y = new BooleanLiteral(true);
        var op = new StringLiteral("|");
        var node = InfixNodeGen.create(x, op, y);
        var rootNode = new CompilationUnitNode(node);

        var result = rootNode.getCallTarget().call();
        assertEquals(true, result);

    }
}
