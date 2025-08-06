package springq9;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book9 {
    private int bookId;
    private String name;
    private String writer;

    public Book9() {
    }

    public Book9(int bookId, String name, String writer) {
        this.bookId = bookId;
        this.name = name;
        this.writer = writer;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
