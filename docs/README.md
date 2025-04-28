#  Library Management System

A simple **Java** application to manage a library's collection of books, borrowers, and the borrowing/returning process.

---

##  Features

- **Add Books**: Register new physical books (`RealBook`) or electronic books (`EBook`).
- **Add Borrowers**: Register library members with a unique university ID.
- **Borrow & Return**: Check out and return books, with validation and status updates.
- **Display Books**: List all books with title, author, ISBN, type, and availability.
- **Display Borrowers**: List all borrowers and count of currently borrowed books.
- **Borrowing History**: View complete history of borrow/return transactions with timestamps.


---

##  Requirements

- Java JDK 8 or higher

---

##  Installation & Running

1. **Clone or download** the repository.
2. **Compile** the source files:
   ```bash
   javac src/*.java
   ```
3. **Run** the application:
   ```bash
   java -cp src library_System
   ```

---

##  Usage

On startup, a console menu appears with options:

1. **Add a Book**: Enter title, author, ISBN, then choose real or e‑book and specify pages/location or format/size.
2. **Add a Borrower**: Enter name and unique university ID.
3. **Borrow a Book**: Provide ISBN and borrower ID.
4. **Return a Book**: Provide ISBN and borrower ID.
5. **Display All Books**: Shows all books and their status.
6. **Display All Borrowers**: Shows all borrowers and how many books they have.
7. **Display Borrowing History**: Shows each transaction with dates.
8. **Exit**: Close the application.

---
Name : محي الدين
FamilyName : معطى الله
Groupe : مدان
---



