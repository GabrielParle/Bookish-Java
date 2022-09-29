package org.softwire.training.bookish.models.database;

public class TransactionBook {

    public Transaction transaction = new Transaction();
    private Book book = new Book();

    public TransactionBook() {

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
