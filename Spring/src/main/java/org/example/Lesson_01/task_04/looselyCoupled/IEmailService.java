package org.example.Lesson_01.task_04.looselyCoupled;

interface IEmailService {
    void addEmail(String message);

    void showEmail(int index);

    void deleteEmail(int index);
}
