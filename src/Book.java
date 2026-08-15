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