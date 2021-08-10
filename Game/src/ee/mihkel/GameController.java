package ee.mihkel;

import ee.mihkel.character.Enemy;
import ee.mihkel.character.Healer;
import ee.mihkel.character.Player;
import ee.mihkel.character.QuestMaster;
import ee.mihkel.item.Item;
import ee.mihkel.item.Transporter;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public abstract class GameController {
    private static int seconds;

    public static int getSeconds() {
        return seconds;
    }

    public static void checkIfPlayerCanGetItem(World world, Player player) {
        for (Item i: world.getItems()) {
            if (i.getxCoord() == player.getxCoord() && i.getyCoord() == player.getyCoord()) {
                if (!player.getInventory().contains(i)) {
                    player.addToInventory(i);
                } else {
                    i.increaseDurability();
                }
            }
        }
    }

    public static void playerAndEnemyMet(Player player, Enemy enemy, Scanner scanner, World world) throws GameOverException {
        if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord()
                && enemy.isVisible()) {
            enemy.setVisible(false);
            System.out.println("Kohtusid vaenlasega!");
            if (player.isInventoryEmpty()) {
                System.out.println("Sul pole relvi, et võidelda, mine korja!");
            } else {
                chooseWeapon(player, enemy, scanner, world);
            }
        }
    }

    private static void chooseWeapon(Player player, Enemy enemy, Scanner scanner, World world) throws GameOverException {
        String input;
        System.out.println("Vali millist relva tahad: ");
        player.showInventory();
        Item item = null;
        while (item == null) {
            input = scanner.nextLine();
            try {
                item = player.getFromInventory(Integer.parseInt(input));
                item.decreaseDurability(player);
                System.out.println("Valisid relva: " + item.getClass().getName().substring(15));
                if (item.getClass().getName().substring(15).equals("Transporter")) {
                    player.randomiseCoordinates(world);
                } else {
                    fightWithEnemy(player, enemy, scanner, item);
                }
            } catch (NumberFormatException e) {
                System.out.println("Sisestad numbri asemel vale sümboli, sisesta uuesti!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Sisestad mittesobiva numbri, sisesta uuesti!");
            }
        }
    }

    private static void fightWithEnemy(Player player, Enemy enemy, Scanner scanner, Item item) throws GameOverException {
        Random rand = new Random();
        while (enemy.getHealth() > 0) {
            System.out.println("Löömiseks ütle üks number 1-3");
            int enemyFightNumber = rand.nextInt(3)+1;
            int playerFightNumber = 0;
            System.out.println(enemyFightNumber);
            while (playerFightNumber == 0) {
                try {
                    String input = scanner.nextLine();
                    playerFightNumber = Integer.parseInt(input);
                    if (playerFightNumber < 1  || playerFightNumber > 3) {
                        System.out.println("Sisestasid liiga suure või väikse numbri, sisesta uuesti!");
                        playerFightNumber = 0;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Sisestad numbri asemel vale sümboli, sisesta uuesti!");
                }
            }
            if (enemyFightNumber != playerFightNumber) {
//                enemy.takeHealth();
                item.hit(enemy);
                System.out.println("eseme level:" + item.getLevel() + "eseme tüüp: " + item.getItemType());
                System.out.println("Võtsid vaenlaselt " + item.getStrength() + " elu! Elusid alles: " + enemy.getHealth());
            } else {
                player.takeHealth();
                System.out.println("Kaotasid elu! Elusid alles: " + player.getHealth());
                if (player.getHealth() == 0) {
                    throw new GameOverException();
                }
            }
        }
        System.out.println("Vaenlane sai surma! Tapetud vaenlase tüüp: " + enemy.getEnemyType());
        player.addToKilledEnemies(enemy.getEnemyType());
    }

    public static void playerAndQuestmasterMet(World world, Player player, Enemy enemy, QuestMaster questMaster) {
        if (player.getxCoord() == questMaster.getxCoord() &&
                player.getyCoord() == questMaster.getyCoord() &&
                questMaster.isVisible()) {
            questMaster.setVisible(false);
            enemy.randomiseCoordinates(world);
            enemy.setVisible(true);
        } else if (!questMaster.isVisible() &&
                !(player.getxCoord() == questMaster.getxCoord() && player.getyCoord() == questMaster.getyCoord())) {
            questMaster.setVisible(true);
        }
    }

    public static void startTimer(Timer timer) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seconds++;
            }
        }, 1000, 1000);
    }

    public static void playerAndHealerMet(Player player, Healer healer) {
        if (player.getxCoord() == healer.getxCoord() && player.getyCoord() == healer.getyCoord()) {
            healer.reboostPlayer(player);
            System.out.println("Leidsid ravitseja, kes ravis su elud täis!");
        }
    }
}
