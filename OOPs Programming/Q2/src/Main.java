import java.util.Scanner;

// Interface Taxable
interface Taxable {
    double SALES_TAX = 0.07;
    double INCOME_TAX = 0.105;

    double calcTax();
}

// Employee class implementing Taxable
class Employee implements Taxable {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calcTax() {
        return salary * INCOME_TAX;
    }

    public void displayTax() {
        System.out.println("Income Tax for " + name + ": " + calcTax());
    }
}

// Product class implementing Taxable
class Product implements Taxable {
    private String productName;
    private double unitPrice;
    private int quantity;

    public Product(String productName, double unitPrice, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @Override
    public double calcTax() {
        return (unitPrice * quantity) * SALES_TAX;
    }

    public void displayTax() {
        System.out.println("Sales Tax for " + productName + ": " + calcTax());
    }
}

// Main class
class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept Employee information
        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        Employee employee = new Employee(empName, salary);
        employee.displayTax();

        // Accept Product information
        System.out.print("Enter Product Name: ");
        scanner.nextLine(); // Consume newline
        String productName = scanner.nextLine();
        System.out.print("Enter Unit Price: ");
        double unitPrice = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        Product product = new Product(productName, unitPrice, quantity);
        product.displayTax();

        scanner.close();
    }
}