package Lesson_9.Task_3;

import java.util.ArrayList;
import java.util.List;

class MyDictionary<T> {
    private List<T> concept, explanation;
    MyDictionary() {
        concept = new ArrayList<>();
        explanation = new ArrayList<>();
    }
    void addPairOfElements(T concept, T explanation){
        this.concept.add(concept);
        this.explanation.add(explanation);
    }
    void indexer (int index){
        System.out.println("\n\033[1;32m" + concept.get(index) + "\033[0m - " + explanation.get(index));
    }
    void numberOfElements(){
        try {
            System.out.printf("В словнику %d пара(и) елементів", concept.size());
        }catch (NullPointerException e){
            System.err.println("В словнику нуль елементів");
        }
    }
}
