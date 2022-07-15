package dimaProject;

public class WrongIdException extends Exception {
    @Override
    public String getMessage() {
        return "Wrong Id!";
    }

    @Override
    public String toString() {
        return "WrongIdException: " + getMessage();
    }
}
