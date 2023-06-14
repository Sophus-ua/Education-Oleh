package Lesson_1.Address;

import java.util.Scanner;

class Address {
    int apartment;
    String country, city, street, house, index;

    void setIndex(String index) {
        this.index = index;
    }

    String getIndex() {
        return this.index;
    }

    void setApartment(int apartment) {
        this.apartment = apartment;
    }

    int getApartment() {
        return this.apartment;
    }

    void setCountry(String country) {
        this.country = country;
    }

    String getCountry() {
        return this.country;
    }

    void setCity(String city) {
        this.city = city;
    }

    String getCity() {
        return this.city;
    }

    void setStreet(String street) {
        this.street = street;
    }

    String getStreet() {
        return this.street;
    }

    void setHouse(String house) {
        this.house = house;
    }

    String getHouse() {
        return this.house;
    }

    public static void main(String[] args) {
        Address mailAddress = new Address();
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть країну:");
        mailAddress.setCountry(in.nextLine());
        System.out.println("Введіть назву міста:");
        mailAddress.setCity(in.nextLine());
        System.out.println("Введіть вулицю:");
        mailAddress.setStreet(in.nextLine());
        System.out.println("Введіть номер будинку:");
        mailAddress.setHouse(in.nextLine());
        System.out.println("Введіть номер квартири:");
        mailAddress.setApartment(in.nextInt());
        System.out.println("Введіть індекс:");
        mailAddress.setIndex(in.next());

        System.out.printf("\nКраїна: %1s, місто: %2s, вулиця: %3s%4s, квартира:%5d, індекс:%6s;", mailAddress.getCountry(),
                mailAddress.getCity(), mailAddress.getStreet(), mailAddress.getHouse(), mailAddress.getApartment(), mailAddress.getIndex());
    }
}
