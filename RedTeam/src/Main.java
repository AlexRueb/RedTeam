import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            for (String inputFile : args) {
                CharStream cs = CharStreams.fromFileName(inputFile);
                LITTLELexer lexer = new LITTLELexer(cs);
                CommonTokenStream tokens = new CommonTokenStream(lexer);

                LITTLEParser parser = new LITTLEParser(tokens);

                parser.setErrorHandler(new BailErrorStrategy());
                ParseTree tree = parser.program();

                System.out.println("Accepted");
            }
        } catch (RuntimeException e) {
            System.out.println("Not accepted");
        }
    }
}
