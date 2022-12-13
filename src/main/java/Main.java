import controller.Calculator;
import view.InputView;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] expression = InputView.input();
        System.out.println(Arrays.toString(expression));

        double result = Double.parseDouble(expression[0]);
        String operator = "";
        double next_num = 0;

        for (int i = 1; i < expression.length; i++){
            if (i%2 != 0){
                operator = expression[i];
                continue;
            }
            next_num = Double.parseDouble(expression[i]);
            result = Calculator.calculate(operator,result,next_num);
        }
        System.out.println("결과 : " + result);

    }
}
