import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public List<Double> getGrades() {
        return grades;
    }

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

    @Override
    public String toString() {
        return "Student: " + name +
                "\nGrades: " + grades +
                "\nAverage Grade: " + calculateAverage();
    }
}
