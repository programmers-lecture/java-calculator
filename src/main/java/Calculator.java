import java.util.Scanner;
import java.util.Stack;

public class Calculator {

    public static double calculate(String[] formula) {

        Stack<Double> numbers = new Stack<>();         // 숫자 저장 배열
        Stack<String> operators = new Stack<>();         // 사칙연산 부호 저장 배열

        // 맨 처음 숫자 number stack에 저장
        double result = Double.parseDouble(formula[0]);
        numbers.push(result);

        for(int i=1; i<formula.length; i+=2) {
            if (formula[i].equals("*")) {           // 곱하기 연산이 나오면 저장하지 않고 먼저 계산
                result = Operator.MULTIPLY.apply(numbers.pop(), Double.parseDouble(formula[i+1]));
                numbers.push(result);               // 계산 결과값 number stack에 저장
            } else if (formula[i].equals("/")) {    // 나누기 연산도 마찬가지로 저장하지 않고 먼저 계산
                result = Operator.DIVIDE.apply(Double.parseDouble(formula[i - 1]), Double.parseDouble(formula[i + 1]));
                numbers.push(result);                // 계산 결과값 number stack에 저장
            } else {            // 더하기, 빼기 연산자가 나올 경우 일단 number stack, operators stack에 저장
                numbers.push(Double.parseDouble(formula[i+1]));
                operators.push(formula[i]);
            }
        }

        // 우선적으로 계산해줘야하는 연산자들(곱하기, 나누기)를 제외한 stack에 남아있는 연산들(더하기, 빼기) 수행
        for(int i=0; i<operators.size(); i++) {
            if (operators.get(i).equals("+")) {
                result = Operator.PLUS.apply(numbers.pop(), numbers.pop());
                numbers.push(result);
            } else {
                result = Operator.SUBTRACT.apply(numbers.pop(), numbers.pop());
                numbers.push(result);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] formula = input.split(" ");
        double result = calculate(formula);
        System.out.println("결과 : " + result);
    }

}
