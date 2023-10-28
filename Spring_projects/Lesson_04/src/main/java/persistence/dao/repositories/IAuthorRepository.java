package persistence.dao.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persistence.entity.Author;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface IAuthorRepository extends CrudRepository<Author, Long> {

    @EntityGraph(attributePaths = "books")
    List<Author> findAll();

    void deleteById(Long id);

    @EntityGraph(attributePaths = "books")
    Optional<Author> findById(Long id);

    @EntityGraph(attributePaths = "books")
    Author save(Author author);

    @EntityGraph(attributePaths = "books")
    Author findByFirstNameAndLastName(String firstName, String lastName);

    void deleteAll();

    @Modifying
    @Query(value = "delete from author", nativeQuery = true)
    void deleteAllNative();

    @Modifying
    @Query(value = "ALTER TABLE author AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
