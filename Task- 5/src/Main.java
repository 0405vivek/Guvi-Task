import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;


class StreamOperations {
    public static void main(String[] args) {
        // Question 1: Convert a list of Strings into uppercase using map()
        List<String> names = Arrays.asList("d", "ef");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase Names: " + upperCaseNames);

        // Question 2: Filter non-empty strings
        List<String> strings = Arrays.asList("bc", "efg", "abcd", "jkl", "");
        List<String> nonEmptyStrings = strings.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        System.out.println("Non-empty Strings: " + nonEmptyStrings);

        // Question 3: Filter students whose names start with "A"
        List<String> students = Arrays.asList("Amit", "Rahul", "Anjali", "Pooja", "Aryan", "Neha", "Akash", "Varun", "Aditi", "Karan");
        List<String> specialStudents = students.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Students receiving special gifts: " + specialStudents);

        // Question 4: Calculate age from birthdate
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your birthdate (yyyy-mm-dd): ");
        String inputDate = scanner.next();
        try {
            LocalDate birthDate = LocalDate.parse(inputDate);
            LocalDate currentDate = LocalDate.now();
            Period age = Period.between(birthDate, currentDate);
            System.out.println("Your age is: " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days.");
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
        }
        scanner.close();
    }
}
