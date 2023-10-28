package persistence.dao.services.interfaces;

import org.springframework.stereotype.Service;
import persistence.entity.Author;
import persistence.entity.Book;
import java.util.List;
import java.util.Optional;

@Service
public interface IBookService {
    List<Book> findAll();
    void deleteById(Long id);
    Optional<Book> findById(Long id);
    Book save(Book book);

    void deleteAll();

    void fillBaseListOfBooks(List<Author> authors);
}
