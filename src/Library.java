

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

    /*displayBooks() needs to:
    Print a heading.
    loop through the existing books.
    Access each Book object's fields.
    Print the information. */
    public void displayBooks(){
        System.out.println("Total books Information");

        for(int i=0; i<bookCount; i++){
            System.out.println(
                "ID: " + books[i].bookId
                + " | Title:  " + books[i].title
                + " | Author:  " + books[i].author
                + " | Available:  " + books[i].availableCopies
                + " | Total Books:  " + books[i].totalCopies
            );
        }
    }


    public void searchBook(int bookId){

        for(int i = 0; i< bookCount; i++){
            if(bookId == books[i].bookId){
                System.out.println("Book found!");
                System.out.println(
                    "ID: " + books[i].bookId
                    + " | Title: " + books[i].title
                    + " | Author: " + books[i].author
                    + " | Available: " + books[i].availableCopies
                    + " | Total: " + books[i].totalCopies);
                    return;
            }
        }
                System.out.println("Book not found!!");
        
    }

    /*addStudent(student)
       ↓
Check existing students
       ↓
Does studentId already exist?
       ├── YES → "Duplicate Student ID" → return
       │
       └── NO
            ↓
       Is storage full?
       ├── YES → "Storage full" → return
       │
       └── NO
            ↓
       students[studentCount] = student
            ↓
       studentCount++ */

       public void addStudent(Student student){
        for(int i=0; i<studentCount;i++){
            if(student.studentId == students[i].studentId){
                System.out.println("Duplicate Student ID");
                return;
            }
        }
        if(studentCount >= 50){
            System.out.println("Storage Full");
            return;
        }
        students[studentCount] = student;
        studentCount++;
       }
    
}
