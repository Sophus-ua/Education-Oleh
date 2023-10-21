package org.example.Lesson_01.task_04.looselyCoupled;



class User {
    private String name;
    private String password;

    private final ISubscriptionService subscriptionService;
    private final IEmailService emailService;
    private final IBrowsingHistoryService browsingHistoryService;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        subscriptionService = new SubscriptionService();
        emailService = new EmailService();
        browsingHistoryService = new BrowsingHistoryService();
    }

    public void changeUsername(String newUsername) {
        this.name = newUsername;
    }
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
    public void addEmail(String message) {
        emailService.addEmail(message);
    }
    public void showEmail(int index) {
        emailService.showEmail(index);
    }
    public void deleteEmail(int index) {
        emailService.deleteEmail(index);
    }
    public void subscribeToService(String service) {
        subscriptionService.subscribeToService(service);
    }
    public void unsubscribeFromService(String service) {
        subscriptionService.unsubscribeFromService(service);
    }
    public void showListOfSubscriptions() {
        subscriptionService.showListOfSubscriptions();
    }
    public void showBrowsingHistory () {
        browsingHistoryService.showBrowsingHistory();
    }
    public void addToBrowsingHistory (String reviewed) {
        browsingHistoryService.addToBrowsingHistory(reviewed);
    }
}
