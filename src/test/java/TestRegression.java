import com.oracle.truffle.api.nodes.RootNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRegression {

    private final Path dirPath = Path.of("resources", "regression");

    private RootNode parseLamaFile(String code) {
        //new CompilationUnitNode(node);
        return null;
    }

    private void testFile(String testName) throws IOException {
        var path = dirPath.resolve(testName + ".lama");
        var code = Files.readAllLines(path).getFirst();
        var rootNode = parseLamaFile(code);
        var result = rootNode.getCallTarget().call();
        assertEquals(2, result);
    }
}