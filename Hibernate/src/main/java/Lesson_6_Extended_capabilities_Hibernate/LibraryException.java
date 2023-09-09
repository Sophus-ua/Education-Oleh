package Lesson_6_Extended_capabilities_Hibernate;

public class LibraryException extends Exception{
    public LibraryException() {
        super();
    }
    public LibraryException(String message) {
        super("\033[4;36m" + message + "\033[0m");
    }
}
