package ee.mihkel;

import java.util.*;

public class Main {

// int tüüpi numbritega on võimalik arvutusi teha
// string tüüpi muutujatega on võimalik võtta esimene täht, viimane täht, uppercase, lowecase, keskmine täht


    public static void main(String[] args) {
        boolean trueVoiFalse = true;
        int number = 7;
//        double, float, long
        String sona = "sõna";
        char taht = 'a';

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta oma vanus: ");
        String input = scanner.nextLine();
        int inputAsNumber = Integer.parseInt(input);

        if (inputAsNumber < 18 ) {
            System.out.println("Oled alaealine!");
        } else if (input.equals("21")) {
            System.out.println("Oled 21!");
        } else {
            System.out.println("Oled täisealine!");
        }

        switch(inputAsNumber) {
            case 18:
                System.out.println("Oled 18!");
                break;
            case 21:
                System.out.println("Oled 21!");
                break;
            default:
                System.out.println("Sa pole 18 ega 21!");
                break;
        }

        List array = new ArrayList();
        array.add("sink");
        array.add("coca");
        array.add("piim");
        array.add("õlu");
        array.add("õlu");
        array.add("õlu");
        array.add("õlu");
        array.add("toiduõli");
        array.add("või");
    // ["sink", "coca", "piim", "õlu", "toiduõli", "või"]

//        for (int i = 0; i < array.size(); i++) {
//            System.out.println(array.get(i));
//        }
//
//        System.out.println(array.get(0));
//        System.out.println(array.get(1));
//        System.out.println(array.get(2));
//        System.out.println(array.get(3));
//        System.out.println(array.get(4));
//        System.out.println(array.get(5));

        array.remove(0);

        for (int i = 0; i < array.size(); i++) {
//            System.out.println((i+1) + ": " + array.get(i));
        }

        for (Object s: array) { // s = "indeksiga0Element", s = "indeksiga1Element ...........
            System.out.println(s);
        }

//        int j = 0;
//        while (j == 0) {
//            System.out.println(array.get(j));
//            j++;
//        }
//
//        int result = 0;
//        do {
//            j = j + 1;
//            result = result + j;
//        } while (false);

    }
}
