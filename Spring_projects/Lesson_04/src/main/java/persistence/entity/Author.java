package persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "author", schema = "library")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;


    public Author() {
        books = new ArrayList<Book>();
    }

    public Author(String firstName, String lastName) {
        books = new ArrayList<Book>();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public String toString() {
        StringBuilder booksList = new StringBuilder();
        if (books != null && !books.isEmpty()){
            booksList.append(",    книги автора:  ");
            books.forEach(x -> booksList.append("\"").append(x.getTitle()).append("\",  "));
            booksList.setLength(booksList.length()-3);
            booksList.append(";");
        }

        return String.format("%1s %2s%3s", firstName, lastName, booksList);
    }
}

