package org.softwire.training.bookish.models.page;



import org.softwire.training.bookish.models.database.*;
import org.softwire.training.bookish.models.database.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionPageModel {
    private List<Transaction> transaction;
    private List<Book> books;

    private List<TransactionBook> transactionBooksList;

    public List<Transaction> getAllTransactions() {

        return transaction;
    }

    public List<Book> getAllBooks() {
        return books;
    }
    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<TransactionBook> getBooksForID(){

       List<TransactionBook> transactionBooks = transaction.stream().map(transactionone ->  {
            TransactionBook transactionBook = new TransactionBook();
            transactionBook.setTransaction(transactionone);
            return transactionBook;
        }).collect(Collectors.toList());

       return transactionBooks;

    }
    public List<TransactionBook> getBooksForID2(List<TransactionBook> transactionBook){

        for(int i =0 ; i <  transactionBook.toArray().length; i++ ){
            transactionBook.get(i).setBook(books.get(i));
        }
        return transactionBook;



    }
    public List<TransactionBook> getTransactionBooksList(){
       transactionBooksList =  getBooksForID2(getBooksForID());
       return transactionBooksList;
    }




}