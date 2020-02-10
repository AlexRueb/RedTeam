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
            CharStream cs = CharStreams.fromFileName("./inputs/fibonacci.micro");
            littleLexer lexer = new littleLexer(cs);
            CommonTokenStream tstream = new CommonTokenStream(lexer);
            int tokens = tstream.getNumberOfOnChannelTokens();
            System.out.println(tokens);
            OutputStream os = new FileOutputStream((new File("./outputs/ourFibonnaci.out")));
            String output = "";
            for(int i = 0; i < tokens - 1; i++) {
                System.out.println("Token Type: " + convertType(tstream.get(i).getType()));
                System.out.println("Value: " + tstream.get(i).getText());
                output += "Token Type: " + convertType(tstream.get(i).getType()) + "\n";
                output += "Value: " + tstream.get(i).getText() + "\n";
            }
            os.write(output.getBytes(), 0, output.length());
        } catch(IOException e) {System.out.println("File not found");}
        try {
            CharStream cs = CharStreams.fromFileName("./inputs/sqrt.micro");
            littleLexer lexer = new littleLexer(cs);
            CommonTokenStream tstream = new CommonTokenStream(lexer);
            int tokens = tstream.getNumberOfOnChannelTokens();
            System.out.println(tokens);
            OutputStream os = new FileOutputStream((new File("./outputs/ourSqrt.out")));
            String output = "";
            for(int i = 0; i < tokens - 1; i++) {
                System.out.println("Token Type: " + convertType(tstream.get(i).getType()));
                System.out.println("Value: " + tstream.get(i).getText());
                output += "Token Type: " + convertType(tstream.get(i).getType()) + "\n";
                output += "Value: " + tstream.get(i).getText() + "\n";
            }
            os.write(output.getBytes(), 0, output.length());
        } catch(IOException e) {System.out.println("File not found");}
        try {
            CharStream cs = CharStreams.fromFileName("./inputs/loop.micro");
            littleLexer lexer = new littleLexer(cs);
            CommonTokenStream tstream = new CommonTokenStream(lexer);
            int tokens = tstream.getNumberOfOnChannelTokens();
            System.out.println(tokens);
            OutputStream os = new FileOutputStream((new File("./outputs/ourLoop.out")));
            String output = "";
            for(int i = 0; i < tokens - 1; i++) {
                System.out.println("Token Type: " + convertType(tstream.get(i).getType()));
                System.out.println("Value: " + tstream.get(i).getText());
                output += "Token Type: " + convertType(tstream.get(i).getType()) + "\n";
                output += "Value: " + tstream.get(i).getText() + "\n";
            }
            os.write(output.getBytes(), 0, output.length());
        } catch(IOException e) {System.out.println("File not found");}
        try {
            CharStream cs = CharStreams.fromFileName("./inputs/nested.micro");
            littleLexer lexer = new littleLexer(cs);
            CommonTokenStream tstream = new CommonTokenStream(lexer);
            int tokens = tstream.getNumberOfOnChannelTokens();
            System.out.println(tokens);
            OutputStream os = new FileOutputStream((new File("./outputs/ourNested.out")));
            String output = "";
            for(int i = 0; i < tokens - 1; i++) {
                System.out.println("Token Type: " + convertType(tstream.get(i).getType()));
                System.out.println("Value: " + tstream.get(i).getText());
                output += "Token Type: " + convertType(tstream.get(i).getType()) + "\n";
                output += "Value: " + tstream.get(i).getText() + "\n";
            }
            os.write(output.getBytes(), 0, output.length());
        } catch(IOException e) {System.out.println("File not found");}
    }

    public static String convertType(int type){
        switch(type){
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
                return "WHAT THE FUCK IS THIS?>?>?>";
        }
    }
}
