package org.example.Lesson_02.task_02;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lesson_02.xml");
        Book book = context.getBean("myBook", Book.class);

        System.out.println(book);
    }
}
