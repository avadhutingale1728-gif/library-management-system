/*
  Represents a student registered in the library.
 
  Each student has:
  - A unique student ID
  - A name
  - A list of borrowed books
 
  A student can borrow a maximum of 3 books at a time.
 */
public class Student{

    public int studentId;
    public String name;
    // Stores the books currently borrowed by the student.
    // Maximum borrowing limit is 3 books.
    public Book[] borrowedBooks = new Book[3];
    // Keeps track of how many books the student currently has borrowed.
    public int borrowedBookCount = 0;

    // Creates a student with a unique ID and name.
    public Student(int studentId, String name){
        this.studentId = studentId;
        this.name = name;
    }
}