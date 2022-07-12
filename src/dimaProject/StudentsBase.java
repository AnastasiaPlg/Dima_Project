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

    public Connection createConnection(String user, String pass) throws SQLException {
        this.user = user;
        this.pass = pass;
        ResultSet resultSet = null;
        Connection connection = DriverManager.getConnection(this.url, user, pass);
        assert connection != null : "connection is null";
        return connection;
    }

    public List<Student> getAllStudents(Connection connection) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String firstName = resultSet.getString("firstName");
            String secondName = resultSet.getString("secondName");
            Student student = new Student(id, firstName, secondName);
            students.add(student);
        }
        return students;
    }

    public void addStudent(Connection connection, Student student) throws SQLException {
        String sql = "INSERT INTO students(firstName, secondName) VALUES ('" + student.getFirstName() + "', '" + student.getSecondName() + "')";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        System.out.println("Student " + student.getFirstName() + " " + student.getSecondName() + " was added.");
    }

    public void addAverageScore(Connection connection, Student student, String averageScore) throws SQLException {
        String sql = "UPDATE students SET averageScore = " + averageScore + " WHERE students.firstName = ? AND students.secondName = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, student.getFirstName());
        statement.setString(2, student.getSecondName());
        System.out.println("Average score for student " + student + " was added.");
    }

    public void deleteElement(PreparedStatement statement, String id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = " + id;
        statement.execute(sql);
        System.out.println("Element with id = " + id + " was deleted from table students");
    }
}
