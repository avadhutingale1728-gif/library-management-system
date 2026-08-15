public class Student{

    public int studentId;
    public String name;
    public Book[] borrowedBooks = new Book[3];
    public int borrowedBookCount = 0;

    public Student(int studentId, String name){
        this.studentId = studentId;
        this.name = name;
    }
}