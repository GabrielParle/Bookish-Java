package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Transaction;


public interface TransactionInterface {
 Transaction operation(Transaction b);

    int getBookID();
}
