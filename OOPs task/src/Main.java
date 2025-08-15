import java.util.Scanner;

// 1.1 Person class
class Person {
    String name;
    int age;

    // Default constructor with default age 18
    public Person() {
        this.name = "Unknown";
        this.age = 18;
    }

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display person details
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// 1.2 Product class
class Product {
    int pid;
    double price;
    int quantity;

    // Parameterized constructor
    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }
}

// 1.3 Account class
class Account {
    private double balance;

    // No-argument constructor
    public Account() {
        this.balance = 0;
    }

    // Parameterized constructor
    public Account(double balance) {
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

// 1.4 Employee class extends Person
class Employee extends Person {
    int employeeID;
    double salary;

    public Employee(String name, int age, int employeeID, double salary) {
        super(name, age);
        this.employeeID = employeeID;
        this.salary = salary;
    }

    public void displayEmployee() {
        super.display();
        System.out.println("Employee ID: " + employeeID + ", Salary: " + salary);
    }
}

// ================== MAIN ==================
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Question 1.1 Person Example
        System.out.println("\n--- Q1.1 Person Example ---");
        Person p1 = new Person("John", 25);
        p1.display();

        Person p2 = new Person(); // default constructor
        p2.display();

        // Question 1.2 Product Example
        System.out.println("\n--- Q1.2 Product Example ---");
        Product[] products = new Product[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Product ID, Price, and Quantity:");
            int pid = sc.nextInt();
            double price = sc.nextDouble();
            int quantity = sc.nextInt();
            products[i] = new Product(pid, price, quantity);
        }

        // Highest priced product
        Product highestPricedProduct = products[0];
        for (Product p : products) {
            if (p.price > highestPricedProduct.price) {
                highestPricedProduct = p;
            }
        }
        System.out.println("Product with highest price has ID: " + highestPricedProduct.pid);

        // Total amount
        double totalAmount = 0;
        for (Product p : products) {
            totalAmount += p.price * p.quantity;
        }
        System.out.println("Total amount spent on all products: " + totalAmount);

        // Question 1.3 Account Example
        System.out.println("\n--- Q1.3 Account Example ---");
        Account acc = new Account(1000); // initial balance
        acc.displayBalance();
        acc.deposit(500);
        acc.withdraw(300);
        acc.displayBalance();

        // Question 1.4 Employee Example
        System.out.println("\n--- Q1.4 Employee Example ---");
        Employee e1 = new Employee("Alice", 30, 101, 55000);
        e1.displayEmployee();

        sc.close();
    }
}




// --- Q1.1 Person Example ---
// Name: John, Age: 25
// Name: Unknown, Age: 18

// --- Q1.2 Product Example ---
// Enter Product ID, Price, and Quantity:
// 2 200 3 
// Enter Product ID, Price, and Quantity:
// 1 2000 6 
// Enter Product ID, Price, and Quantity:
// 4 500 5
// Product with highest price has ID: 1
// Total amount spent on all products: 15100.0

// --- Q1.3 Account Example ---
// Current Balance: 1000.0
// Deposited: 500.0
// Withdrawn: 300.0
// Current Balance: 1200.0

// --- Q1.4 Employee Example ---
// Name: Alice, Age: 30
// Employee ID: 101, Salary: 55000.0
