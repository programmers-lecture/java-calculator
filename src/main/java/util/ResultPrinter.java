package util;

import calculator.expression.Operand;

public class ResultPrinter {
    public static <T> void print(Operand<T> operand){
        System.out.println("결과 : "+operand.getValue().toString());
    }
}
