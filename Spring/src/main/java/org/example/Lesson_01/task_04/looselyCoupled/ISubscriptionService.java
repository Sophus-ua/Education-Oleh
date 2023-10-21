package org.example.Lesson_01.task_04.looselyCoupled;

interface ISubscriptionService {
    void subscribeToService(String service);

    void unsubscribeFromService(String service);

    void showListOfSubscriptions();
}
