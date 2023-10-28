package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import persistence.dao.services.interfaces.IBookService;
import persistence.entity.Book;
import java.util.Optional;


@Controller
@RequestMapping("/book")
public class BookController {
    private IBookService bookService;

    @GetMapping(value = "/all")
    public ModelAndView listAllBook(ModelAndView modelAndView) {
        modelAndView.addObject("books", bookService.findAll());
        modelAndView.setViewName("/WEB-INF/views/book_all.jsp");
        return modelAndView;
    }

    @GetMapping(value = "/delete_by_id")
    public String deleteBookByID() {
        return "/WEB-INF/views/book_delete_by_id.jsp";
    }

    @PostMapping(value = "/delete_by_id")
    public String deletedBookByID(@ModelAttribute("bookID") Long id, RedirectAttributes redirectAttributes) {
        String message;
        try{
            bookService.deleteById(id);
            message = String.format("Книга з ID %1d видалена з бібліотеки", id);
        } catch (EmptyResultDataAccessException e){
            message = String.format("Книги з ID %1d не має в бібліотеці", id);
        }
        redirectAttributes.addAttribute("message", message);
        return "redirect:/main";
    }

    @GetMapping(value = "/find_by_id")
    public String findBookByID() {
        return "/WEB-INF/views/book_find_by_id.jsp";
    }

    @PostMapping (value = "/find_by_id")
    public String foundBookByID(@ModelAttribute("bookID") Long id, RedirectAttributes redirectAttributes) {
        Optional<Book> optional = bookService.findById(id);
        String message;
        if (optional.isPresent())
            message = String.format(optional.get().toString());
        else
            message = "Книги з таким ID не знайдено";
        redirectAttributes.addAttribute("message", message);
        return "redirect:/main";
    }

    @GetMapping(value = "/add")
    public String addBook() {
        return "/WEB-INF/views/book_add.jsp";
    }

    @PostMapping(value = "/add")
    public String addedBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        Book checkBook = bookService.save(book);
        StringBuilder message = new StringBuilder();
        if (checkBook != null)
            message.append(checkBook).append(" додана до бібліотеки по ID: ").append(checkBook.getId());
        else
            message.append("Книгу не вдалось додати до бібліотеки;");

        redirectAttributes.addAttribute("message", message);
        return "redirect:/main";
    }

    @Autowired
    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }
}
