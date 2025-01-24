import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        System.out.println("Welcome to the Student Management System");
        while (flag) {
            System.out.println("\nMenu:" +
                               "\n1. Add Student" +
                               "\n2. Record Grade" +
                               "\n3. View student details" +
                               "\n4. Display all students" +
                               "\n5. View High-Perdorming student" +
                               "\n6. Exit");
            System.out.print("Choose an option: ");

            try {
                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Enter Student name: ");
                        String name = sc.nextLine();
                        try {
                            StudentManagementSystem.addStudent(name);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "2":
                        System.out.print("Enter Student name: ");
                        name = sc.nextLine();
                        System.out.print("Enter grade(comma-separated): ");
                        String gradesInput = sc.nextLine();
                        try {
                            StudentManagementSystem.recordGrade(name, gradesInput);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "3":
                        System.out.print("Enter Student name: ");
                        name = sc.nextLine();
                        StudentManagementSystem.studentDetails(name);
                        break;
                    case "4":
                        StudentManagementSystem.displayAllStudents();
                        break;
                    case "5":
                        System.out.print("Enter grade threshold: ");
                        try {
                            double threshold = Double.parseDouble(sc.nextLine());
                            StudentManagementSystem.displayGoodStudents(threshold);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Please enter a valid number threshold");
                        }
                        break;
                    case "6":
                        flag = false;
                        System.out.println("Exit. Goodbye!");
                        break;
                    default:
                        System.out.println("Error: Please enter a valid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}