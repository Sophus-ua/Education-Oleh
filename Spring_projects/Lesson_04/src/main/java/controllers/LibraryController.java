package controllers;


import models.IdsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import persistence.dao.services.interfaces.IAuthorService;
import persistence.dao.services.interfaces.IBookService;
import persistence.entity.Author;
import persistence.entity.Book;
import java.util.List;
import java.util.Optional;


@Controller
public class LibraryController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IAuthorService authorService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(@RequestParam(name = "message", required = false, defaultValue = "") String message, Model model) {
        model.addAttribute("message", message);
        return "/WEB-INF/views/main.jsp";
    }

    @PostMapping(value = "/deleteAll")
    public String deleteAll(RedirectAttributes redirectAttributes) {
        bookService.deleteAll();
        authorService.deleteAll();
        String message = "Бібліотека очищена";
        redirectAttributes.addAttribute("message", message);
        return "redirect:/main";
    }

    @GetMapping(value = "/add_by_id")
    public String addBookToAuthor(Model model) {
        IdsModel idsModel = new IdsModel();
        model.addAttribute("idsModel", idsModel);
        return "/WEB-INF/views/add_by_id.jsp";
    }

    @PostMapping(value = "/add_by_id")
    public String addedBookToAuthor(@ModelAttribute("idsModel") IdsModel idsModel, RedirectAttributes redirectAttributes) {
        StringBuilder message = new StringBuilder();

        Optional<Author> optionalAuthor = Optional.empty();
        Long authorID = idsModel.getAuthorId();
        if (authorID != null && authorID > -1)
            optionalAuthor = authorService.findById(authorID);

        Author author = null;
        if (optionalAuthor.isPresent())
            author = optionalAuthor.get();
        else
            message.append("в бібліотеці нема автора з таким ID");

        Optional<Book> optionalBook = Optional.empty();
        Long bookID = idsModel.getBookId();
        if (bookID != null && bookID > -1)
            optionalBook = bookService.findById(bookID);

        Book book = null;
        if (optionalBook.isPresent())
            book = optionalBook.get();
        else {
            if (message.length() > 0)
                message.append("\n");
            message.append("в бібліотеці нема книги з таким ID");
        }

        if (author != null && book != null) {
            author.addBook(book);
            book.addAuthor(author);
            authorService.save(author);
            bookService.save(book);
            message.append("Книга додана автору по вказаним ID");
        }

        redirectAttributes.addAttribute("message", message);
        return "redirect:/main";
    }

    @PostMapping(value = "/autoFilling")
    public String autoFilling(RedirectAttributes redirectAttributes) {
        List<Author> authors = authorService.getBaseListOfAuthors();
        bookService.fillBaseListOfBooks(authors);

        String message = "Бібліотека заповнена";
        redirectAttributes.addAttribute("message", message);
        return "redirect:/main";
    }
}
