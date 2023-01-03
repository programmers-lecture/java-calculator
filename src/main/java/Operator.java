import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", 0, (num1 , num2) -> num2 + num1),
    MINUS("-", 0, (num1, num2) -> num2 - num1),
    MULTIPLY("*", 1, (num1, num2) -> num2 * num1),
    DIVIDE("/", 1, (num1, num2) -> num2 / num1);

    private final String op;
    private final int val;

    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String op, int val, BiFunction<Integer, Integer, Integer> expression) {
        this.op = op;
        this.val = val;
        this.expression = expression;
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
 

    public int calculate(int num1, int num2) {
        return expression.apply(num1, num2);
    }
}
