package ee.mihkel;

import ee.mihkel.character.Enemy;
import ee.mihkel.character.Player;
import ee.mihkel.character.QuestMaster;
import ee.mihkel.item.Item;

import java.util.Random;
import java.util.Scanner;

public class GameController {
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

    public static void playerAndEnemyMet(Player player, Enemy enemy, Scanner scanner) throws GameOverException {
        if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord()
                && enemy.isVisible()) {
            enemy.setVisible(false);
            System.out.println("Kohtusid vaenlasega!");
            if (player.isInventoryEmpty()) {
                System.out.println("Sul pole relvi, et võidelda, mine korja!");
            } else {
                chooseWeapon(player, enemy, scanner);
            }
        }
    }

    private static void chooseWeapon(Player player, Enemy enemy, Scanner scanner) throws GameOverException {
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
                fightWithEnemy(player, enemy, scanner);
            } catch (NumberFormatException e) {
                System.out.println("Sisestad numbri asemel vale sümboli, sisesta uuesti!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Sisestad mittesobiva numbri, sisesta uuesti!");
            }
        }
    }

    private static void fightWithEnemy(Player player, Enemy enemy, Scanner scanner) throws GameOverException {
        Random rand = new Random();
        System.out.println("Võitluse alustamiseks ütle üks number 1-3");
        int enemyFightNumber = rand.nextInt(3);
        String input = scanner.nextLine();
        int playerFightNumber = Integer.parseInt(input);
        if (enemyFightNumber == playerFightNumber) {
            enemy.takeHealth();
        } else {
            player.takeHealth();
            if (player.getHealth() == 0) {
                throw new GameOverException();
            }
        }
    }

    public static void playerAndQuestmasterMet(World world, Player player, Enemy enemy, QuestMaster questMaster) {
        if (player.getxCoord() == questMaster.getxCoord() &&
                player.getyCoord() == questMaster.getyCoord() &&
                questMaster.isVisible()) {
            questMaster.setVisible(false);
            enemy.randomiseCoordinates(world);
            enemy.reboostEnemy();
            enemy.setVisible(true);
        } else if (!questMaster.isVisible() &&
                !(player.getxCoord() == questMaster.getxCoord() && player.getyCoord() == questMaster.getyCoord())) {
            questMaster.setVisible(true);
        }
    }
}
