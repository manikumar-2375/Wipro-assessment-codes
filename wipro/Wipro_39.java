package wipro;

import java.util.ArrayList;
import java.util.List;

// Base class
class Media {
    String title;

    public Media(String title) {
        this.title = title;
    }

    public void display() {
        System.out.println("Title: " + title);
    }
}

// Subclasses of Media
class Book extends Media {
    public Book(String title) {
        super(title);
    }
}

class Video extends Media {
    public Video(String title) {
        super(title);
    }
}

class Newspaper extends Media {
    public Newspaper(String title) {
        super(title);
    }
}

// Generic Library class
class Library<T extends Media> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }
}

public class Wipro_39 {
    public static void main(String[] args) {
        // Generic version
        Library<Book> bookLibrary = new Library<>();
        bookLibrary.add(new Book("Effective Java"));

        Library<Video> videoLibrary = new Library<>();
        videoLibrary.add(new Video("Design Patterns"));

        Library<Newspaper> newsLibrary = new Library<>();
        newsLibrary.add(new Newspaper("The Times"));

        // Display
        bookLibrary.get(0).display();
        videoLibrary.get(0).display();
        newsLibrary.get(0).display();
    }
}
/*Title: Effective Java
Title: Design Patterns
Title: The Times
*/