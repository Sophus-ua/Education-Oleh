package org.example.Lesson_01.task_04.tightlyCoupled;

import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private String password;
    private final List<String> emails;
    private final List<String> subscriptionToServices;
    private final List<String> browsingHistory;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.emails = new ArrayList<>();
        this.subscriptionToServices = new ArrayList<>();
        this.browsingHistory = new ArrayList<>();
    }
    public void changeUsername(String newUsername) {
        this.name = newUsername;
    }
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
    public void addEmail(String message) {
        emails.add(message);
    }
    public void showEmail(int index) {
        System.out.println(emails.get(index));
    }
    public void deleteEmail(int index) {
        emails.remove(index);
    }
    public void subscribeToService(String service) {
        subscriptionToServices.add(service);
    }
    public void unsubscribeFromService(String service) {
        subscriptionToServices.remove(service);
    }
    public void showListOfSubscriptions(String service) {
        subscriptionToServices.forEach(System.out::println);
    }
    public void showBrowsingHistory () {
        browsingHistory.forEach(System.out::println);
    }
    public void addToBrowsingHistory (String reviewed) {
        browsingHistory.add(reviewed);
    }
}


