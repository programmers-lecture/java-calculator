package com.programmers.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
//      연산식 입력받기
        Scanner scanner = new Scanner(System.in);
        String[] expressions = scanner.nextLine().split(" ");

//      연산 결과값 변수 초기화
        int result = Integer.parseInt(expressions[0]);

//      입력 받은 데이터로 사칙연산하기
        for (int i = 0; i < expressions.length; i++) {
            if (expressions[i].equals("+")) {
                result += Integer.parseInt(expressions[i + 1]);
            } else if (expressions[i].equals("-")) {
                result -= Integer.parseInt(expressions[i + 1]);
            } else if (expressions[i].equals("*")) {
                result *= Integer.parseInt(expressions[i + 1]);
            } else if (expressions[i].equals("/")) {
                result /= Integer.parseInt(expressions[i + 1]);
            }
        }

//      연산 결과 출력
        System.out.println("결과 : " + result);
    }
}