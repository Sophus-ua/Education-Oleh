package persistence.dao.services.implementations;


import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.repositories.IBookRepository;
import persistence.dao.services.interfaces.IBookService;
import persistence.entity.Author;
import persistence.entity.Book;

import java.util.*;

@Slf4j
@Service
public class BookSimpleService implements IBookService{
    private IBookRepository bookRepository;
    @Autowired
    public void setBookRepository(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> findAll() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    @Override
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public void deleteAll() {
        bookRepository.deleteAllNative();
        bookRepository.resetAutoIncrement();
    }

    @Override
    public void fillBaseListOfBooks(List<Author> authors) {
        Book book;

        book = new Book("Талісман");
        book.setAuthors(Arrays.asList(authors.get(0), authors.get(1)));
        save(book);

        book = new Book("Чорний Будинок");
        book.setAuthors(Arrays.asList(authors.get(0), authors.get(1)));
        save(book);

        book = new Book("Сплячі красуні");
        book.setAuthors(Arrays.asList(authors.get(0), authors.get(2)));
        save(book);

        book = new Book("Intro to Alien Invasion");
        book.setAuthors(Arrays.asList(authors.get(2), authors.get(3)));
        save(book);

        book = new Book("Гра Джеральда");
        book.setAuthors(Collections.singletonList(authors.get(0)));
        save(book);
    }
}
