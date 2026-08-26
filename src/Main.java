import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library objLibrary = new Library();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("      LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1.  Add Book");
            System.out.println("2.  Display Books");
            System.out.println("3.  Search Book");
            System.out.println("4.  Add Student");
            System.out.println("5.  Display Students");
            System.out.println("6.  Search Student");
            System.out.println("7.  Checkout Book");
            System.out.println("8.  Return Book");
            System.out.println("9.  Display Borrowed Books");
            System.out.println("10. Display Available Books");
            System.out.println("11. Remove Book");
            System.out.println("12. Remove Student");
            System.out.println("13. Display Students With Borrowed Books");
            System.out.println("14. Count Available Copies");
            System.out.println("0.  Exit");

            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                // =========================
                // 1. ADD BOOK
                // =========================

                case 1:

                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();

                    scanner.nextLine(); // Consume leftover newline

                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter Total Copies: ");
                    int totalCopies = scanner.nextInt();

                    Book book = new Book(
                        bookId,
                        title,
                        author,
                        totalCopies
                    );

                    objLibrary.addBook(book);

                    break;


                // =========================
                // 2. DISPLAY BOOKS
                // =========================

                case 2:

                    objLibrary.displayBooks();

                    break;


                // =========================
                // 3. SEARCH BOOK
                // =========================

                case 3:

                    System.out.print("Enter Book ID to search: ");
                    int searchBookId = scanner.nextInt();

                    objLibrary.searchBook(searchBookId);

                    break;


                // =========================
                // 4. ADD STUDENT
                // =========================

                case 4:

                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();

                    scanner.nextLine(); // Consume leftover newline

                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();

                    Student student = new Student(
                        studentId,
                        studentName
                    );

                    objLibrary.addStudent(student);

                    break;


                // =========================
                // 5. DISPLAY STUDENTS
                // =========================

                case 5:

                    objLibrary.displayStudents();

                    break;


                // =========================
                // 6. SEARCH STUDENT
                // =========================

                case 6:

                    System.out.print("Enter Student ID to search: ");
                    int searchStudentId = scanner.nextInt();

                    objLibrary.searchStudent(searchStudentId);

                    break;


                // =========================
                // 7. CHECKOUT BOOK
                // =========================

                case 7:

                    System.out.print("Enter Student ID: ");
                    int checkoutStudentId = scanner.nextInt();

                    System.out.print("Enter Book ID: ");
                    int checkoutBookId = scanner.nextInt();

                    objLibrary.checkOutBook(
                        checkoutStudentId,
                        checkoutBookId
                    );

                    break;


                // =========================
                // 8. RETURN BOOK
                // =========================

                case 8:

                    System.out.print("Enter Student ID: ");
                    int returnStudentId = scanner.nextInt();

                    System.out.print("Enter Book ID: ");
                    int returnBookId = scanner.nextInt();

                    objLibrary.returnBook(
                        returnStudentId,
                        returnBookId
                    );

                    break;


                // =========================
                // 9. DISPLAY BORROWED BOOKS
                // =========================

                case 9:

                    System.out.print(
                        "Enter Student ID: "
                    );

                    int borrowedStudentId = scanner.nextInt();

                    objLibrary.displayBorrowedBooks(
                        borrowedStudentId
                    );

                    break;


                // =========================
                // 10. DISPLAY AVAILABLE BOOKS
                // =========================

                case 10:

                    objLibrary.displayAvailableBooks();

                    break;


                // =========================
                // 11. REMOVE BOOK
                // =========================

                case 11:

                    System.out.print(
                        "Enter Book ID to remove: "
                    );

                    int removeBookId = scanner.nextInt();

                    objLibrary.removeBook(removeBookId);

                    break;


                // =========================
                // 12. REMOVE STUDENT
                // =========================

                case 12:

                    System.out.print(
                        "Enter Student ID to remove: "
                    );

                    int removeStudentId = scanner.nextInt();

                    objLibrary.removeStudent(removeStudentId);

                    break;


                // =========================
                // 13. DISPLAY STUDENTS WITH
                //     BORROWED BOOKS
                // =========================

                case 13:

                    objLibrary.displayStudentsWithBorrowedBooks();

                    break;


                // =========================
                // 14. COUNT AVAILABLE COPIES
                // =========================

                case 14:

                    objLibrary.countAvailableCopies();

                    break;


                // =========================
                // 0. EXIT
                // =========================

                case 0:

                    System.out.println(
                        "\nExiting Library Management System..."
                    );

                    break;


                // =========================
                // INVALID CHOICE
                // =========================

                default:

                    System.out.println(
                        "Invalid choice! Please try again."
                    );
            }

        } while (choice != 0);


        System.out.println(
            "Thank you for using the Library Management System!"
        );

        scanner.close();
    }
}