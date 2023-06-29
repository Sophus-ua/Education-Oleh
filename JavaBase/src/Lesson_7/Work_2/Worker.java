package Lesson_7.Work_2;



import java.time.LocalDate;
import java.util.Scanner;


class Worker {
    private String nameEmployer, jobTitle;
    private int yearOfEmployment;
    Worker (){}
    Worker (String name, String jobTitle, int year ){
        this.nameEmployer = name;
        this.jobTitle = jobTitle;
        this.yearOfEmployment = year;
    }
    int getYearOfEmployment (){
        return this.yearOfEmployment;
    }
    String getNameEmployer (){
        return this.nameEmployer;
    }
    Worker edit (int i) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть ім'я " + (i+1) + "-го співробітника:");
        String name = in.nextLine();
        System.out.println("Введіть посаду " + (i+1) + "-го співробітника:");
        String jobTitle = in.nextLine();
        System.out.println("Введіть рік прийому на роботу:");
        int validYear = validateYear();
        return new Worker(name, jobTitle, validYear);
    }

    int validateYear () {
        Scanner in = new Scanner(System.in);

        LocalDate time = LocalDate.now();
        int maxYear = time.getYear();
        int minYear = 1998;                 //рік заснування компанії
        int validYear = 0;

        boolean again = true;
        while (again){
            if (in.hasNextInt()){
                try {
                    int year = in.nextInt();
                    if (year < minYear || year > maxYear) throw new Exception("\033[0;31mВи ввели невірний рік, введіть ще раз:\033[0m");
                    again = false;
                    validYear = year;
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }else System.out.println("\033[0;31mВи ввели некоректне значення, введіть ще раз:\033[0m");
            in.nextLine();
        }
        return validYear;
    }
    Worker[] sortArray (Worker[] array){
        int count = 0;
        for (int i = count; i< array.length; i++){
            count++;
            for(int j = i; j< array.length; j++){
                if (array[j].nameEmployer.compareToIgnoreCase(array[i].getNameEmployer()) < 0) {
                    Worker change = array[i];
                    array[i] = array[j];
                    array[j] = change;
                }
            }
        }
        return array;
    }
    void experience (Worker[] array){
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть мінімальний стаж роботи працівника:");
        int yearsNeedExperience = in.nextInt();
        LocalDate time = LocalDate.now();

        System.out.println("Працівники у яких стаж роботи більший введенного значення:");
        for (Worker temp : array){
            int yearsOfExperience = time.getYear() - temp.getYearOfEmployment();
            if (yearsOfExperience > yearsNeedExperience){
                System.out.println(temp.nameEmployer + ", " + temp.jobTitle + ";");
            }
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        Worker[] company = new Worker[5];

        System.out.print("Заповніть данні співробітників; ");
        for (int i = 0; i< company.length; i++) {
            company[i] = worker.edit(i);
        }

        company = company[0].sortArray(company);
        System.out.print("Список працівників: ");
        for (Worker temp : company){
            System.out.print(temp.nameEmployer + "; ");
        }
        System.out.println();

        worker.experience(company);
    }
}
