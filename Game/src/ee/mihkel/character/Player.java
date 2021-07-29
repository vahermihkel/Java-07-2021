package ee.mihkel.character;

import ee.mihkel.World;
import ee.mihkel.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends Character {
    private Direction direction;
    private List<Item> inventory = new ArrayList();
    private Map<EnemyType, Integer> killedEnemies = new HashMap<>();

    public Player(World world) {
        super('X', world);
        this.direction = Direction.UP;
    }

    public void showKilledEnemies() {
        if (!this.killedEnemies.isEmpty()) {
            System.out.println("Tapetud vaenlasi:");
        } else {
            System.out.println("Ühtegi vaenlast sa ei tapnud!");
        }
        this.killedEnemies.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public void addToKilledEnemies(EnemyType enemyType) {
        if (killedEnemies.containsKey(enemyType)) {
            this.killedEnemies.put(enemyType,killedEnemies.get(enemyType)+1);
        } else {
            this.killedEnemies.put(enemyType,1);
        }
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addToInventory(Item item) {
        this.inventory.add(item);
    }

    public void move(String input, World world) {
        switch (input) {
            case "a":
                direction = Direction.LEFT;
                break;
            case "s":
                direction = Direction.DOWN;
                break;
            case "d":
                direction = Direction.RIGHT;
                break;
            case "w":
                direction = Direction.UP;
                break;
        }

        switch (direction) {
            case LEFT:
                if (xCoord > 0) {
                    xCoord--;
                }
                break;
            case DOWN:
                if (yCoord < world.getHeight()-2) {
                    yCoord++;
                }
                break;
            case RIGHT:
                if (xCoord < world.getWidth()-1) {
                    xCoord++;
                }
                break;
            case UP:
                if (yCoord > 1) {
                    yCoord--;
                }
                break;
        }

//        if (input.equals("a")) {
//            xCoord--;
//        } else if (input.equals("s")) {
//            yCoord++;
//        } else if (input.equals("d")) {
//            xCoord++;
//        } else if (input.equals("w")) {
//            yCoord--;
//        }
    }

    public boolean isInventoryEmpty() {
        return this.inventory.isEmpty();
    }

    public void showInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i+1 + ". " + inventory.get(i).getClass().getName().substring(15) +
            ", kasutuskordi alles: " + inventory.get(i).getDurability());
        }
    }

    public Item getFromInventory(int itemIndex) {
        return inventory.get(itemIndex-1);
    }

    public void deleteFromInventory(Item item) {
        this.inventory.remove(item);
    }
}
