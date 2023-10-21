package org.example.Lesson_01.task_04.looselyCoupled;

import java.util.ArrayList;
import java.util.List;

class BrowsingHistoryService implements IBrowsingHistoryService {
    private final List<String> browsingHistory;

    BrowsingHistoryService () {
        this.browsingHistory = new ArrayList<>();
    }

    @Override
    public void showBrowsingHistory() {
        browsingHistory.forEach(System.out::println);
    }

    @Override
    public void addToBrowsingHistory(String reviewed) {
        browsingHistory.add(reviewed);
    }
}
