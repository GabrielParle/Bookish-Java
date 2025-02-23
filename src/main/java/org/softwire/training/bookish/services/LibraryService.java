package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService extends DatabaseService {

    public List<Book> getAllBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM books")
                        .mapToBean(Book.class)
                        .list()
        );
    }

    public void addBook(Book book) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO books (Title, Author, ISBN, Category, Copies) VALUES (:Title, :Author, :ISBN, :Category, :Copies)")
                        .bind("Title", book.getTitle())
                        .bind("Author", book.getAuthor())
                        .bind("ISBN", book.getISBN())
                        .bind("Category", book.getCategory())
                        .bind("Copies", book.getCopies())
                        .execute()
        );
    }

    public void editBook(Book book) {
        jdbi.useHandle(handle ->
                handle.createUpdate("UPDATE books SET Title = :Title, Author = :Author, Category = :Category, Copies = :Copies WHERE BookID = :BookID")
                        .bind("BookID", book.getBookID())
                        .bind("Title", book.getTitle())
                        .bind("Author", book.getAuthor())
                        .bind("Category", book.getCategory())
                        .bind("Copies", book.getCopies())
                        .execute()

        );
    }

    public void deleteBook(int BookID) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM books WHERE BookID = :id")
                        .bind("id", BookID)
                        .execute()
        );
    }
}
