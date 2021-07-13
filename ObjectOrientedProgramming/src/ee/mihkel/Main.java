package ee.mihkel;

import java.util.*;

// nime muutmiseks: sõna aktiivseks, parem klõps, refactor, rename
public class Main {

//    main meetodis läheb programm käima
    public static void main(String[] args) {

//        Animal animal = new Animal(10,10,"bla"); animali tegime abstract klassiks, enam ei saa instantsi luua

//        klass on justkui nagu andmemudel - ta kohustab väärtusi vastu võtma
//        instantsi tekitamiseks pean kõik väärtused lisama koos õigete tüüpidega
	    Mammal kass = new Mammal( 70, 2, "Miisu", false, MammalType.KASS);
        Mammal koer = new Mammal(80, 0, "Muri", true,  MammalType.KOER);
        Mammal tiiger = new Mammal(140, 5, "King", false,  MammalType.TIIGER);
        Mammal rott = new Mammal(10, 1, "Sipsi", false, true, MammalType.ROTT);

        rott.addChild(new Mammal(2,0,"Sipsi II",true,false, MammalType.ROTT));
        rott.addChild(new Mammal(2,0,"Sapsu",true,false, MammalType.ROTT));
        rott.addChild(new Mammal(2,0,"Micky",true,false, MammalType.ROTT));
        rott.addChild(new Mammal(2,0,"Minni",true,false, MammalType.ROTT));
        rott.addChild(new Mammal(2,0,"Mootorrattur hiir",true,false, MammalType.ROTT));

        rott.printOneChild();

        koer.changeToSold(); // siin on void, kuna pole vasakule poole muutujasse midagi panna
        kass.changeToSold();
        kass.increaseAge();
        koer.increaseAge();

        int koerPrice = koer.getPrice(); // siin on mingi tagastus (funktsiooni sees on return), mis pannakse vasakule
        int kassPrice = kass.getPrice();

//        keerasin Private-ks kõik muutujad, seega ei saa neile otse ligi
//        kass.price = 1312312312;
//        int totalPrice = kass.price + koer.price;
        int totalPrice = koerPrice + kassPrice;
        System.out.println("Ostja koguhind oli: " + totalPrice);
//        System.out.println("Ostja koguhind oli: " + totalPrice);
//        System.out.printf("Ostja koguhind oli %d %s", totalPrice, " eurot");
//        System.out.printf("Ostja koguhind oli %d %s", 23, " dollarit");

        rott.setPrice(20);

        System.out.println(kass);
        System.out.println(koer);
        System.out.println(tiiger);
        System.out.println(rott);

        Bird papagoi = new Bird(45,1, "Praagu", BirdColor.RED_YELLOW);
        Bird ookull = new Bird(55,10, "Luigi", BirdColor.BROWN);
        Bird tihane = new Bird(40,1, "Tihha", BirdColor.BLUE_YELLOW);
        Bird leevike = new Bird(50,2, "Leevi", BirdColor.RED);

        System.out.println(papagoi);
        System.out.println(ookull);
        System.out.println(tihane);
        System.out.println(leevike);

//        pean importima Listi ja ArrayListi java.util-st
        List<Animal> koikLoomad = new ArrayList<>();
        koikLoomad.add(kass);
        koikLoomad.add(koer);
        koikLoomad.add(tiiger);
        koikLoomad.add(rott);
        koikLoomad.add(papagoi);
        koikLoomad.add(ookull);
        koikLoomad.add(tihane);
        koikLoomad.add(leevike);

//        foreach + enter
        int koguSumma = 0;
        for (Animal loom:koikLoomad) {
            koguSumma = koguSumma + loom.getPrice();
//             = 0 + 70 (kass.getPrice())
//             = 70 + 80 (koer.getPrice())
        }
//        for (Bird lind:koikLinnud) {
//            koguSumma += lind.getPrice();
//        }
        System.out.println("Kõikide loomade ostmiseks kogusumma: " + koguSumma);
    }
//    main meetodi lõppedes programm lõpetab töötamise
}
