package persistence.dao.services.implementations;


import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.repositories.IAuthorRepository;
import persistence.dao.services.interfaces.IAuthorService;
import persistence.entity.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AuthorSimpleService implements IAuthorService {
    private IAuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return Lists.newArrayList(authorRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAll() {
        authorRepository.deleteAllNative();
        authorRepository.resetAutoIncrement();
    }

    @Override
    public List<Author> getBaseListOfAuthors() {
        List<Author> authors = Arrays.asList(
                new Author("Стівен", "Кінг"),
                new Author("Пітер", "Страуб"),
                new Author("Оуен", "Кінг"),
                new Author("Mark", "Poirier")
        );
        List<Author> addedAuthors = new ArrayList<>();
        for (Author author : authors) {
            addedAuthors.add(save(author));
        }
        return addedAuthors;
    }

    @Override
    public Author findAuthorByName(String firstName, String lastName) {
        return authorRepository.findByFirstNameAndLastName( firstName, lastName);
    }

}
