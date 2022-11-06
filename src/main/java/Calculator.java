import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String[] operationArray = {"+", "-", "/", "*"};
        ArrayList<String>  operations = new ArrayList<>(Arrays.asList(operationArray));

        int result = 0;                                // 계산 결과값 저장 변수

        Scanner sc = new Scanner(System.in);
        System.out.println("계산식을 입력하세요.");
        String input = sc.nextLine();
        sc.close();

        String[] splitInput = input.split(" "); // 문자열 입력을 공백기준으로 분리

        for(int i = 0; i < splitInput.length; i++) {
            // 첫 연산자라면, 연산자 앞뒤 정수들과 계산 후 result에 값 저장
            if (i == 1) {
                if (splitInput[i].equals("+")) {
                    result += Integer.parseInt(splitInput[i - 1]) + Integer.parseInt(splitInput[i + 1]);
                } else if (splitInput[i].equals("-")) {
                    result += Integer.parseInt(splitInput[i - 1]) - Integer.parseInt(splitInput[i + 1]);
                } else if (splitInput[i].equals("/")) {
                    result += Integer.parseInt(splitInput[i - 1]) / Integer.parseInt(splitInput[i + 1]);
                } else {
                    result += Integer.parseInt(splitInput[i - 1]) * Integer.parseInt(splitInput[i + 1]);
                }
            }
            // TODO: 사착연산 우선순위 구현 필요
            // result 값과 연산자 다음 정수와 계산
            else if(i % 2 == 1) {
                if (splitInput[i].equals("+")) {
                    result += Integer.parseInt(splitInput[i + 1]);
                    System.out.println(result);
                } else if (splitInput[i].equals("-")) {
                    result -= Integer.parseInt(splitInput[i + 1]);
                    System.out.println(result);
                } else if (splitInput[i].equals("/")) {
                    result /= Integer.parseInt(splitInput[i + 1]);
                    System.out.println(result);
                } else {
                    result *= Integer.parseInt(splitInput[i + 1]);
                    System.out.println(result);
                }
            }
        }
        System.out.println("결과: " + result);
    }
}
