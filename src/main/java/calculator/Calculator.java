package calculator;

public class Calculator {

    public int start(String input){
        String[] values = input.split(" ");

        int result = Integer.parseInt(values[0]);

        for(int i = 0; i < values.length-2; i+=2){
            int firstNum = result;
            String operation = values[i+1];
            int secondNum = Integer.parseInt(values[i+2]);
            result = Operator.calculate(operation, firstNum, secondNum);
        }

        return result;
    }
}
