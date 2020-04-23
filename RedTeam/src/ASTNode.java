public class ASTNode {

    private String op, one, two, three;


    public ASTNode(String op, String r1, String r2, String r3) {
        this.op = op;
        this.one = r1;
        this.two = r2;
        this.three = r3;
    }

    public String getR3() {
        return three;
    }

    public void setR3(String r3) {
        this.three = r3;
    }

    public String getR2() {
        return two;
    }

    public void setR2(String r2) {
        this.two = r2;
    }

    public String getR1() {
        return one;
    }

    public void setR1(String r1) {
        this.one = r1;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
}