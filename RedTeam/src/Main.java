import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

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
                ListenerClass l = new ListenerClass();
                ParseTreeWalker walker= new ParseTreeWalker();
                walker.walk(l, tree);
                l.printSymbolTables();
            }
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }
    }
}
