package controllers;

import lombok.Data;

@Data
public class NumberOfRegistered {
    private volatile static Integer countOfUsers;

    public static void increaseCountOfUsers(){
        synchronized (User.class) {
            if (countOfUsers == null) countOfUsers = 0;
            countOfUsers++;
        }
    }
    public static int getCountOfUsers() {
        return countOfUsers;
    }
}
