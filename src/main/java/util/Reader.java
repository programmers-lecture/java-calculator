package util;

import java.util.Scanner;

public class Reader {
    private static final Scanner scanner = new Scanner(System.in);

    public static String read() {
        return scanner.nextLine();
    }
}
