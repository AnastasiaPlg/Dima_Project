package dimaProject;

import java.util.Arrays;

public class Student {
    private String id;
    private String firstName;
    private String secondName;
    private double averageScore;

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

    public Student(String id, String firstName, String secondName, double averageScore) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.averageScore = averageScore;
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

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        String line = "";
        if (id != null && averageScore != 0) {
            line = id + "\t" + firstName + " " + secondName + ", average score: " + averageScore;
        } else if (id != null) {
            line = id + "\t" + firstName + " " + secondName;
        } else {
            line = firstName + " " + secondName;
        }
        return line;
    }
}
