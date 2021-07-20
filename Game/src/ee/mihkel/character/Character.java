package ee.mihkel.character;

import ee.mihkel.World;

import java.util.Random;

public abstract class Character {
    protected int xCoord;
    protected int yCoord;
    protected char symbol;

    public Character(char symbol, World world) {
        this.symbol = symbol;
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
}
