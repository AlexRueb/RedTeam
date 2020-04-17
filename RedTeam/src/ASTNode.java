public class ASTNode {

    public String name;

    public ASTNode(){

    }
}

class BinaryOpNode extends ASTNode {

    public ASTNode left;
    public ASTNode right;
    public String op;

    public BinaryOpNode(ASTNode left, ASTNode right, String op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }
}

class VarRefNode extends  ASTNode {

    public String type;
    public String value;

    public VarRefNode(String type, String value) {
        this.type = type;
        this.value = value;
    }
}

class LiteralNode extends ASTNode {

    public String type;
    public String value;

    public LiteralNode(String type, String value) {
        this.type = type;
        this.value = value;
    }

}

