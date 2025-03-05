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

class ProductMain {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        Product[] products = new Product[5];

        // Accept product details
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter Product ID, Price, and Quantity:");
            int pid = sc.nextInt();
            double price = sc.nextDouble();
            int quantity = sc.nextInt();
            products[i] = new Product(pid, price, quantity);
        }

        // Finding product with highest price
        Product highestPricedProduct = products[0];
        for (Product p : products) {
            if (p.price > highestPricedProduct.price) {
                highestPricedProduct = p;
            }
        }
        System.out.println("Product with highest price has ID: " + highestPricedProduct.pid);

        // Calculate total amount spent
        double totalAmount = calculateTotalAmount(products);
        System.out.println("Total amount spent on all products: " + totalAmount);
        sc.close();
    }

    // Method to calculate total amount spent
    public static double calculateTotalAmount(Product[] products) {
        double total = 0;
        for (Product p : products) {
            total += p.price * p.quantity;
        }
        return total;
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

// 1.4 Person and Employee class with inheritance
class Employee extends Person {
    int employeeID;
    double salary;

    // Constructor using super to initialize Person attributes
    public Employee(String name, int age, int employeeID, double salary) {
        super(name, age);
        this.employeeID = employeeID;
        this.salary = salary;
    }

    // Method to display Employee details
    public void displayEmployee() {
        super.display();
        System.out.println("Employee ID: " + employeeID + ", Salary: " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        // Person example
        Person p1 = new Person("John", 25);
        p1.display();

        // Using default constructor
        Person p2 = new Person();
        p2.display();

        // Account example
        Account acc = new Account(5000);
        acc.deposit(2000);
        acc.withdraw(3000);
        acc.displayBalance();

        // Using default constructor
        Account acc2 = new Account();
        acc2.displayBalance();

        // Employee example
        Employee emp = new Employee("Alice", 30, 101, 75000);
        emp.displayEmployee();
    }
}
