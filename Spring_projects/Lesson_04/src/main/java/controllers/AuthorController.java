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
import persistence.dao.services.interfaces.IAuthorService;
import persistence.entity.Author;
import java.util.Optional;


@Controller
@RequestMapping("/author")
public class AuthorController {
    private IAuthorService authorService;

    @GetMapping(value = "/all")
    public ModelAndView listAllAuthors(ModelAndView modelAndView) {
        modelAndView.addObject("authors", authorService.findAll());
        modelAndView.setViewName("/WEB-INF/views/author_all.jsp");
        return modelAndView;
    }

    @GetMapping(value = "/delete_by_id")
    public String deleteAuthorByID() {
        return "/WEB-INF/views/author_delete_by_id.jsp";
    }

    @PostMapping(value = "/delete_by_id")
    public String deletedAuthorByID(@ModelAttribute("authorID") Long id, RedirectAttributes redirectAttributes) {
        String message;
        try {
            authorService.deleteById(id);
            message = String.format("Автор з ID %1d видалений з бібліотеки", id);
        } catch (EmptyResultDataAccessException e) {
            message = String.format("Автора з ID %1d не має в бібліотеці", id);
        }
        redirectAttributes.addAttribute("message", message);
        return "redirect:/main";
    }

    @GetMapping(value = "/find_by_id")
    public String findAuthorByID() {
        return "/WEB-INF/views/author_find_by_id.jsp";
    }

    @PostMapping(value = "/find_by_id")
    public String foundAuthorByID(@ModelAttribute("authorID") Long id, RedirectAttributes redirectAttributes) {
        Optional<Author> optional = authorService.findById(id);
        String message;
        if (optional.isPresent())
            message = String.format(optional.get().toString());
        else
            message = "Автора з таким ID не знайдено";
        redirectAttributes.addAttribute("message", message);
        return "redirect:/main";
    }

    @GetMapping(value = "/add")
    public String addAuthor() {
        return "/WEB-INF/views/author_add.jsp";
    }

    @PostMapping(value = "/add")
    public String addedAuthor(@ModelAttribute("author") Author author, RedirectAttributes redirectAttributes) {
        Author checkAuthor = authorService.save(author);
        StringBuilder message = new StringBuilder();
        if (checkAuthor != null)
            message.append(checkAuthor).append(" додано до бібліотеки по ID: ").append(checkAuthor.getId());
        else
            message.append("Автора не вдалось додати до бібліотеки;");

        redirectAttributes.addAttribute("message", message);
        return "redirect:/main";
    }


    @Autowired
    public void setAuthorService(IAuthorService authorService) {
        this.authorService = authorService;
    }
}
