import java.util.ArrayList;
import java.util.List;

/**
 * Class which represent student
 */
public class Student {
    private String name;
    private List<Double> grades;

    // Constructor
    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    // Getter
    public String getName() {
        return name;
    }

    // Method to add grade
    public void addGrade(double grade) {
        grades.add(grade);
    }

    // Getter
    public List<Double> getGrades() {
        return grades;
    }

    // Method to calculate average grade
    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for(double grade : grades) {
            sum += grade;
        }

        return Math.round((sum / grades.size()) * 100.0) / 100.0;  // Round to 2 decimal places
    }

    // toString method which display the details
    @Override
    public String toString() {
        return "Student: " + name +
                "\nGrades: " + grades +
                "\nAverage Grade: " + calculateAverage();
    }
}
