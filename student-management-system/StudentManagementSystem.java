import java.util.*;

public class StudentManagementSystem {

    // Inner Student class
    static class Student {
        private int id;
        private String name;
        private int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void displayInfo() {
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }
    }

    // List to store students
    private static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> viewStudents();
                case 3 -> searchStudent(scanner);
                case 4 -> deleteStudent(scanner);
                case 5 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        scanner.nextLine(); // consume leftover newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();

        Student s = new Student(id, name, age);
        studentList.add(s);
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- List of Students ---");
        for (Student s : studentList) {
            s.displayInfo();
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();

        boolean found = false;
        for (Student s : studentList) {
            if (s.getId() == id) {
                s.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        Iterator<Student> iterator = studentList.iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId() == id) {
                iterator.remove();
                removed = true;
                System.out.println("Student deleted.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student not found.");
        }
    }
}
