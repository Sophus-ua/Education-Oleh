package Lesson_2_Collections.Task_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Cities {
    Map<String, String> list;
    Cities(){
        this.list = new HashMap<>();
    }
    void filling(){
        list.put("Київ", "Бугай");
        list.put("Дніпро", "Тягай");
        list.put("Одеса", "Мовчан");
        list.put("Запоріжжя", "Рубан");
        list.put("Львів", "Скрипаль");
        list.put("Житомир", "Коваль");
        list.put("Вінниця", "Кобзар,");
        list.put("Харків", "Кухар");
        list.put("Івано-Франківськ", "Копач");
        list.put("Луцьк", "Ткач");
        list.put("Тернопіль", "Плаксій");
        list.put("Хмельницький", "Палій");
        list.put("Кропивницький", "Трясило");
        list.put("Полтава", "Покотило");
        list.put("Рівне", "Нечитайло");
        list.put("Черкаси", "Міняйло");
        list.put("Миколаїв", "Мельник");
        list.put("Чернівці", "Колісник");
        list.put("Чернігів", "Прядун");
        list.put("Суми", "Ковтун");
        list.put("Херсон", "Скляр");
        list.put("Ужгород", "Маляр");
    }

    public static void main(String[] args) {
        Cities myList = new Cities();
        Scanner in = new Scanner(System.in);

        myList.filling();

        System.out.println("Введіть назву міста:");
        String str = in.nextLine();
        System.out.println("В цьому місті проживає " + myList.list.get(str));
        in.close();
    }
}
