import java.util.ArrayList;
import java.util.List;

class Book {
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

public class library_System {
    public static void main(String[] args) {
        
    }
}

