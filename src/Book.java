/*
  Represents a book available in the library.
 
  Stores basic book information such as:
  - Book ID
  - Title
  - Author
  - Total number of copies
  - Number of currently available copies
 
  When a book is created, all copies are initially available.
 */

public class Book{
    public int bookId;
    public String title;
    public String author;
    public int totalCopies;
    public int availableCopies;

    public Book(int bookId, String title, String author, int totalCopies){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        availableCopies = totalCopies;
    }

}