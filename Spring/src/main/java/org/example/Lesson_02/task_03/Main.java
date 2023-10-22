package org.example.Lesson_02.task_03;

import org.example.Lesson_02.task_02.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
        Book book = context.getBean("myBook", Book.class);

        System.out.println(book);
    }
}
