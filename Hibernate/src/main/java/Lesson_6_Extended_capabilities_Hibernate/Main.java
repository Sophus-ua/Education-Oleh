package Lesson_6_Extended_capabilities_Hibernate;


import Lesson_6_Extended_capabilities_Hibernate.Entity.Author;
import Lesson_6_Extended_capabilities_Hibernate.Helpers.AuthorHelper;
import Lesson_6_Extended_capabilities_Hibernate.Helpers.BookHelper;

import java.util.List;

class Main {
    public static void main(String[] args) {
        AuthorHelper authorHelper = new AuthorHelper();
        BookHelper bookHelper = new BookHelper();
        HomeWork homeWork = new HomeWork();

        homeWork.addAuthorsAndBooks(authorHelper, bookHelper);

        /* завдання 3 */
        homeWork.deleteBooks(bookHelper);

        /* завдання 2 */
        homeWork.updateNameWhereMoreThan6(authorHelper);

        /* завдання 5 */
        try {
            String hqlQuery = "from Author where lastName = 'Кинг'";
            List<Author> authors = authorHelper.executeQuery(hqlQuery);

            System.out.print("\033[1;32m");
            authors.forEach(System.out::println);

        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.print("\033[0m");
        }
    }
}
