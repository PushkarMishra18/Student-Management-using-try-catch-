import java.util.Scanner;
import model.Student;
import manager.StudentManager;
import exceptions.StudentNotFoundException;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int size = sc.nextInt();

        StudentManager manager = new StudentManager(size);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Marks");
            System.out.println("4. View All");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            try {
                if (ch == 1) {
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();

                    Student s = new Student(roll, name, email, course, marks);
                    manager.addStudent(s);
                }

                else if (ch == 2) {
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    manager.deleteStudent(roll);
                }

                else if (ch == 3) {
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    System.out.print("New Marks: ");
                    double marks = sc.nextDouble();
                    manager.updateStudent(roll, marks);
                }

                else if (ch == 4) {
                    manager.viewAll();
                }

                else if (ch == 5) {
                    System.out.println("Exiting...");
                    break;
                }

                else {
                    System.out.println("Invalid Choice");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
