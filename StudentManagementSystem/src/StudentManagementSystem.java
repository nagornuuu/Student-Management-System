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
            throw new IllegalStateException("Error: Student with name " + name + " already exists");
        } else {
            students.put(name, new Student(name));
            System.out.println("Student with name " + name + " added");
        }
    }

    /**
     * add grade to a specific student
     * @param name object to find specific student in the system
     * @param gradeInput string containing grades separated by commas
     */
    public static void recordGrade(String name, String gradeInput) {
        Student student = students.get(name);
        if (student == null) {
            throw new IllegalArgumentException("Error: Student with name " + name + " does not exist");
        } else {
            String[] gradesArray = gradeInput.split(",");
            for (String gradeString : gradesArray) {
                try {
                    double grade = Double.parseDouble(gradeString.trim());
                    if (grade < 0 || grade > 100) {
                        throw new IllegalArgumentException("Error: Grade " + grade + " must be between 0 and 100.");
                    } else {
                        student.addGrade(grade);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Error: Invalid grade '" + gradeString.trim() + "'. Please enter valid numbers.");
                }
            }
            System.out.println("Grades added for student: " + name);
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
