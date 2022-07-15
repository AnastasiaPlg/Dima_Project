package dimaProject;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputId() throws WrongIdException {
        System.out.print("Enter student's Id: ");
        String id = scanner.nextLine();
        if (!id.matches("\\d+")) {
            throw new WrongIdException();
        }
        return id;
    }

    public static double inputAverageScore() {
        System.out.print("Enter student's average score: ");
        double value = scanner.nextDouble();
        return value;
    }

    public static Student inputStudent() {
        System.out.print("Enter student's first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student's second name: ");
        String secondName = scanner.nextLine();
        return new Student(firstName, secondName);
    }

    public static boolean isEnough() {
        boolean result = false;
        System.out.print("Enter \"exit\" if you want to stop the program or press Enter to continue: ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("exit")) {
            result = true;
        }
        return result;
    }
}
