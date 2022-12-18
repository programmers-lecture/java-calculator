import java.util.Arrays;

public enum Operator {
    ADD("+", 0), MINUS("-", 0), MULTIPLY("*", 1), DIVIDE("/", 1);

    private final String op;
    private final int val;
    Operator(String op , int val) {
        this.op = op;
        this.val = val;
    }

    public String getOp() {
        return this.op;
    }
    public int getVal() { return  this.val; }

    public boolean comparePriority(String op1, String op2) {
       int num1 = Arrays.stream(Operator.values()).filter(i -> i.getOp().equals(op1)).findFirst().get().getVal();
       int num2 = Arrays.stream(Operator.values()).filter(i -> i.getOp().equals(op2)).findFirst().get().getVal();
       return num1 < num2 ? true : false;
    }

    //연산식 계산
    public  int formula(int first , int second, String op) {
        switch (op) {
            case "+" :
                return second + first;
            case "-":
                return second - first;
            case "*":
                return second * first;
            case "/":
                return second / first;
        }
        return 0;
    }
}
