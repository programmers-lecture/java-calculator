import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum CalculatorType {
    ADD("+",(left,right) -> left + right),
    SUBTRACT("-",(left,right) -> left - right),
    MULTIPLY("*", (left,right) -> left * right),
    DIVIDE("/", (left,right) ->
            // 0처리
            {if (right==0) { throw new ArithmeticException("안됩니다.");};
                 return left / right;
            });

    private String operator;
    private BiFunction<Integer,Integer,Integer> process;

    // <이전결과값, 연산해야할 값, 결과값> : process로 명칭
    CalculatorType(String operator, BiFunction<Integer,Integer,Integer> process) {
        this.operator = operator;
        this.process = process;
    }

    // 이전 결과값, 연산해야할 값
    public int operate(int oldResult, int currentValue){
        return process.apply(oldResult, currentValue);
    }

}

