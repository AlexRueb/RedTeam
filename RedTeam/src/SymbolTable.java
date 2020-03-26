import java.util.LinkedHashMap;

public class SymbolTable {
    public String name;
    public LinkedHashMap<String, String> values;

    public SymbolTable(String name){

        this.name = name;
        this.values = new LinkedHashMap<>();
    }


    public String getName(){
        return name;
    }


}
