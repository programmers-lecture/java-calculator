package calculator.view;

import java.util.Scanner;

public class calculatorView {
    public String[] input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("계산식을 입력하세요.");
        String input = sc.nextLine();
        sc.close();

        String[] splitInput = input.split(" "); // 문자열 입력을 공백기준으로 분리
        return splitInput;
    }
    public void output(int result) {
        System.out.println("결과: " + result);
    }
}
