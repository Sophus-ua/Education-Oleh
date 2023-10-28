package persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "book", schema = "library")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    private String title;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authors_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    public Book() {
        authors = new ArrayList<>();
    }

    public Book(String title) {
        authors = new ArrayList<>();
        this.title = title;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    @Override
    public String toString() {
        StringBuilder authorsList = new StringBuilder();
        if (authors != null && !authors.isEmpty()){
            authorsList.append("   за авторством:  ");
            authors.forEach(x -> authorsList.append(x.getFirstName()).append("  ").append(x.getLastName()).append(",  "));
            authorsList.setLength(authorsList.length()-3);
            authorsList.append(";");
        }

        return String.format("Книга: \"%1s\"%2s", title, authorsList);
    }
}
