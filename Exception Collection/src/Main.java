import java.util.*;

// Q1: Student class with custom exceptions
class AgeNotWithinRangeException extends Exception {
    public AgeNotWithinRangeException(String message) {
        super(message);
    }
}

class NameNotValidException extends Exception {
    public NameNotValidException(String message) {
        super(message);
    }
}

class Student {
    int rollNo;
    String name;
    int age;
    String course;

    public Student(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException, NameNotValidException {
        if (age < 15 || age > 21) {
            throw new AgeNotWithinRangeException("Age not within valid range (15-21)");
        }
        if (!name.matches("[a-zA-Z ]+")) {
            throw new NameNotValidException("Name contains invalid characters");
        }
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }
}

// Q2: Voter class with age validation
class InvalidVoterAgeException extends Exception {
    public InvalidVoterAgeException(String message) {
        super(message);
    }
}

class Voter {
    int voterId;
    String name;
    int age;

    public Voter(int voterId, String name, int age) throws InvalidVoterAgeException {
        if (age < 18) {
            throw new InvalidVoterAgeException("Invalid age for voter");
        }
        this.voterId = voterId;
        this.name = name;
        this.age = age;
    }
}

// Q3: Weekdays array with exception handling
class Weekdays {
    static String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public static void printDay(int index) {
        try {
            System.out.println("Day: " + days[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid day index! Please enter a number between 0 and 6.");
        }
    }
}

// Q4: Student Grades HashMap
class StudentGrades {
    private HashMap<String, Integer> grades = new HashMap<>();

    public void addStudent(String name, int grade) {
        grades.put(name, grade);
    }

    public void removeStudent(String name) {
        grades.remove(name);
    }

    public void displayGrade(String name) {
        if (grades.containsKey(name)) {
            System.out.println(name + "'s grade: " + grades.get(name));
        } else {
            System.out.println("Student not found!");
        }
    }
}

// Q5: Stack Operations using Collection
class StackOperations {
    private Stack<Integer> stack = new Stack<>();

    public void pushElement(int element) {
        stack.push(element);
        System.out.println(element + " pushed onto stack.");
    }

    public void popElement() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Popped: " + stack.pop());
        }
    }

    public void isEmpty() {
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}

// Main class to test functionalities
public class Main {
    public static void main(String[] args) {
        try {
            Student s1 = new Student(101, "JohnDoe", 20, "CS");
            System.out.println("Student created: " + s1.name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Voter v1 = new Voter(1001, "Alice", 17);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

       scanner = new Scanner(System.in);
        System.out.print("Enter day index (0-6): ");
        int dayIndex = scanner.nextInt();
        Weekdays.printDay(dayIndex);

        StudentGrades studentGrades = new StudentGrades();
        studentGrades.addStudent("Alice", 90);
        studentGrades.displayGrade("Alice");
        studentGrades.removeStudent("Alice");
        studentGrades.displayGrade("Alice");

        StackOperations stackOps = new StackOperations();
        stackOps.pushElement(10);
        stackOps.pushElement(20);
        stackOps.popElement();
        stackOps.isEmpty();
    }
}
