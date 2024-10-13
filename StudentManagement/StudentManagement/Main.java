package StudentManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    ArrayList<Student> students = new ArrayList<Student>();

    // Method to print all students
    void PrintList() {
        System.out.println("\tStudent Information List");
        System.out.println("\t*********************");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    // Method to add a new student
    void AddStudent(String id, String name, double marks) {
        Student stu = new Student(id, name, marks);
        students.add(stu);
    }

    // Method to edit a student by ID
    void EditStudent(String id, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getID().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                System.out.println("Student with ID " + id + " has been updated.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Method to delete a student by ID
    void DeleteStudentByID(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID().equals(id)) {
                students.remove(i);
                System.out.println("Student with ID " + id + " has been removed.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Method to find a student by ID
    void FindStudent(String id) {
        for (Student student : students) {
            if (student.getID().equals(id)) {
                System.out.println(student.toString());
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Method to sort students by marks using Selection Sort (Ascending order)
    void SelectionSortByMarks() {
        System.out.println("Sorting by marks using Selection Sort (Ascending)... ");
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students.get(j).getMarks() < students.get(minIndex).getMarks()) {
                    minIndex = j;
                }
            }
            Collections.swap(students, i, minIndex);
        }
        PrintList();
    }

    // Method to sort students by marks using Bubble Sort (Ascending order)
    void BubbleSortByMarks() {
        System.out.println("Sorting by marks using Bubble Sort (Ascending)... ");
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    Collections.swap(students, j, j + 1);
                }
            }
        }
        PrintList();
    }

    // Menu display and main logic
    void Start() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\tMENU");
            System.out.println("1. Display all students");
            System.out.println("2. Add new student");
            System.out.println("3. Edit student");
            System.out.println("4. Delete student");
            System.out.println("5. Sort students by marks");
            System.out.println("6. Search student by ID");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    PrintList();
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    String id = sc.next();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter marks: ");
                    double marks = sc.nextDouble();
                    AddStudent(id, name, marks);
                    break;
                case 3:
                    System.out.print("Enter the ID of the student to edit: ");
                    String editID = sc.next();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new marks: ");
                    double newMarks = sc.nextDouble();
                    EditStudent(editID, newName, newMarks);
                    break;
                case 4:
                    System.out.print("Enter the ID of the student to delete: ");
                    String delID = sc.next();
                    DeleteStudentByID(delID);
                    break;
                case 5:
                    // Allow user to choose sorting algorithm
                    System.out.println("Choose sorting algorithm:");
                    System.out.println("1. Bubble Sort (Ascending)");
                    System.out.println("2. Selection Sort (Ascending)");
                    int sortChoice = sc.nextInt();
                    if (sortChoice == 1) {
                        BubbleSortByMarks();
                    } else if (sortChoice == 2) {
                        SelectionSortByMarks();
                    } else {
                        System.out.println("Invalid choice. Sorting aborted.");
                    }
                    break;
                case 6:
                    System.out.print("Enter the ID of the student to search for: ");
                    String searchID = sc.next();
                    FindStudent(searchID);
                    break;
                default:
                    System.out.println("Exiting the program.");
                    break;
            }
        } while (choice != 7);
        sc.close();
    }

    public static void main(String[] args) {
        Main studentManager = new Main();
        studentManager.Start();
    }
}
