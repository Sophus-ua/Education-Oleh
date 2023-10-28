package persistence.entity;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AuthorsBooksId that = (AuthorsBooksId) o;

            if (!authorId.equals(that.authorId)) return false;
            return bookId.equals(that.bookId);
        }

        @Override
        public int hashCode() {
            int result = authorId.hashCode();
            result = 31 * result + bookId.hashCode();
            return result;
        }
    }


}
