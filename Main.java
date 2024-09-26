import java.util.*;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isBorrowed;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Borrowed: " + (isBorrowed ? "Yes" : "No");
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getISBN().equals(book.getISBN())) {
                System.out.println("Book with ISBN " + book.getISBN() + " already exists.");
                return;
            }
        }
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void borrowBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    System.out.println("You have borrowed the book: " + book.getTitle());
                    return;
                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found.");
    }

    public void returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    System.out.println("You have returned the book: " + book.getTitle());
                    return;
                } else {
                    System.out.println("This book was not borrowed.");
                    return;
                }
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found.");
    }

    public void viewAvailableBooks() {
        boolean available = false;
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book);
                available = true;
            }
        }
        if (!available) {
            System.out.println("No books available.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String ISBN = scanner.nextLine();
                    library.addBook(new Book(title, author, ISBN));
                    break;

                case 2:
                    System.out.print("Enter ISBN of the book to borrow: ");
                    String borrowISBN = scanner.nextLine();
                    library.borrowBook(borrowISBN);
                    break;

                case 3:
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnISBN = scanner.nextLine();
                    library.returnBook(returnISBN);
                    break;

                case 4:
                    library.viewAvailableBooks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}