package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionService extends DatabaseService {



    public List<Transaction> getAllTransctionsForUser(int userID) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM transactions where userID = :userId")
                        .bind( "userId", userID)
                        .mapToBean(Transaction.class)
                        .list()
        );
    }

    public Book getbookInfoForID(Transaction transaction) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM Books where BookID = :BookID")
                        .bind( "BookID", transaction.getBookID())
                        .mapToBean(Book.class)
                        .list()
                        .get(0)
        );
    }
}
