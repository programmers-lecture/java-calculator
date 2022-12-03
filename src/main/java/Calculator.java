public class Calculator {
    public double getResult(String[] formula) {
        double result = Integer.parseInt(formula[0]);

        for(int i=1; i<formula.length; i+=2) {
            String op = formula[i];
            if(op.equals("+")) {
                result += Integer.parseInt(formula[i+1]);
            } else if(op.equals("-")) {
                result -= Integer.parseInt(formula[i+1]);
            } else if(op.equals("*")) {
                result *= Integer.parseInt(formula[i+1]);
            } else if(op.equals("/")) {
                result /= Integer.parseInt(formula[i+1]);
            }
        }
        return result;
    }
}
