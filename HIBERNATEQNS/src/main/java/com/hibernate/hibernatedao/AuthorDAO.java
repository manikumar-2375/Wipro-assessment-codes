package com.itemcrud.dao;

import com.itemcrud.model.Author;
import com.itemcrud.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class AuthorDAO {

    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void addAuthorWithBooks() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter author name: ");
        String name = sc.nextLine();

        Author author = new Author(name);

        System.out.print("How many books? ");
        int count = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter book title " + i + ": ");
            String title = sc.nextLine();
            Book book = new Book(title);

            // Set up bidirectional relationship
            author.getBooks().add(book);
            book.getAuthors().add(author);
        }

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(author); // will cascade to books if cascade is set
        session.getTransaction().commit();
        session.close();

        System.out.println("Author and books saved.");
    }

    public void viewAuthors() {
        Session session = factory.openSession();
        List<Author> authors = session.createQuery("from Author", Author.class).list();

        for (Author author : authors) {
            System.out.println("Author ID: " + author.getId() + ", Name: " + author.getName());
            for (Book book : author.getBooks()) {
                System.out.println("   Book: " + book.getTitle());
            }
        }

        session.close();
    }

    public void deleteAuthorById(int id) {
        Session session = factory.openSession();
        session.beginTransaction();

        Author author = session.get(Author.class, id);
        if (author != null) {
            session.delete(author);
            System.out.println(" Author deleted.");
        } else {
            System.out.println("Author not found.");
        }

        session.getTransaction().commit();
        session.close();
    }
}
