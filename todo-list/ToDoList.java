import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("📝 Welcome to the To-Do List App!");

        do {
            System.out.println("\n-----------------------------");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> removeTask();
                case 4 -> System.out.println("👋 Exiting To-Do List. Bye!");
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    static void addTask() {
        System.out.print("Enter the task: ");
        String task = sc.nextLine();
        tasks.add(task);
        System.out.println("✅ Task added!");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📭 No tasks in your list.");
        } else {
            System.out.println("🗂️ Your Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    static void removeTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter the task number to remove: ");
            int index = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (index > 0 && index <= tasks.size()) {
                tasks.remove(index - 1);
                System.out.println("🗑️ Task removed!");
            } else {
                System.out.println("⚠️ Invalid task number.");
            }
        }
    }
}
