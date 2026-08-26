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

    //creating 2 student object 
    Student student1 = new Student(1, "Tejas");
    Student student2 = new Student(2, "Yash");
    //Adding 2 students information
    objLibrary.addStudent(student1);
    objLibrary.addStudent(student2);
    //Adding duplicate to check 
    Student student3 = new Student(1, "Ram");
    objLibrary.addStudent(student3);


    //display information of student
    objLibrary.displayStudents();

    objLibrary.checkOutBook(1, 101);
    objLibrary.displayBooks();
    System.out.println("Borrowed Books by Tejas " + student1.borrowedBookCount);

    objLibrary.displayBorrowedBooks(1);
    objLibrary.displayBorrowedBooks(2);

    objLibrary.returnBook(1, 101);
    objLibrary.returnBook(999, 101);
    objLibrary.returnBook(1, 102);

    objLibrary.searchStudent(1);
    objLibrary.searchStudent(999);

    objLibrary.removeStudent(2);
    objLibrary.displayStudents();

    objLibrary.removeBook(102);
    objLibrary.displayBooks();

    objLibrary.removeBook(101);
    }

}