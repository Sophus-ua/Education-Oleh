package Lesson_1.Address;

import java.util.Scanner;

public class Address {
    int apartment;
    String country;
    String city;
    String street;
    String house;
    String index;

    public Address() {
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getIndex() {
        return this.index;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public int getApartment() {
        return this.apartment;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getHouse() {
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
        System.out.printf("\nКраїна: %1s, місто: %2s, вулиця: %3s%4s, квартира:%5d, індекс:%6s;", mailAddress.getCountry(), mailAddress.getCity(), mailAddress.getStreet(), mailAddress.getHouse(), mailAddress.getApartment(), mailAddress.getIndex());
    }
}
