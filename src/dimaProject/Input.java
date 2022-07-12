package dimaProject;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String input(String line) {
        System.out.print(line);
        String value = scanner.nextLine();
        return value;
    }
}
