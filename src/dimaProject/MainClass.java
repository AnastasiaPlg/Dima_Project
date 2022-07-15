package dimaProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MainClass {
    public static void main(String[] args) {
        String user = "postgres";
        String pass = "root";
        try {
            StudentsBase studentsBase = StudentsBase.getStudentsBase();
            Statement statement = studentsBase.createConnection(user, pass);
            while (true) {
                Student student = Input.inputStudent();
                studentsBase.addStudent(statement, student);
                student.setAverageScore(Input.inputAverageScore());
                studentsBase.addAverageScore(statement, student);
                System.out.println(studentsBase.findStudent(statement, Input.inputId()));
                System.out.println(studentsBase.findGreatStudents(studentsBase.getAllStudents(statement), 8.0).toString());
                if (Input.isEnough()) {
                    break;
                }
            }
        } catch (SQLException | WrongIdException e) {
            System.out.println(e);
        }
    }
}
