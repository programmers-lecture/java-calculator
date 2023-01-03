import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;


public class CalculatorMain {
    public static String postfix;
    public static void main(String[] args) { //1+2*3-4/5 - >123*+45/-
        System.out.println("사칙연산 식을 입력해주세요.");

        Scanner sc = new Scanner(System.in);
        String cal = sc.nextLine();

        Stack opratorSt = new Stack(); //  연산자 스택
        postfix = "";
        for(char c : cal.replaceAll(" ", "").toCharArray()) {
            Stream<Operator> stream = Arrays.stream(Operator.values());

            divisionOperator(opratorSt, c);

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
                //연산식 계산
                st.push(Arrays.stream(Operator.values()).filter(i -> i.getOp().equals(expression))
                        .findFirst().get().calculate(Integer.parseInt(st.pop().toString()),Integer.parseInt(st.pop().toString())));
                //st.push(Operator.ADD.formula(Integer.parseInt(st.pop().toString()), Integer.parseInt(st.pop().toString()), expression));
            }
        });
        return Integer.parseInt(st.pop().toString());
    }

    
    public static void divisionOperator(Stack opratorSt, char c) {
        if(Arrays.stream(Operator.values()).anyMatch(i -> i.getOp().equals(String.valueOf(c)))) { //연산자면
            //스택 top < curr -> push
            comparePriority(opratorSt, c);
            return;
        }
        postfix += c + "";
    }

    public static void comparePriority(Stack opratorSt, char c) {
        if(opratorSt.isEmpty() || Operator.ADD.comparePriority((String) opratorSt.peek(), c+"")) {
            opratorSt.push(c + "");
            return;
        }  //보호구문사용 (return) / 삼항연산?
        postfix += opratorSt.pop();
        while (!opratorSt.isEmpty() && !Operator.ADD.comparePriority((String) opratorSt.peek(), c+"")) {
            postfix += opratorSt.pop();
        }
        opratorSt.push(c + "");
        return;
    }
}
