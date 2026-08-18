/*
 * Manages the main operations of the library.
 *
 * Responsibilities:
 * - Add and manage books
 * - Search and display books
 * - Register students
 * - Display registered students
 * - Handle book checkout and return
 *
 * Books and students are stored in arrays with a maximum capacity of 50.
 */
public class Library {

    // Books-related fields
    Book[] books = new Book[50];   // Stores all books registered in the library.
    int bookCount = 0;             // Keeps track of the number of books currently stored.

    // Student-related fields
    Student[] students = new Student[50];  // Stores all students registered in the library.
    int studentCount = 0;                  // Keeps track of the number of students currently registered.


    /*
     * Adds a new book to the library.
     *
     * Before adding:
     * - Checks whether the book ID already exists.
     * - Checks whether the library has reached its storage limit.
     */
    public void addBook(Book book) {

        // Check for duplicate book ID.
        for (int i = 0; i < bookCount; i++) {

            if (book.bookId == books[i].bookId) {
                System.out.println("Duplicate ID");
                return;
            }
        }

        // Prevent adding books when the array is full.
        if (bookCount >= 50) {
            System.out.println("Storage full");
            return;
        }

        // Add the book at the next available position.
        books[bookCount] = book;
        bookCount++;
    }


    /*
     * Displays information about all books currently
     * registered in the library.
     */
    public void displayBooks() {

        System.out.println("Total Books Information");

        for (int i = 0; i < bookCount; i++) {

            System.out.println(
                "ID: " + books[i].bookId
                + " | Title: " + books[i].title
                + " | Author: " + books[i].author
                + " | Available: " + books[i].availableCopies
                + " | Total Books: " + books[i].totalCopies
            );
        }
    }


    /*
     * Searches for a book using its unique book ID.
     *
     * Displays the book details if found; otherwise,
     * informs the user that the book does not exist.
     */
    public void searchBook(int bookId) {

        // Search through all registered books.
        for (int i = 0; i < bookCount; i++) {

            if (bookId == books[i].bookId) {

                System.out.println("Book found!");

                System.out.println(
                    "ID: " + books[i].bookId
                    + " | Title: " + books[i].title
                    + " | Author: " + books[i].author
                    + " | Available: " + books[i].availableCopies
                    + " | Total: " + books[i].totalCopies
                );

                // Stop searching once the requested book is found.
                return;
            }
        }

        System.out.println("Book not found!!");
    }


    /*
     * Registers a new student in the library.
     *
     * Before adding:
     * - Checks whether the student ID already exists.
     * - Checks whether the student array is full.
     */
    public void addStudent(Student student) {

        // Check for duplicate student ID.
        for (int i = 0; i < studentCount; i++) {

            if (student.studentId == students[i].studentId) {
                System.out.println("Duplicate Student ID");
                return;
            }
        }

        // Prevent adding students when the array is full.
        if (studentCount >= 50) {
            System.out.println("Storage Full");
            return;
        }

        // Add the student at the next available position.
        students[studentCount] = student;
        studentCount++;
    }


    /*
     * Displays the ID and name of all registered students.
     */
    public void displayStudents() {

        System.out.println("Total Students Information");

        for (int i = 0; i < studentCount; i++) {

            System.out.println(
                "Student ID: " + students[i].studentId
                + " | Name: " + students[i].name
            );
        }
    }

    /*
    * Allows a registered student to borrow a book.
    *
    * Before checkout:
    * - Checks whether the student is registered.
    * - Checks whether the requested book exists.
    * - Checks whether the book has available copies.
    * - Checks whether the student has reached the 3-book limit.
    *
    * If all conditions are satisfied:
    * - Adds the book to the student's borrowed books.
    * - Decreases the book's available copies.
    * - Increases the student's borrowed book count.
    */
    public void checkOutBook(int studentId, int bookId) {
        for(int i=0; i<studentCount; i++){
            if(studentId == students[i].studentId){
                Student student = students[i];
                for(int j=0; j<bookCount; j++){
                    if(bookId == books[j].bookId){
                        if(books[j].availableCopies >0){
                            if(student.borrowedBookCount < 3){
                                System.out.println("Student can borrow that book.");
                                student.borrowedBooks[student.borrowedBookCount] = books[j];
                                books[j].availableCopies--;
                                student.borrowedBookCount++;

                                return;
                            }else{
                                System.out.println("Student cannot borrow more than 3 books.");
                            }
                        }else{
                            System.out.println("Book is not available!!");
                        }
                        
                    }
                }
            }
        }
    }
}