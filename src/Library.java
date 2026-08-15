public class Library{
    //Books related fields
    Book[] books = new Book[50];
    int bookCount = 0;
    //Student related fields
    Student[] students = new Student[50];
    int studentCount = 0;

    public void addBook(Book book){
        for(int i = 0; i<bookCount; i++){
            if(book.bookId  == books[i].bookId){
                System.out.println("Duplicate ID");
                return;
            }
        }

        if(bookCount >= 50){
                System.out.println("Storage full");
                return; 
        }

        books[bookCount]= book;
        bookCount++;
    }
    
}
