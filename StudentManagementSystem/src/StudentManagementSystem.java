import java.util.HashMap;
import java.util.Map;

public class StudentManagementSystem {
    private static Map<String, Student> students = new HashMap<>();

    /**
     * add student to the system
     * @param name object for student name
     */
    public static void addStudent(String name) {
        if (students.containsKey(name)) {
            System.out.println("Error: Student with name " + name + " already exists");
        } else {
            students.put(name, new Student(name));
            System.out.println("Student with name " + name + " added");
        }
    }

    /**
     * add grade to a specific student
     * @param name object to find specific student in the system
     * @param grade object to give a grade to a specific student
     */
    public static void recordGrade(String name, double grade) {
        Student student = students.get(name);
        if (student == null) {
            System.out.println("Error: Student with name " + name + " does not exist");
        } else if (grade < 0 || grade > 100) {
            System.out.println("Error: Grade must be between 0 and 100");
        } else {
            student.addGrade(grade);
            System.out.println("Grade added for student: " + name);
        }
    }

    /**
     * method to see student details
     * @param name object for getting full information about specific student
     */
    public static void studentDetails(String name) {
        Student student = students.get(name);
        if (student == null) {
            System.out.println("Error: Student with name " + name + " does not exist");
        } else {
            System.out.println(student);
        }
    }

    /**
     * method to see the information about all students
     */
    public static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system");
        } else {
            for (Student student : students.values()) {
                System.out.println(student + "\n---------------");
            }
        }
    }

    /**
     * method to display only those students who has higher average grade than threshold
     * @param threshold for establishing average grade
     */
    public static void displayGoodStudents(double threshold) {
        System.out.println("Students with an average grade above " + threshold + ": ");
        boolean found = false;
        for (Student student : students.values()) {
            if (student.calculateAverage() > threshold) {
                System.out.println(student.getName() + " - Average: " + student.calculateAverage());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with an average grade above " + threshold);
        }
    }

}
