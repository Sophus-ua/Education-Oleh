package Lesson_6_Extended_capabilities_Hibernate.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authors_books", schema = "library")
public class AuthorsBooks {

    @EmbeddedId
    private AuthorsBooksId id;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Book book;

    @Embeddable
    private static class AuthorsBooksId implements Serializable {
        @Column(name = "author_id")
        private Long authorId;

        @Column(name = "book_id")
        private Long bookId;
    }
}
