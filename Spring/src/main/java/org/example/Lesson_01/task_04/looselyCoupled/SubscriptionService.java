package org.example.Lesson_01.task_04.looselyCoupled;

import java.util.ArrayList;
import java.util.List;

class SubscriptionService implements ISubscriptionService {
    private final List<String> subscriptionToServices;

    SubscriptionService() {
        this.subscriptionToServices = new ArrayList<>();
    }

    @Override
    public void subscribeToService(String service) {
        subscriptionToServices.add(service);
    }

    @Override
    public void unsubscribeFromService(String service) {
        subscriptionToServices.remove(service);
    }

    @Override
    public void showListOfSubscriptions() {
        subscriptionToServices.forEach(System.out::println);
    }
}
