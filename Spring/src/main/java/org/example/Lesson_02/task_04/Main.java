package org.example.Lesson_02.task_04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lesson_02.xml");
        HashMap<String, User> usersMap = context.getBean("usersMap", HashMap.class);
        for (Map.Entry<String, User> entry : usersMap.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
