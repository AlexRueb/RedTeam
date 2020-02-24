import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            for (int i = 0; i < args.length; i++) {
                String inputFile = args[0];
                CharStream cs = CharStreams.fromFileName(inputFile);
                LITTLELexer lexer = new LITTLELexer(cs);
                CommonTokenStream tstream = new CommonTokenStream(lexer);
                int tokens = tstream.getNumberOfOnChannelTokens();

                LITTLEParser parser = new LITTLEParser(tstream);
                parser.program(inputFile);
                
                String[] splitFileName = inputFile.split("\\.");
                splitFileName = splitFileName[0].concat(".out").split("/");
                String outputFileName = splitFileName[splitFileName.length-1];
                String outputPath = "../output";
                OutputStream os = new FileOutputStream((new File(outputPath.concat(outputFileName))));
                String output = "";
                for (int j = 0; j < tokens - 1; j++) {
                    System.out.println("Token Type: " + convertType(tstream.get(j).getType()));
                    System.out.println("Value: " + tstream.get(j).getText());
                    output += "Token Type: " + convertType(tstream.get(j).getType()) + "\n";
                    output += "Value: " + tstream.get(j).getText() + "\n";
                }
                os.write(output.getBytes(), 0, output.length());
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }

    }
    public static String convertType ( int type){
        switch (type) {
            case 1:
                return "KEYWORD";
            case 3:
                return "OPERATOR";
            case 4:
                return "INTLITERAL";
            case 5:
                return "FLOATLITERAL";
            case 6:
                return "STRINGLITERAL";
            case 7:
                return "COMMENT";
            case 8:
                return "IDENTIFIER";
            default:
                return "If you see this, seek help";
        }
    }
}
