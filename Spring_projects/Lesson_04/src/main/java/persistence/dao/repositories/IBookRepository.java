package persistence.dao.repositories;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persistence.entity.Book;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface IBookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();

    void deleteById(Long id);

    Optional<Book> findById(Long id);

    Book save(Book book);

    void deleteAll();
    @Modifying
    @Query(value = "delete from book", nativeQuery = true)
    void deleteAllNative();

    @Modifying
    @Query(value = "ALTER TABLE book AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();

}
