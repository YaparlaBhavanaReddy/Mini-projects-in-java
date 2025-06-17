import java.util.*;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class PhoneBookApp {
    static List<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("📞 Welcome to Java Phonebook App");

        do {
            System.out.println("\n------ Menu ------");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                case 5 -> System.out.println("👋 Exiting Phonebook. Bye!");
                default -> System.out.println("❌ Invalid option.");
            }
        } while (choice != 5);
    }

    static void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();
        contacts.add(new Contact(name, phone));
        System.out.println("✅ Contact added.");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("📭 No contacts found.");
        } else {
            System.out.println("\n📇 Contact List:");
            for (int i = 0; i < contacts.size(); i++) {
                Contact c = contacts.get(i);
                System.out.printf("%d. %s - %s\n", i + 1, c.name, c.phone);
            }
        }
    }

    static void searchContact() {
        System.out.print("🔍 Enter name to search: ");
        String name = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Contact c : contacts) {
            if (c.name.toLowerCase().contains(name)) {
                System.out.println("✅ Found: " + c.name + " - " + c.phone);
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No contact found with that name.");
        }
    }

    static void deleteContact() {
        viewContacts();
        if (!contacts.isEmpty()) {
            System.out.print("Enter contact number to delete: ");
            int index = sc.nextInt();
            sc.nextLine(); // consume newline

            if (index > 0 && index <= contacts.size()) {
                contacts.remove(index - 1);
                System.out.println("🗑️ Contact deleted.");
            } else {
                System.out.println("⚠️ Invalid number.");
            }
        }
    }
}
