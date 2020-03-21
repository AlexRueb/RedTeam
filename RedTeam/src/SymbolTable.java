import java.util.Map;

public class SymbolTable {
    public String scope;
    public Map<String, String> values;

    public SymbolTable(String scope){
        this.scope = scope;
    }
}
