import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }
}

// Library class
class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void removeBook(int bookID) {
        books.removeIf(book -> book.getBookID() == bookID);
        System.out.println("Book removed successfully!");
    }

    public Book searchBook(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }

    public void replaceBook(int bookID, String newTitle, String newAuthor) {
        Book book = searchBook(bookID);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books) {
                book.displayBook();
            }
        }
    }
}

// Main class for user interaction
class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Replace Book");
            System.out.println("5. Display Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeID = scanner.nextInt();
                    library.removeBook(removeID);
                    break;
                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchID = scanner.nextInt();
                    Book foundBook = library.searchBook(searchID);
                    if (foundBook != null) {
                        foundBook.displayBook();
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Book ID to replace: ");
                    int replaceID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Author: ");
                    String newAuthor = scanner.nextLine();
                    library.replaceBook(replaceID, newTitle, newAuthor);
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
