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

    Student student = null;

    // Find the student using the student ID.
    for (int i = 0; i < studentCount; i++) {
        if (studentId == students[i].studentId) {
            student = students[i];
            break;
        }
    }

    // Student does not exist.
    if (student == null) {
        System.out.println("Student not found!");
        return;
    }

    Book book = null;

    // Find the book using the book ID.
    for (int i = 0; i < bookCount; i++) {
        if (bookId == books[i].bookId) {
            book = books[i];
            break;
        }
    }

    // Book does not exist.
    if (book == null) {
        System.out.println("Book not found!");
        return;
    }

    // Check whether copies are available.
    if (book.availableCopies <= 0) {
        System.out.println("Book is not available!");
        return;
    }

    // Check the student's borrowing limit.
    if (student.borrowedBookCount >= 3) {
        System.out.println("Student cannot borrow more than 3 books.");
        return;
    }

    // Complete the checkout.
    student.borrowedBooks[student.borrowedBookCount] = book;
    student.borrowedBookCount++;
    book.availableCopies--;

    System.out.println("Book borrowed successfully!");
}

    /*
 * Displays all books currently borrowed by a student.
 *
 * The method:
 * - Finds the student using the student ID.
 * - Checks how many books the student has borrowed.
 * - Displays the details of each borrowed book.
 */
    public void displayBorrowedBooks(int studentId) {
    for(int i = 0; i < studentCount; i++) {
        if(studentId == students[i].studentId) {
            Student student = students[i];

            System.out.println("Borrowed Books by " + student.name);

            if(student.borrowedBookCount == 0) {
                System.out.println("No books borrowed.");
                return;
            }

            for(int j = 0; j < student.borrowedBookCount; j++) {
                Book book = student.borrowedBooks[j];

                System.out.println(
                    "ID: " + book.bookId +
                    " | Title: " + book.title +
                    " | Author: " + book.author
                );
            }

            return;
        }
    }

    System.out.println("Student not found!");
    }

    /*
 * Allows a student to return a borrowed book.
 *
 * Before returning:
 * - Checks whether the student is registered.
 * - Checks whether the student has borrowed the requested book.
 *
 * If the book is found:
 * - Removes the book from the student's borrowed books.
 * - Increases the book's available copies.
 * - Decreases the student's borrowed book count.
 */
    public void returnBook(int studentId, int bookId) {

    Student student = null;

    // Find the student using the student ID.
        for(int i = 0; i < studentCount; i++) {
            if(studentId == students[i].studentId) {
            student = students[i];
            break;
            }
        }

    // Student does not exist.
        if(student == null) {
            System.out.println("Student not found!");
            return;
        }
        // Search through the books borrowed by this student.
        for(int i = 0; i < student.borrowedBookCount; i++) {

            Book book = student.borrowedBooks[i];

        // Check whether this is the book the student wants to return.
            if(book.bookId == bookId) {

                for(int j = i; j < student.borrowedBookCount - 1; j++) {
                    student.borrowedBooks[j] = student.borrowedBooks[j + 1];
                }
                student.borrowedBooks[student.borrowedBookCount-1] = null;
                student.borrowedBookCount--;
                book.availableCopies++;
                System.out.println("Book return successfully!!");
                return;
            }
        }
        System.out.println("Book was not borrowed by this student!");
    }

    /*
    * Searches for a student using their unique student ID.
    *
    * Displays the student's information if found.
    * Otherwise, informs the user that the student does not exist.
    */
    public void searchStudent(int studentId) {

        for(int i = 0; i < studentCount; i++) {

            if(studentId == students[i].studentId) {
                System.out.println("Student found");
                System.out.println("Name:- " + students[i].name +
                    " | StudentId:- " + students[i].studentId +
                     " | Borrowed Books: " + students[i].borrowedBookCount
                );
                return;
            }
        }
        System.out.println("STudent not found!!");
    }

    /*
 * Removes a registered student from the library.
 *
 * Before removing:
 * - Checks whether the student exists.
 * - Checks whether the student has any borrowed books.
 *
 * If the student has no borrowed books:
 * - Removes the student from the array.
 * - Shifts remaining students to fill the empty position.
 * - Decreases the student count.
 */
    public void removeStudent(int studentId) {

    // Find the student using the student ID.
    for (int i = 0; i < studentCount; i++) {

        if (studentId == students[i].studentId) {

            Student student = students[i];

            // A student cannot be removed if they still have borrowed books.
            if (student.borrowedBookCount > 0) {
                System.out.println(
                    "Student cannot be removed because they have borrowed books."
                );
                return;
            }

            // Shift all students after the removed student one position left.
            for (int j = i; j < studentCount - 1; j++) {
                students[j] = students[j + 1];
            }

            // Remove the duplicate reference at the last position.
            students[studentCount - 1] = null;

            // Decrease the total student count.
            studentCount--;

            System.out.println("Student removed successfully!");
            return;
        }
    }

    // Student ID was not found.
    System.out.println("Student not found!");
    }


    /*
    * Removes a book from the library using its book ID.
    *
    * Before removing:
    * - Checks whether the book exists.
    * - Checks whether all copies of the book are available.
    *
    * A book cannot be removed if one or more copies
    * are currently borrowed by students.
    *
    * If the book can be removed:
    * - Shifts the remaining books one position left.
    * - Clears the last array position.
    * - Decreases the book count.
    */
    public void removeBook(int bookId) {

        // Find the book using the book ID.
        for (int i = 0; i < bookCount; i++) {

            if (bookId == books[i].bookId) {

                Book book = books[i];

                // Check whether any copy of the book is currently borrowed.
                if (book.availableCopies < book.totalCopies) {
                    System.out.println(
                        "Book cannot be removed because some copies are borrowed."
                    );
                    return;
                }

                // Shift all books after the removed book one position left.
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }

                // Clear the duplicate reference at the last position.
                books[bookCount - 1] = null;

                // Decrease the total number of books.
                bookCount--;

                System.out.println("Book removed successfully!");
                return;
            }
        }

        // Book ID was not found.
        System.out.println("Book not found!");
    }

    /*
    * Displays all books that currently have at least one
    * available copy for borrowing.
    *
    * Books with zero available copies are not displayed.
    */
    public void displayAvailableBooks() {

        System.out.println("Available Books Information");

        boolean availableBookFound = false;

        // Check all registered books.
        for (int i = 0; i < bookCount; i++) {

            // Display only books with available copies.
            if (books[i].availableCopies > 0) {

                System.out.println(
                    "ID: " + books[i].bookId
                    + " | Title: " + books[i].title
                    + " | Author: " + books[i].author
                    + " | Available: " + books[i].availableCopies
                );

                availableBookFound = true;
            }
        }

        // Inform the user if no books are currently available.
        if (!availableBookFound) {
            System.out.println("No books are currently available.");
        }
    }

    /*
    * Displays all students who currently have one or more
    * borrowed books.
    *
    * Students who have not borrowed any books are not displayed.
    */
    public void displayStudentsWithBorrowedBooks() {

        System.out.println("Students With Borrowed Books");

        boolean studentFound = false;

        // Check all registered students.
        for (int i = 0; i < studentCount; i++) {

            // Display only students who have borrowed books.
            if (students[i].borrowedBookCount > 0) {

                System.out.println(
                    "Student ID: " + students[i].studentId
                    + " | Name: " + students[i].name
                    + " | Borrowed Books: " + students[i].borrowedBookCount
                );

                studentFound = true;
            }
        }

        // Inform the user if nobody currently has a borrowed book.
        if (!studentFound) {
            System.out.println("No students have borrowed books.");
        }
    }
}