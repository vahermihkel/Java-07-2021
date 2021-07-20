package ee.mihkel;

import ee.mihkel.character.Enemy;
import ee.mihkel.character.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    World world = new World(5,10);

	    Player player = new Player(world);
	    world.addCharacter(player);

        Enemy enemy = new Enemy(world);
        world.addCharacter(enemy);

        world.printMap();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.equals("end")) {
            player.move(input, world);
            world.printMap();
            input = scanner.nextLine();
        }
    }
}
