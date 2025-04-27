import java.util.ArrayList;
import java.util.List;
import java.util.Date;


/**
  Library class manages a collection of books and borrowers.
  It provides functionality for adding books and borrowers,
  borrowing and returning books, and displaying library information.
 */
public class Library {
    // Lists to store books and borrowers
    private List<Book> books;
    private List<Borrower> borrowers;
    private List<BorrowingProcess> borrowingHistory;

    public Library() {
        books = new ArrayList<>();
        borrowers = new ArrayList<>();
        borrowingHistory = new ArrayList<>();
    }

    // Adds a new book to the library

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Adds a new borrower to the library
 
    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
        System.out.println("Borrower added: " + borrower.getName());
    }

    // Finds a book by its ISBN

    public Book findBookByISBN(int ISBN) {
        for (Book book : books) {
            if (book.getISBN() == ISBN) return book;
        }
        return null;
    }

    //  Finds a borrower by their university ID

    public Borrower findBorrowerByID(int univId) {
        for (Borrower borrower : borrowers) {
            if (borrower.getUnivId() == univId) return borrower;
        }
        return null;
    }

    // Handles the process of borrowing a book
     
    public void borrowBook(int ISBN, int univId) {
        Book book = findBookByISBN(ISBN);
        Borrower borrower = findBorrowerByID(univId);

        if (book == null) {
            System.out.println("Book not found");
            return;
        }
        if (borrower == null) {
            System.out.println("Borrower not registered");
            return;
        }
        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed");
            return;
        }

        borrower.borrowBook(book);
        // Create and store the borrowing process
        BorrowingProcess process = new BorrowingProcess(book, borrower);
        borrowingHistory.add(process);
        System.out.println("Book '" + book.getTitle() + "' borrowed by " + borrower.getName());
    }

    public void returnBook(int ISBN, int univId) {
        Book book = findBookByISBN(ISBN);
        Borrower borrower = findBorrowerByID(univId);

        if (book == null || borrower == null || !book.isBorrowed()) {
            System.out.println("Unable to return the book");
            return;
        }

        borrower.returnBook(book);
        // Find and update the borrowing process
        for (BorrowingProcess process : borrowingHistory) {
            if (process.getBorrowedBook() == book && process.getBorrower() == borrower && !process.isReturned()) {
                process.recordReturn();
                break;
            }
        }
        System.out.println("Book '" + book.getTitle() + "' returned by " + borrower.getName());
    }

    // Add a new method to display borrowing history
    public void displayBorrowingHistory() {
        System.out.println("\nBorrowing History:");
        for (BorrowingProcess process : borrowingHistory) {
            System.out.println("Book: " + process.getBorrowedBook().getTitle() +
                             ", Borrower: " + process.getBorrower().getName() +
                             ", Borrowed: " + process.getBorrowDate() +
                             ", Returned: " + (process.isReturned() ? process.getReturnDate() : "Not returned yet"));
        }
    }

    
     // Displays information about all books in the library
     
    public void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + 
                             ", Author: " + book.getAuthor() + 
                             ", ISBN: " + book.getISBN() + 
                             ", Type: " + book.getBookType() +
                             ", Status: " + (book.isBorrowed() ? "Borrowed" : "Available"));
        }
    }

    
    //  Displays information about all borrowers in the library
    
    public void displayBorrowers() {
        System.out.println("\nBorrowers List:");
        for (Borrower borrower : borrowers) {
            System.out.println("Name: " + borrower.getName() + 
                             ", University ID: " + borrower.getUnivId() + 
                             ", Borrowed Books: " + borrower.getBorrowedBooks().size());
        }
    }
}

/**
  Abstract Book class that serves as the base class for all types of books.
  It contains basic book information and borrowing status.
 */

public abstract class Book {
    private String title;
    private String author;
    private int ISBN;
    private boolean isBorrowed;

    public Book(String title, String author, int ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getISBN() { return ISBN; }
    public boolean isBorrowed() { return isBorrowed; }

    // Setters
    public void setBorrowed(boolean borrowed) { isBorrowed = true; }

    public abstract String getBookType();
}

/*
  RealBook class represents physical books in the library system.
  It extends the Book class and adds physical-specific attributes
  like number of pages and shelf location.
 */

public class RealBook extends Book {
    private int numberOfPages;
    private String location; // Shelf location in library

    public RealBook(String title, String author, int ISBN, int numberOfPages, String location) {
        super(title, author, ISBN);
        this.numberOfPages = numberOfPages;
        this.location = location;
    }

    // Getters  
    public int getNumberOfPages() { return numberOfPages; }
    public String getLocation() { return location; }

    @Override
    public String getBookType() {
        return "Real Book";
    }
} 

/*
  EBook class represents electronic books in the library system.
  It extends the Book class and adds electronic-specific attributes
  like file format and size.
 */

public class EBook extends Book {
    private String fileFormat;
    private double fileSize; // in MB

    public EBook(String title, String author, int ISBN, String fileFormat, double fileSize) {
        super(title, author, ISBN);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }

    // Getters 
    public String getFileFormat() { return fileFormat; }
    public double getFileSize() { return fileSize; }

    @Override
    public String getBookType() {
        return "E-Book";
    }
} 

/*
  Borrower class represents a library member who can borrow books.
  It maintains a list of currently borrowed books and provides
  methods to manage the borrowing process.
 */

public class Borrower {
    private String name;
    private int univId;
    private List<Book> borrowedBooks;

    public Borrower(String name, int univId) {
        this.name = name;
        this.univId = univId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public int getUnivId() { return univId; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    // Methods to manage borrowed books
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setBorrowed(true);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setBorrowed(false);
    }
} 


// Represents a record of a book borrowing transaction

public class BorrowingProcess {
    private Book borrowedBook;
    private Borrower borrower;
    private Date borrowDate;
    private Date returnDate;

    // Creates a new borrowing process record when a book is borrowed
 
    public BorrowingProcess(Book borrowedBook, Borrower borrower) {
        this.borrowedBook = borrowedBook;
        this.borrower = borrower;
        this.borrowDate = new Date(); // Current date
        this.returnDate = null; // Will be set when book is returned
    }

    // Getters
    public Book getBorrowedBook() { return borrowedBook; }
    public Borrower getBorrower() { return borrower; }
    public Date getBorrowDate() { return borrowDate; }
    public Date getReturnDate() { return returnDate; }
    
    // Records the return of the book
  
    public void recordReturn() {
        this.returnDate = new Date();
    }

    
    public boolean isReturned() {
        return returnDate != null;
    }

}

public class library_System {
    public static void main(String[] args) {
        
    }
}

