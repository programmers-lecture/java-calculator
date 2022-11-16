package controller;

import view.InputView;
import view.OutputView;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    public void start() {
        System.out.println("문자열 계산기를 시작합니다.");

        // 사용자 입력
        String input = InputView.read();

        // 계산기 로직
        Integer answer = 0;
        Queue<Character> queue = new LinkedList<>();
        for (Character c: input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                continue;
            }
            queue.add(c);
        }

        while (!queue.isEmpty()) {
            int num1 = queue.poll() - '0';
            char operator = queue.poll();
            int num2 = queue.poll() - '0';
            answer = calculate(num1, num2, operator);
        }

        // 결과 출력
        OutputView.print(answer);
        System.out.println("문자열 계산기를 종료합니다.");
    }

    private Integer calculate(int number1, int number2, char operator) {
        int result = 0;
        if (operator == '+') {
            result = number1 + number2;
        } else if (operator == '-') {
            result = number1 - number2;
        } else if (operator == '*') {
            result = number1 * number2;
        } else if (operator == '/') {
            result = number1 / number2;
        }
        return result;
    }
}
