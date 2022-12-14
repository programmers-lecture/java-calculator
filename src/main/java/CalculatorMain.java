import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


public class CalculatorMain {
    public static void main(String[] args) { //1+2*3-4/5
        System.out.println("사칙연산 식을 입력해주세요.");

        Scanner sc = new Scanner(System.in);
        String cal = sc.nextLine();



        Stack opratorSt = new Stack(); //  연산자 스택
        String postfix = "";
        for(char c : cal.replaceAll(" ", "").toCharArray()) {
            Stream<operator> stream = Arrays.stream(operator.values());

            if(Arrays.stream(operator.values()).anyMatch( i -> i.getOp().equals(String.valueOf(c)))) { //연산자면
                //스택 top < curr -> push
                if(opratorSt.isEmpty() || operator.ADD.comparePriority((String) opratorSt.peek(), c+"")) {
                    opratorSt.push(c + "");
                } else {
                    postfix += opratorSt.pop();
                    while (!opratorSt.isEmpty() && !operator.ADD.comparePriority((String) opratorSt.peek(), c+"")) {
                        postfix += opratorSt.pop();
                    }
                    opratorSt.push(c + "");
                }
                //스책 top >= curr -> 게속 스트링에 ++
            } else postfix += c + "";
        }
        while (!opratorSt.isEmpty()) postfix += opratorSt.pop();
        int calculator = calculator(postfix);

        System.out.println("결과 값 " + calculator);
    }

    //후순위 순서대로 계산
    public static int calculator(String postfix) {
        Stack st = new Stack();
        Arrays.stream(postfix.split("")).forEach(expression -> {
            if(Character.isDigit(expression.charAt(0))) {
                st.push(expression);
            }else {

                st.push(formula(Integer.parseInt(st.pop().toString()), Integer.parseInt(st.pop().toString()), expression));
            }
        });


        return Integer.parseInt(st.pop().toString());
    }

    //연산식 계산
    public static int formula(int first , int second, String op) {
        switch (op) {
            case "+" :
                return second + first;
            case "-":
                return second - first;
            case "*":
                return second * first;
            case "/":
                return second / first;
        }
        return 0;
    }


}
