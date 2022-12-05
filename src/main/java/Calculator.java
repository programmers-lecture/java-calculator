import java.util.Scanner;

public class Calculator {

    private String[] formula;

    public void insertFormula() {
        Scanner scanner = new Scanner(System.in);
        this.formula = scanner.nextLine().split(" ");
    }

    public double getResult() {
        double result = Double.parseDouble(formula[0]);

        for(int i=1; i<formula.length; i+=2) {
            String op = formula[i];
            if(op.equals("+")) {
                result += Double.parseDouble(formula[i+1]);
            } else if(op.equals("-")) {
                result -= Double.parseDouble(formula[i+1]);
            } else if(op.equals("*")) {
                result *= Double.parseDouble(formula[i+1]);
            } else if(op.equals("/")) {
                result /= Double.parseDouble(formula[i+1]);
            }
        }
        return result;
    }
}
