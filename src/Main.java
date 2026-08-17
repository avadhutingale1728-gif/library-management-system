public class Main{

    public static void main(String[] args){

    Library objLibrary = new Library();
    Book book1 = new Book(101, "Rich dad poor dad", "Avadhut", 10);
    Book book2 = new Book(102, "love ", "Avadhut Ingale", 5);
    
    objLibrary.addBook(book1);
    objLibrary.addBook(book2);

    Book book3 = new Book(101, "funny", "snehal", 1);
    objLibrary.addBook(book3);

    objLibrary.displayBooks();
    objLibrary.searchBook(999);
    objLibrary.searchBook(101);

    }

}