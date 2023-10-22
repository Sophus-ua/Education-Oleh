package org.example.Lesson_02.task_03;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.example.Lesson_02.task_02.Book;



@Configuration
public class BookConfig {
    @Bean(initMethod = "init")
    public Book myBook() {
        Book book = new Book("Kobzar");
        book.setAuthor("Taras Shevchenko");
        return book;
    }
}

