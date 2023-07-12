package Lesson_2_Collections.Task_3;


import java.util.*;

class MinFromN {
    List<Integer> myList;

    public MinFromN(){
        myList = new LinkedList<>();
    }
    void getIntegerList (){
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введіть ціле число яке буде кількістью елементів цілих чисел в новому списку:");
        int num = in.nextInt();
        for (int i = 0; i < num; i++) {
            this.myList.add(random.nextInt(98)+1);
        }
    }
    Integer getMinimum (){
        Iterator<Integer> iterator = this.myList.iterator();
        Integer min = this.myList.get(0);

        while (iterator.hasNext()){
            Integer check = iterator.next();
            System.out.print(check + "; ");
            if (check<min) min = check;
        }
        return min;
    }

    public static void main(String[] args) {
        MinFromN myList = new MinFromN();

        myList.getIntegerList();
        System.out.println("\nМінімальне число зі списку: " + myList.getMinimum());
    }
}
