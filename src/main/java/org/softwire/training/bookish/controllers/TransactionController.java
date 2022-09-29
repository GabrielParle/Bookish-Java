package org.softwire.training.bookish.controllers;


import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Transaction;
import org.softwire.training.bookish.models.database.TransactionBook;
import org.softwire.training.bookish.models.database.User;
import org.softwire.training.bookish.models.page.TransactionPageModel;
import org.softwire.training.bookish.models.page.UserPageModel;
import org.softwire.training.bookish.services.TransactionInterface;
import org.softwire.training.bookish.services.TransactionService;
import org.softwire.training.bookish.services.UserService;
//import org.softwire.training.bookish.services.transactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping("")
    ModelAndView aboutUs(@RequestParam int userID) {

        List<Transaction> allTransaction = transactionService.getAllTransctionsForUser(userID);

        List<Book> allBookInfo = allTransaction.stream().map(transaction -> getBookInfo(transaction))
                .collect(Collectors.toList());

        TransactionPageModel transactionPageModel = new TransactionPageModel();
        transactionPageModel.setTransaction(allTransaction);
        transactionPageModel.setBooks(allBookInfo);
        //transactionPageModel.getTransactionBooksList();

        return new ModelAndView("transaction", "model", transactionPageModel);
    }


    public Book getBookInfo(Transaction transaction){
        return transactionService.getbookInfoForID(transaction);
    }
}
