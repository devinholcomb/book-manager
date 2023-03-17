package com.csc340sp23.bookmanager.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author devin
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public String getBooks(Model model) {
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book/list-books";
    }

    @GetMapping("/id={bookID}")
    public String getBook(@PathVariable long bookID, Model model) {
        model.addAttribute("book", bookService.getBook(bookID));
        return "book/book-detail";
    }

    @GetMapping("/delete/id={BookId}")
    public String deleteBook(@PathVariable long bookID, Model model) {
        bookService.deleteBook(bookID);
        return "redirect:/book/all";
    }

    @PostMapping("/create")
    public String createBook(Book book) {

        bookService.saveBook(book);
        return "redirect:/book/all";
    }

    @PostMapping("/update")
    public String updateBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/book/all";
    }
    
    @GetMapping("/new-book")
    public String newBookForm(Model model) {
        return "book/new-book";
    }

    @GetMapping("/update/id={bookId}")
    public String updateBookForm(@PathVariable long bookId, Model model) {
        model.addAttribute("book", bookService.getBook(bookId));
        return "book/update-book";
    }
}
