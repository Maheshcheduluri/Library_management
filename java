import java.util.ArrayList;

class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
}

class Member {
    private int memberId;
    private String name;
    private ArrayList<Book> borrowedBooks;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            borrowedBooks.add(book);
            System.out.println(name + " borrowed '" + book.getTitle() + "'");
        } else {
            System.out.println("Sorry, '" + book.getTitle() + "' is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.setAvailable(true);
            borrowedBooks.remove(book);
            System.out.println(name + " returned '" + book.getTitle() + "'");
        } else {
            System.out.println("You did not borrow '" + book.getTitle() + "' from the library.");
        }
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has not borrowed any books.");
        } else {
            System.out.println(name + "'s borrowed books:");
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book1 = new Book(1, "The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book(2, "To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book(3, "1984", "George Orwell");

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();

        System.out.println("\n=== Borrowing and Returning Books ===");

        Member member1 = new Member(101, "Alice");
        Member member2 = new Member(102, "Bob");

        member1.borrowBook(book1);
        member1.borrowBook(book2);
        member2.borrowBook(book2);

        member1.displayBorrowedBooks();
        member2.displayBorrowedBooks();

        member1.returnBook(book1);
        member2.returnBook(book2);

        member1.displayBorrowedBooks();
        member2.displayBorrowedBooks();

        library.displayBooks();
    }
}
