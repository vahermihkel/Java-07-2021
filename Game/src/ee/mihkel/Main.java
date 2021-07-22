package ee.mihkel;

import ee.mihkel.character.Enemy;
import ee.mihkel.character.Player;
import ee.mihkel.character.QuestMaster;
import ee.mihkel.item.Dagger;
import ee.mihkel.item.Hammer;
import ee.mihkel.item.Item;
import ee.mihkel.item.Sword;

import java.util.Scanner;

public class Main {

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
        while(!input.equals("end")) {
            player.move(input, world);

            for (Item i:world.getItems()) {
                if (i.getxCoord() == player.getxCoord() && i.getyCoord() == player.getyCoord()) {
                    if (!player.getInventory().contains(i)) {
                        player.addToInventory(i);
                    } else {
                        i.increaseDurability();
                    }
                }
            }

            if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord() && enemy.isVisible()) {
                enemy.setVisible(false);
                System.out.println("Kohtusid vaenlasega!");
                System.out.println("Vali millist relva tahad: ");
                player.showInventory();
                input = scanner.nextLine();
                Item item = player.getFromInventory(Integer.parseInt(input));
                System.out.println(item);
            }
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
            world.printMap();
            input = scanner.nextLine();
        }
    }
}
