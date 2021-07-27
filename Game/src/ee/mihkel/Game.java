package ee.mihkel;

import ee.mihkel.character.Enemy;
import ee.mihkel.character.Player;
import ee.mihkel.character.QuestMaster;
import ee.mihkel.item.Dagger;
import ee.mihkel.item.Hammer;
import ee.mihkel.item.Item;
import ee.mihkel.item.Sword;

import java.util.Scanner;

public class Game {

// X  enemy saab surma ja tema elud pannakse uuesti täis
//    enemytel on erinevad tüübid erinevate eludega
//    kui enemy saab surma, siis salvestatakse MAP tüüpi massiivi tema tüüp ja mitu korda
//                                          teda on tapetud
//    itemitel strength kasutusele võtmine - vastavalt tugevusele elude võtmine
//    ItemType kasutusele võtmine - korrutada Strength läbi ItemType-ga
//    ItemType paremaks muutumine ehk leveli tõstmine ja kontroll kui on jõudnud mingi levelini
//    Salvestada sekundid mitu sekundit mängija elude lõpuni jääb
//    Item - Transporter, millega saab mittevõidelda, vaid põgeneda
//    Uus Character nimega Healer, kes on peidetud ehk ilma Symbolita ja ravib juhuslikult
//                      elud täis


//    Angularis veebipood - võtame tooted ja hakkame neid kuvama, saab ostukorvi lisada,
//    saab tooteid administraator juurde lisada, muuta, kustutada
//    Backend võtab need lisamised, muutmised, kustutamised vastu ja salvestab andmebaasi
//    Java Spring + Hibernate

    public static void main(String[] args) {
	    World world = new World(5,4);

	    Player player = new Player(world);
	    world.addCharacter(player);
        Enemy enemy = new Enemy(world);
        world.addCharacter(enemy);
        QuestMaster questMaster = new QuestMaster(world);
        world.addCharacter(questMaster);

        Sword sword = new Sword(world);
        world.addItem(sword);
        Hammer hammer = new Hammer(world);
        world.addItem(hammer);
        Dagger dagger = new Dagger(world);
        world.addItem(dagger);

        world.printMap();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            while(!input.equals("end")) {
                player.move(input, world);

                GameController.checkIfPlayerCanGetItem(world, player);
                GameController.playerAndEnemyMet(player, enemy, scanner);
                GameController.playerAndQuestmasterMet(world, player, enemy, questMaster);

                world.printMap();
                input = scanner.nextLine();
            }
        } catch (GameOverException e) {
            System.out.println("SAID SURMA, MÄNG LÄBI!");
        }
//        if (player health / 1) {
//            System.out.println("SAID SURMA");
//        }
    }
}
