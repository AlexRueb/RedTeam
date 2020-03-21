import java.util.LinkedHashMap;

public class SymbolTable {
    public String scope;
    public LinkedHashMap<String, String> values;

    public SymbolTable(String scope){
        this.scope = scope;
    }
}
