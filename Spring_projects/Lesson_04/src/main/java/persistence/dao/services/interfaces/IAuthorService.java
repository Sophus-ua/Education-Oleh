package persistence.dao.services.interfaces;

import org.springframework.stereotype.Service;
import persistence.entity.Author;
import java.util.List;
import java.util.Optional;

@Service
public interface IAuthorService {
    List<Author> findAll();
    void deleteById(Long id);
    Optional<Author> findById(Long id);
    Author save(Author author);

    void deleteAll();

    List<Author> getBaseListOfAuthors();

    Author findAuthorByName(String firstName, String lastName);
}
