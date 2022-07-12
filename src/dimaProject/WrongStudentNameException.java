package dimaProject;

public class WrongStudentNameException extends Exception {
    @Override
    public String getMessage() {
        return "Wrong student name!";
    }

    @Override
    public String toString() {
        return "WrongStudentNameException: " + getMessage();
    }
}
