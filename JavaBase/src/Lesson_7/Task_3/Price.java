package Lesson_7.Task_3;

import java.util.Scanner;

class Price {
    String productName, shopName;
    double priceOfProduct;
    Price (){}
    Price (String shopName, String productName, double priceOfProduct){
        this.shopName = shopName;
        this.productName = productName;
        this.priceOfProduct = priceOfProduct;
    }
    Price edit (int i){
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть назву " + (i+1) + "-го магазину:");
        String shopName = in.nextLine();

        System.out.println("Введіть назву " + (i+1) + "-го товару:");
        String productName = in.nextLine();

        System.out.println("Введіть ціну в грн " + (i+1) + "-го товару:");
        double priceOfProduct = 0;
        boolean replay = true;
        while (replay){
            try{
                priceOfProduct = in.nextDouble();
                replay = false;
            }catch (Exception e){
                System.out.println("\033[0;31mВи ввели невірні данні, спробуйте ще раз:\033[0m");
                in.nextLine();
            }
        }
        return new Price(shopName,productName,priceOfProduct);
    }
    Price[] sortArray (Price[] array){
        for (int i = 0; i< array.length-1; i++){
            if ((array[i].shopName.compareToIgnoreCase(array[i+1].shopName))>0){
                Price replace = array[i];
                array[i] = array[i+1];
                array[i+1] = replace;
            }
        }
        return array;
    }
    int validationShopName (Price[] array){
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведіть назву магазину з якого показати товар:");
        int index = -1;

        boolean replay = true;
        while (replay) {
            String shopName = in.nextLine();
            for (int i = 0; i < array.length; i++){
                if (array[i].shopName.equalsIgnoreCase(shopName)){
                    replay = false;
                    index = i;
                    break;
                }
            }
            try {
                if (replay) throw new Exception("\033[0;35mВведенного магазину немає в списку, спробуйте ще раз\033[0m");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Price product = new Price();
        Price[] array = new Price[2];

        for (int i = 0; i < array.length; i++){
            array[i] = product.edit(i);
        }

        array = product.sortArray(array);

        int i = product.validationShopName(array);
        System.out.printf("В цьому магазині є %s за ціною %.2f грн\n", array[i].productName, array[i].priceOfProduct);
    }
}
