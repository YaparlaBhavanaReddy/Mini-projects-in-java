import java.util.Scanner;

public class SmartCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("🧠 Welcome to Smart Calculator");

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Arithmetic Calculator (Numbers)");
            System.out.println("2. Alphabet ASCII Calculator (A + B etc.)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // clear buffer

            switch (choice) {
                case 1 -> numberCalculator(sc);
                case 2 -> asciiCalculator(sc);
                case 3 -> System.out.println("👋 Exiting...");
                default -> System.out.println("❌ Invalid Choice");
            }
        } while (choice != 3);
    }

    // ➕ Arithmetic with numbers
    static void numberCalculator(Scanner sc) {
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter operator (+ - * /): ");
        char op = sc.next().charAt(0);
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        double result = 0;
        boolean valid = true;

        switch (op) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> {
                if (b != 0) result = a / b;
                else {
                    System.out.println("⚠️ Cannot divide by zero.");
                    valid = false;
                }
            }
            default -> {
                System.out.println("❌ Invalid operator.");
                valid = false;
            }
        }

        if (valid)
            System.out.printf("🧮 Result: %.2f %c %.2f = %.2f\n", a, op, b, result);
    }

    // 🔠 Calculator for characters (ASCII based)
    static void asciiCalculator(Scanner sc) {
        System.out.print("Enter first character: ");
        char a = sc.next().charAt(0);
        System.out.print("Enter operator (+ - * /): ");
        char op = sc.next().charAt(0);
        System.out.print("Enter second character: ");
        char b = sc.next().charAt(0);

        int asciiA = (int) a;
        int asciiB = (int) b;
        int result = 0;
        boolean valid = true;

        switch (op) {
            case '+' -> result = asciiA + asciiB;
            case '-' -> result = asciiA - asciiB;
            case '*' -> result = asciiA * asciiB;
            case '/' -> {
                if (asciiB != 0) result = asciiA / asciiB;
                else {
                    System.out.println("⚠️ Division by zero.");
                    valid = false;
                }
            }
            default -> {
                System.out.println("❌ Invalid operator.");
                valid = false;
            }
        }

        if (valid) {
            System.out.printf("🔡 ASCII Calc: '%c'(=%d) %c '%c'(=%d) = %d\n",
                    a, asciiA, op, b, asciiB, result);
        }
    }
}
