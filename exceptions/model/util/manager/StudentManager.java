package manager;

import model.Student;
import exceptions.StudentNotFoundException;
import util.LoadingThread;

public class StudentManager {
    private Student[] students;
    private int count;

    public StudentManager(int size) {
        students = new Student[size];
        count = 0;
    }

    public void addStudent(Student s) {
        if (count == students.length) {
            System.out.println("No space available.");
            return;
        }

        for (int i = 0; i < count; i++) {
            if (students[i].getRollNo() == s.getRollNo()) {
                System.out.println("Roll number already exists.");
                return;
            }
        }

        students[count] = s;
        count++;

        LoadingThread t = new LoadingThread();
        t.start();
        try { t.join(); } catch (Exception e) {}

        System.out.println("Student Added.");
    }

    public void deleteStudent(int rollNo) throws StudentNotFoundException {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNo() == rollNo) {
                index = i;
                break;
            }
        }

        if (index == -1) throw new StudentNotFoundException("Student Not Found.");

        for (int i = index; i < count - 1; i++) {
            students[i] = students[i + 1];
        }

        students[count - 1] = null;
        count--;
        System.out.println("Deleted.");
    }

    public void updateStudent(int rollNo, double newMarks) throws StudentNotFoundException {
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNo() == rollNo) {
                students[i].setMarks(newMarks);
                System.out.println("Updated.");
                return;
            }
        }
        throw new StudentNotFoundException("Student Not Found.");
    }

    public void viewAll() {
        if (count == 0) {
            System.out.println("No Records.");
            return;
        }

        for (int i = 0; i < count; i++) {
            students[i].display();
        }
    }
}
