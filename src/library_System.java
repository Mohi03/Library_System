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

public class library_System {
    public static void main(String[] args) {
        
    }
}

