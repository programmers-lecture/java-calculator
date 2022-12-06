package com.programmers.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int result = 0;

//      연산식 입력받기
        Scanner scanner = new Scanner(System.in);
        String[] expressions = scanner.nextLine().split(" ");

//      입력 받은 데이터로 연산하기(이항)
//      TODO. 삼항이상의 연산
        for (int i = 0; i < expressions.length; i++) {
            if (expressions[i].equals("+")) {
                result = Integer.parseInt(expressions[i - 1]) + Integer.parseInt(expressions[i + 1]);
            } else if (expressions[i].equals("-")) {
                result = Integer.parseInt(expressions[i - 1]) - Integer.parseInt(expressions[i + 1]);
            } else if (expressions[i].equals("*")) {
                result = Integer.parseInt(expressions[i - 1]) * Integer.parseInt(expressions[i + 1]);
            } else if (expressions[i].equals("/")) {
                result = Integer.parseInt(expressions[i - 1]) / Integer.parseInt(expressions[i + 1]);
            }
        }

//        연산 결과 출력
        System.out.println("결과 : " + result);
    }
}