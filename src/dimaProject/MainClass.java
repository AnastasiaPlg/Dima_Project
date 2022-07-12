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
            Connection connection = studentsBase.createConnection(user,pass);
            //studentsBase.getAllStudents(connection).forEach(System.out::println);
            String studentStr = Input.input("Enter full name of student: ");
            Student student = new Student();
            student = student.convertStudent(studentStr);
            //studentsBase.addStudent(connection, student);
            studentsBase.addAverageScore(connection, student, "9.0");
        } catch (SQLException | WrongStudentNameException e) {
            System.out.println(e);
        }
    }
}
