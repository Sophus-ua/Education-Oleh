package Lesson_9_Lambda_Stream.task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();

        Random random = new Random();
        IntStream.generate(() -> random.nextInt(3))
                .limit(10)
                .forEach(myList::add);

        System.out.println("Створенний список рандомних чисел: " + myList);

        int sumOfSquares = myList.stream()
                .map(num -> num * num)
                .reduce(0, Integer::sum);
        System.out.println("Сумма всіх квадратів чисел списка: " + sumOfSquares);
    }
}
