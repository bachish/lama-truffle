import com.truffle.lama.nodes.expression.DecimalLiteral;
import com.truffle.lama.nodes.expression.StringLiteral;
import org.junit.jupiter.api.Test;

class SimpleTests {
    @Test
    void simpleTest() {
        DecimalLiteral x = new DecimalLiteral(1);
        DecimalLiteral y = new DecimalLiteral(1);
        StringLiteral op = new StringLiteral("+");
        //  Infix node = new Infix(x, op, y);
    }
}
