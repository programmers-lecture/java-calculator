package stringCalculator;

import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern regExp = Pattern.compile("^[0-9]*$"); //operand, operator 구분 용도

    public int calculate(String[] inputExp){

        int result = 0;
        // 맨처음 숫자 더해짐
        Operator currentOperator = Operator.PLUS;

        for(String input : inputExp){
            if(regExp.matcher(input).find()){
                result = currentOperator.operate(result, Integer.parseInt(input));
                continue;
            }
            // 연산자 매칭
            for(Operator operator : Operator.values()){
                if(operator.getSymbol().equals(input)){
                    currentOperator = operator;
                }
            }
        }

        return result;
    }
}
