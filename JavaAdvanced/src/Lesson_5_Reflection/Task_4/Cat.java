package Lesson_5_Reflection.Task_4;

import java.lang.reflect.Field;
import java.util.Scanner;

class Cat {
    Animal cat;
    Class<?> reflectionLink;
    Cat(){
        cat = new Animal();
        reflectionLink = cat.getClass();
    }
    void editingFields (){
        try (Scanner in = new Scanner(System.in)){
            Field[] fields = reflectionLink.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType().equals(String.class)) {
                    System.out.println("Введіть текстове значення для поля\033[1;33m " + field.getName() + "\033[0m:");
                    field.set(cat, in.nextLine());
                }if (field.getType().equals(int.class)) {
                    System.out.println("Введіть int значення для поля\033[1;33m " + field.getName() + "\033[0m:");
                    field.setInt(cat, in.nextInt());
                }if (field.getType().equals(boolean.class)) {
                    System.out.println("Введіть boolean значення для поля\033[1;33m " + field.getName() + "\033[0m:");
                    field.set(cat, in.nextBoolean());
                }
                field.setAccessible(false);
            }
        }catch (Exception e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }
    void fieldsShow(){
        System.out.println("\033[4;35mЗначення полів створенного екземпляру Cat:\033[0m");

        Field[] fields = reflectionLink.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println("Поле \033[1;33m" + field.getName() + "\033[0m має значення: " + field.get(cat).toString());
                field.setAccessible(false);
            }
        }catch (Exception e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
