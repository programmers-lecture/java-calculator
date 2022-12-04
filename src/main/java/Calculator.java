import java.util.Arrays;
import java.util.List;

public class Calculator {
    private Integer firstNumber;
    private Integer secondNumber;
    private static final String NOT_NUMBER="숫자가 아닙니다.";
    public Calculator(String firstNumber, String secondNumber, String operator){
        this.firstNumber=validateNumber(firstNumber);
        this.secondNumber=validateNumber(secondNumber);


    }
    private Integer validateNumber(String a){
        try{
            return Integer.parseInt(a);
        }catch (IllegalStateException e){
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }
}
