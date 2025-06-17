import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class EcommerceApp {
    static List<Product> productList = new ArrayList<>();
    static Map<Product, Integer> cart = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadProducts();
        int choice;

        System.out.println("🛒 Welcome to Java E-Commerce App!");

        do {
            System.out.println("\n------ Menu ------");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> viewProducts();
                case 2 -> addToCart();
                case 3 -> viewCart();
                case 4 -> checkout();
                case 5 -> System.out.println("🙏 Thank you for shopping with us!");
                default -> System.out.println("❌ Invalid option.");
            }
        } while (choice != 5);
    }

    static void loadProducts() {
        productList.add(new Product(1, "Laptop", 55000));
        productList.add(new Product(2, "Smartphone", 18000));
        productList.add(new Product(3, "Headphones", 1200));
        productList.add(new Product(4, "Keyboard", 700));
        productList.add(new Product(5, "Monitor", 8500));
    }

    static void viewProducts() {
        System.out.println("\n📦 Available Products:");
        for (Product p : productList) {
            System.out.printf("%d. %s - ₹%.2f\n", p.id, p.name, p.price);
        }
    }

    static void addToCart() {
        viewProducts();
        System.out.print("Enter product ID to add to cart: ");
        int id = sc.nextInt();
        Product selected = null;

        for (Product p : productList) {
            if (p.id == id) {
                selected = p;
                break;
            }
        }

        if (selected != null) {
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            cart.put(selected, cart.getOrDefault(selected, 0) + qty);
            System.out.println("✅ Added to cart.");
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("🛍️ Cart is empty.");
        } else {
            System.out.println("\n🛒 Your Cart:");
            double total = 0;
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                Product p = entry.getKey();
                int qty = entry.getValue();
                double cost = p.price * qty;
                total += cost;
                System.out.printf("%s x%d = ₹%.2f\n", p.name, qty, cost);
            }
            System.out.printf("🧾 Total: ₹%.2f\n", total);
        }
    }

    static void checkout() {
        viewCart();
        if (!cart.isEmpty()) {
            System.out.println("✅ Order placed successfully!");
            cart.clear();
        }
    }
}
