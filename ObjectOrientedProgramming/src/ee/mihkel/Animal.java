    package ee.mihkel;

import java.util.Scanner;

public abstract class Animal implements ProjectObject {
    private int price;
    private int age;
    private String name;
    private boolean isSold;

    public Animal(int price, int age, String name, boolean isSold) {
        this.price = price;
        this.age = age;
        this.name = name;
        this.isSold = isSold;
    }

    public Animal(int price, int age, String name) {
        this.price = price;
        this.age = age;
        this.name = name;
        this.isSold = false;
    }

    //    parem klõps - generate - getter and setter
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void increaseAgeByOne() {
        this.age++;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSold() {
        return isSold;
    }

    public void changeToSold() {
        Scanner scanner = new Scanner(System.in);
        boolean correctAnswer = false;
//        aktiveerisin kogu koodi, menüüst ülal "Code", "surround with", 3.while
        while (!correctAnswer) {
            System.out.println("Kas on vajalikud dokumendid esitatud? y/n");
            String input = scanner.nextLine();
            if (input.equals("y")) {
                this.isSold = true;
                System.out.println("Müüdud!");
                correctAnswer = true;
            } else if (input.equals("n")) {
                System.out.println("Ei saa dokumentideta müüa!");
                correctAnswer = true;
            } else {
                System.out.println("Palun sisesta y või n!");
            }
        }
    }
}
