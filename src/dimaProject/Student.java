package dimaProject;

import java.util.Arrays;

public class Student {
    private String id;
    private String firstName;
    private String secondName;
    private String averageScore;

    public Student() {

    }

    public Student(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Student(String id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        String line = id + "\t" + firstName + " " + secondName;
        if (averageScore != null) {
            line = line + " \t " + averageScore;
        }
        return line;
    }

    public Student convertStudent(String firstNameAndSecondName) throws WrongStudentNameException {
        String[] strings = firstNameAndSecondName.split(" ");
        System.out.println(Arrays.toString(strings));
        if (strings.length == 2) {
            this.firstName = strings[0];
            this.secondName = strings[1];
        } else {
            throw new WrongStudentNameException();
        }
        return this;
    }

}
