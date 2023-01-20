import java.util.ArrayList;
import java.util.List;

public class Expression {
    private String[] expression;

    public Expression(String[] expression) {
        this.expression = expression;
    }

    public List<Double> getNumbers() {
        List<Double> numbers = new ArrayList<>();
        for(int i = 0; i < expression.length; i++) {
            if(i % 2 == 0) {
                numbers.add(Double.valueOf(expression[i]));
            }
        }
        return numbers;
    }
    public List<String> getOperators() {
        List<String> operators = new ArrayList<>();
        for(int i = 0; i < expression.length; i++) {
            if(i % 2 == 1) {
                operators.add(expression[i]);
            }
        }
        return operators;
    }
}
