package wipro;

import java.util.*;

// BookStore class
class BookStore {
    private int bookId;
    private String bookName;

    public BookStore(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void display() {
        System.out.println("Book ID: " + bookId + ", Book Name: " + bookName);
    }
}

// Comparator to sort by book name
class SortByBookName implements Comparator<BookStore> {
    @Override
    public int compare(BookStore b1, BookStore b2) {
        return b1.getBookName().compareToIgnoreCase(b2.getBookName());
    }
}

// Comparator to sort by book ID
class SortByBookId implements Comparator<BookStore> {
    @Override
    public int compare(BookStore b1, BookStore b2) {
        return Integer.compare(b1.getBookId(), b2.getBookId());
    }
}

public class Wipro_41 {
    public static void main(String[] args) {
        List<BookStore> bookList = new ArrayList<>();

        // Sample books
        bookList.add(new BookStore(103, "Java Fundamentals"));
        bookList.add(new BookStore(101, "Data Structures"));
        bookList.add(new BookStore(105, "Algorithms"));
        bookList.add(new BookStore(102, "Operating Systems"));

        System.out.println("Sorted by Book Name:");
        Collections.sort(bookList, new SortByBookName());
        for (BookStore b : bookList) {
            b.display();
        }

        System.out.println("\nSorted by Book ID:");
        Collections.sort(bookList, new SortByBookId());
        for (BookStore b : bookList) {
            b.display();
        }
    }
}
/*Sorted by Book Name:
Book ID: 105, Book Name: Algorithms
Book ID: 101, Book Name: Data Structures
Book ID: 103, Book Name: Java Fundamentals
Book ID: 102, Book Name: Operating Systems

Sorted by Book ID:
Book ID: 101, Book Name: Data Structures
Book ID: 102, Book Name: Operating Systems
Book ID: 103, Book Name: Java Fundamentals
Book ID: 105, Book Name: Algorithms
*/