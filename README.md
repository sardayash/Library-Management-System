# Library-Management-System

Overview -
This is a simple console-based Library Management System built using Java. The system allows users to perform basic operations such as adding books, borrowing books, returning books, and viewing available books.

Features -
Add new books to the library.
Borrow books (if available).
Return borrowed books.
View a list of available (not borrowed) books.
Prevent adding duplicate books (based on ISBN).
Simple console menu interface for easy interaction.
Technologies Used
Programming Language: Java
Development Environment: Any Java IDE (IntelliJ IDEA, Eclipse, etc.) or command line
Classes and Structure

1. Book Class
Represents a single book in the library with attributes such as:

title: The title of the book.
author: The author of the book.
ISBN: The unique identifier for the book.
isBorrowed: Status indicating if the book has been borrowed or not.

2. Library Class
Handles the core operations of the system, including:

Adding books.
Borrowing books.
Returning books.
Viewing available books.

3. Main Class
Provides a console-based user interface for interacting with the library system. Users can:

Add books.
Borrow or return books.
View all available books.
Exit the program.

Usage -
Add Book: Input the title, author, and ISBN to add a book.
Borrow Book: Input the ISBN of the book to borrow. It marks the book as borrowed.
Return Book: Input the ISBN of the book to return it.
View Available Books: Displays the list of all books that are not currently borrowed.
