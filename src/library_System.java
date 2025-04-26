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
}

import java.util.ArrayList;
import java.util.List;

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

