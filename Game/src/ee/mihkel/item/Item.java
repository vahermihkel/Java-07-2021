package ee.mihkel.item;

import ee.mihkel.World;
import ee.mihkel.character.Enemy;
import ee.mihkel.character.Player;

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

    public int getStrength() {
        return strength;
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

    public void decreaseDurability(Player player) {
        if (durability == 1) {
            player.deleteFromInventory(this);
        } else {
            this.durability--;
        }
    }

    public int getDurability() {
        return durability;
    }

    public void hit(Enemy enemy) {
        itemType = increaseLevel();
        strength = getStrengthByItemType();
        enemy.loseHealth(strength);
    }

    public int getLevel() {
        return level;
    }

    public ItemType getItemType() {
        return itemType;
    }

    private ItemType increaseLevel() {
        this.level++;
        switch (this.level/3) {
            case 0:
                return ItemType.BRONZE;
            case 1:
                return ItemType.SILVER;
            case 2:
                return ItemType.GOLD;
            case 3:
                return ItemType.PLATINUM;
            default:
                return ItemType.BRONZE;
        }
    }

    private int getStrengthByItemType() {
        switch (this.itemType) {
            case SILVER:
                return (int) (this.strength*1.5);
            case GOLD:
                return this.strength*2;
            case PLATINUM:
                return this.strength*3;
            default:
                return this.strength;
        }
    }
}
