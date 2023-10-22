package org.example.Lesson_02.task_02;

public class Book {
    private final String title;
    private String author;
    private int price;

    public Book(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void init(){
        this.price = 100;

    }

    @Override
    public String toString() {
        return String.format("Book title: %1s, author: %2s, price: %3d",title, author, price);
    }
}
