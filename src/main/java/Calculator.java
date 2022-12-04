import java.util.Arrays;

public class Calculator {
    private Integer firstNumber;
    private Integer secondNumber;
    private Operator operator;

    private static final String NOT_NUMBER="숫자가 아닙니다.";
    private static final String NOT_FOUND_OPERATOR="존재하지 않는 사칙연산 입니다.";
    public Calculator(String firstNumber, String secondNumber, String operation){
        this.firstNumber=validateNumber(firstNumber);
        this.secondNumber=validateNumber(secondNumber);
        this.operator=validateOperator(operation);
    }
    private Integer validateNumber(String a){
        try{
            return Integer.parseInt(a);
        }catch (IllegalStateException e){
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    private Operator validateOperator(String operation){
        return Arrays.stream(Operator.values())
                .filter(x->x.getOperation().equals(operation))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException(NOT_FOUND_OPERATOR));
    }

    public Integer calculateNumber(){
        return operator.calculate(firstNumber,secondNumber);
    }
}
