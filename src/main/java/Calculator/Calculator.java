package Calculator;

import java.awt.desktop.OpenFilesEvent;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();

        String[] values = expression.split(" ");
        System.out.println(calculate(values));
        scan.close();
    }

    public static int calculate(String[] values) {
        Operator operator;
        int nextValue;
        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            nextValue = Integer.parseInt(values[i + 1]);
            operator = Operator.findOperator(values[i]);
            result = operator.operate(result, nextValue);
        }
        return result;
    }

}
