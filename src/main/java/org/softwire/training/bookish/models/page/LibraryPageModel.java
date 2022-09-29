package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Book;

import java.util.List;

public class LibraryPageModel {

    private List<Book> books;
    private int bookInEdit = 0;

    private boolean addBookActive = false;

    public List<Book> getBooks() { return books; }

    public void setBooks(List<Book> books) { this.books = books;}

    public void setBookInEdit(int BookID) { this.bookInEdit = BookID;}

    public int getBookInEdit() {return bookInEdit;}

    public void cancelEdit() {this.bookInEdit = 0;}

    public boolean isAddBookActive() { return addBookActive; }

    public void setAddBookActive(boolean addBookActive) { this.addBookActive = addBookActive; }
}
