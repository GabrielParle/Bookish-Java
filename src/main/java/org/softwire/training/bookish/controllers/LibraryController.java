package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.LibraryPageModel;
import org.softwire.training.bookish.services.DatabaseService;
import org.softwire.training.bookish.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping("")
    ModelAndView library() {

        List<Book> allBooks = libraryService.getAllBooks();

        LibraryPageModel libraryPageModel = new LibraryPageModel();
        libraryPageModel.setBooks(allBooks);

        return new ModelAndView("library", "model", libraryPageModel);
    }

    @RequestMapping("/add-book")
    RedirectView addBook(@ModelAttribute Book book) {

        libraryService.addBook(book);

        return new RedirectView("/library");
    }

    @RequestMapping("/delete-book")
    RedirectView deleteBook(@RequestParam int bookID) {

        libraryService.deleteBook(bookID);

        return new RedirectView("/library");
    }
}
