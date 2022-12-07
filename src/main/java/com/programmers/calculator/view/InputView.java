package com.programmers.calculator.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String[] input() {
        return scanner.nextLine().split(" ");
    }
}