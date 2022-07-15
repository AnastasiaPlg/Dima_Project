package dimaProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsBase {
    private String host;
    private String port;
    private String base;
    private String user;
    private String pass;
    private String url;

    private static StudentsBase studentsBase;

    private StudentsBase(String host, String port, String base) {
        this.host = host;
        this.port = port;
        this.base = base;
        this.url = "jdbc:postgresql://" + host + ":" + port + "/" + base;
    }
    public static StudentsBase getStudentsBase() {
        if (studentsBase == null) {
            studentsBase = new StudentsBase("127.0.0.1", "5432", "postgres");
        }
        return studentsBase;
    }

    public Statement createConnection(String user, String pass) throws SQLException {
        this.user = user;
        this.pass = pass;
        ResultSet resultSet = null;
        Connection connection = DriverManager.getConnection(this.url, user, pass);
        assert connection != null : "connection is null";
        return connection.createStatement();
    }

    public List<Student> getAllStudents(Statement statement) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String firstName = resultSet.getString("firstName");
            String secondName = resultSet.getString("secondName");
            double averageScore = resultSet.getDouble("averageScore");
            Student student = new Student(id, firstName, secondName, averageScore);
            students.add(student);
        }
        return students;
    }

    public void addStudent(Statement statement, Student student) throws SQLException {
        String sql = "INSERT INTO students(firstName, secondName) VALUES ('" + student.getFirstName()
                + "', '" + student.getSecondName() + "')";
        statement.execute(sql);
        System.out.println("Student " + student.getFirstName() + " " + student.getSecondName() + " was added.");
    }

    public void addAverageScore(Statement statement, Student student) throws SQLException {
        String sql = "UPDATE students SET averageScore = " + student.getAverageScore()
                + " WHERE students.firstName = '" + student.getFirstName()
                + "' AND students.secondName = '" + student.getSecondName() + "'";
       statement.execute(sql);
        System.out.println("Average score for student " + student + " was added.");
    }

    public void deleteStudent(Statement statement, String id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = " + id;
        statement.execute(sql);
        System.out.println("Student with id = " + id + " was deleted from table students");
    }

    public Student findStudent (Statement statement, String id) throws SQLException {
        Student student = new Student();
        String sql = "SELECT * FROM students WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            student.setId(resultSet.getString("id"));
            student.setFirstName(resultSet.getString("firstName"));
            student.setSecondName(resultSet.getString("secondName"));
            student.setAverageScore(resultSet.getDouble("averageScore"));
        }
        return student;
    }

    public List<Student> findGreatStudents(List<Student> listOfStudents, double minAverageScore) {
       return listOfStudents.stream().filter(student -> (student.getAverageScore() >= minAverageScore))
               .sorted((o1, o2) -> {
                   int result = 0;
                   if (o1.getAverageScore() > o2.getAverageScore()) {
                       result = -1;
                   }
                   if (o1.getAverageScore() < o2.getAverageScore()) {
                       result = 1;
                   }
                   return result;
               }).toList();
    }

}
