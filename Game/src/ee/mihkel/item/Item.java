package ee.mihkel.item;

import ee.mihkel.World;

import java.util.Random;

public class Item {
    private int strength;
    private int durability;
    private int level;
    private ItemType itemType;
    private int xCoord;
    private int yCoord;
    private char symbol;

    public Item(int strength, int durability, World world) {
        this.strength = strength;
        this.durability = durability;
        this.level = 0;
        this.itemType = ItemType.BRONZE;
        randomiseCoordinates(world);
        this.symbol = 'I';
    }

    private void randomiseCoordinates(World world) {
        Random rand = new Random();
        this.xCoord = rand.nextInt(world.getWidth());
        this.yCoord = rand.nextInt(world.getHeight()-2)+1;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public char getSymbol() {
        return symbol;
    }

    public void increaseDurability() {
        this.durability++;
    }

    @Override
    public String toString() {
        return "Item{" +
                "strength=" + strength +
                ", durability=" + durability +
                ", level=" + level +
                ", itemType=" + itemType +
                ", xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", symbol=" + symbol +
                '}';
    }
}
