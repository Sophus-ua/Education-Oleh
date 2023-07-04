package Lesson_9.Task_2;

import java.util.Arrays;

public class MyList<T>{
    private T[] myList;
    private int filledIndex, maxSize;
    MyList(){
        myList = (T[]) new Object[10];
        filledIndex = -1;
        maxSize = 10;
    }
    void add(T element){
        if (filledIndex+1>maxSize) increaseSize();
        myList[++filledIndex] = element;
    }
    void increaseSize (){
        maxSize += 10;
        myList = Arrays.copyOf(myList,maxSize);
    }
    int size(){
        return filledIndex+1;
    }
    T get (int index){
        if (index > filledIndex || index < 0){
            System.out.println("За таким індексом нема елемента");
            return null;
        }else return myList[index];
    }
}
