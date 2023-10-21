package org.example.Lesson_01.task_04.looselyCoupled;

import java.util.ArrayList;
import java.util.List;

class EmailService implements IEmailService {
    private final List<String> emails;

    EmailService() {
        emails = new ArrayList<>();
    }

    @Override
    public void addEmail(String message) {
        emails.add(message);
    }

    @Override
    public void showEmail(int index) {
        System.out.println(emails.get(index));
    }

    @Override
    public void deleteEmail(int index) {
        emails.remove(index);
    }
}
