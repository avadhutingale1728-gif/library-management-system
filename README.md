# 📚 Library Management System

A **console-based Library Management System** built with **Java** to practice and demonstrate core **Object-Oriented Programming (OOP)** concepts.

The application provides an interactive menu for managing books and students, handling book checkout and returns, tracking borrowed books, and maintaining book availability.

---

## 🚀 Features

### 📖 Book Management

* Add new books
* Display all books
* Search books by Book ID
* Display available books
* Remove books
* Prevent duplicate Book IDs
* Track total and available copies

### 👨‍🎓 Student Management

* Add new students
* Display all registered students
* Search students by Student ID
* Remove students
* Prevent duplicate Student IDs
* Prevent removal of students with borrowed books

### 🔄 Borrow & Return System

* Checkout books to registered students
* Return borrowed books
* Track books borrowed by each student
* Display borrowed books
* Maximum of **3 books per student**
* Automatically decrease available copies during checkout
* Automatically restore available copies during return

### 📊 Additional Operations

* Display students who currently have borrowed books
* Count total available book copies
* Interactive console-based menu
* Basic validation for books and students

---

## 🛠️ Technologies Used

| Technology  | Purpose                 |
| ----------- | ----------------------- |
| **Java**    | Application development |
| **OOP**     | Object-oriented design  |
| **Arrays**  | Data storage            |
| **Scanner** | User input              |
| **Git**     | Version control         |
| **GitHub**  | Source code hosting     |

---

## 🧠 OOP Concepts Demonstrated

This project was developed to strengthen practical understanding of Java OOP concepts.

* **Classes & Objects**
* **Encapsulation**
* **Abstraction**
* **Object Relationships**
* **Methods**
* **Constructors**
* **Arrays of Objects**
* **Conditional Logic**
* **Loops**
* **Method-based modular design**

The main classes are:

```text
Book
Student
Library
Main
```

---

## 📂 Project Structure

```text
library-management-system/
│
├── src/
│   ├── Book.java
│   ├── Student.java
│   ├── Library.java
│   └── Main.java
│
└── README.md
```

### `Book.java`

Represents a book in the library.

Stores:

* Book ID
* Title
* Author
* Total copies
* Available copies

### `Student.java`

Represents a registered student.

Stores:

* Student ID
* Student name
* Borrowed books
* Borrowed book count

### `Library.java`

Contains the main library operations, including:

* Book management
* Student management
* Book searching
* Student searching
* Checkout and return operations
* Borrowed book tracking
* Available book tracking
* Removing books and students

### `Main.java`

Contains the application entry point and provides the interactive console-based menu.

---

## 💻 Application Menu

```text
=================================
      LIBRARY MANAGEMENT SYSTEM
=================================
1.  Add Book
2.  Display Books
3.  Search Book
4.  Add Student
5.  Display Students
6.  Search Student
7.  Checkout Book
8.  Return Book
9.  Display Borrowed Books
10. Display Available Books
11. Remove Book
12. Remove Student
13. Display Students With Borrowed Books
14. Count Available Copies
0.  Exit
```

---

## ⚙️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/avadhutingale1728-gif/library-management-system.git
```

### 2. Navigate to the Source Directory

```bash
cd library-management-system/src
```

### 3. Compile the Application

```bash
javac Main.java
```

### 4. Run the Application

```bash
java Main
```

---

## 🧪 Example Usage

### Add a Book

```text
Enter your choice: 1

Enter Book ID: 101
Enter Book Title: Rich dad poor dad
Enter Author Name: Avadhut
Enter Total Copies: 3
```

### Add a Student

```text
Enter your choice: 4

Enter Student ID: 1
Enter Student Name: Tejas
```

### Checkout a Book

```text
Enter your choice: 7

Enter Student ID: 1
Enter Book ID: 101

Book borrowed successfully!
```

The available copies are automatically updated:

```text
ID: 101 | Title: Rich dad poor dad | Author: Avadhut | Available: 2
```

### Display Borrowed Books

```text
Enter your choice: 9

Enter Student ID: 1

Borrowed Books by Tejas
ID: 101 | Title: Rich dad poor dad | Author: Avadhut
```

### Return a Book

```text
Enter your choice: 8

Enter Student ID: 1
Enter Book ID: 101

Book return successfully!!
```

The available copy count is restored:

```text
ID: 101 | Title: Rich dad poor dad | Author: Avadhut | Available: 3
```

---

## 📋 Business Rules

The application currently follows these rules:

* Book IDs must be unique.
* Student IDs must be unique.
* Maximum **50 books** can be stored.
* Maximum **50 students** can be registered.
* A student can borrow a maximum of **3 books**.
* Books cannot be checked out when no copies are available.
* Only registered students can borrow books.
* A student cannot be removed while they have borrowed books.
* Returning a book increases its available copy count.
* Removing a book is restricted when the book is currently borrowed.

---

## 🔄 System Workflow

```text
                ┌───────────────┐
                │     Start     │
                └───────┬───────┘
                        │
                        ▼
                ┌───────────────┐
                │  Main Menu    │
                └───────┬───────┘
                        │
          ┌─────────────┼─────────────┐
          ▼             ▼             ▼
      Book Mgmt     Student Mgmt   Transactions
          │             │             │
          ▼             ▼             ▼
      Add/Search    Add/Search    Checkout
      Display       Display       Return
      Remove        Remove        Borrowed Books
          │             │             │
          └─────────────┼─────────────┘
                        │
                        ▼
                   Continue?
                    /     \
                  Yes      No
                   │        │
                   └──►─────┘
                            ▼
                         Exit
```

---

## 📌 Current Implementation

The application currently uses **arrays with a fixed capacity of 50** for storing books and students.

This approach was intentionally used to strengthen understanding of:

* Arrays
* Array indexing
* Object references
* Searching
* Insertion
* Deletion
* Shifting array elements
* Managing object relationships

---

## 🔮 Future Improvements

The project can be further improved by introducing:

* [ ] Input validation and exception handling
* [ ] `ArrayList` instead of fixed-size arrays
* [ ] Private fields with getters and setters
* [ ] Better separation of responsibilities
* [ ] File-based data persistence
* [ ] Database integration using JDBC
* [ ] MySQL database
* [ ] Login and authentication
* [ ] Book due dates
* [ ] Fine calculation
* [ ] Book categories and genres
* [ ] GUI interface
* [ ] Spring Boot REST API
* [ ] Frontend integration

---

## 🎯 Learning Objectives

This project was created as a hands-on Java project to strengthen my understanding of:

* Core Java
* Object-Oriented Programming
* Classes and Objects
* Constructors
* Arrays
* Methods
* Loops and conditional statements
* Object references
* Searching and data manipulation
* Console application development
* Git and GitHub
* Debugging and testing

---

## 📈 Project Status

**Status:** 🟢 Active Development

The core library management functionality and menu-driven interface have been implemented.

Future improvements will focus on making the application more robust, scalable, and closer to a real-world Java backend application.

---

## 👨‍💻 Author

**Avadhut Ingale**

Computer Science Engineering Student

---

## 📄 License

This project is created for **educational and learning purposes**.
