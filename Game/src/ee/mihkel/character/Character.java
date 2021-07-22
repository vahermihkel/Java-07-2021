package ee.mihkel.character;

import ee.mihkel.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Character {
    protected int xCoord;
    protected int yCoord;
    private final char symbol;
    private boolean isVisible;

    public Character(char symbol, World world) {
        this.symbol = symbol;
        randomiseCoordinates(world);
        this.isVisible = true;
    }

    private void randomiseCoordinates(World world) {
        Random rand = new Random();
        this.xCoord = rand.nextInt(world.getWidth());
        this.yCoord = rand.nextInt(world.getHeight()-2)+1;
        checkCoordinatesUniqueness(world);
    }

    protected void checkCoordinatesUniqueness(World world) {
        List<Character> characters = world.getCharacters();
        List<Character> charactersWithoutThis = characters.stream()
                .filter(c -> c.symbol != this.symbol)
                .collect(Collectors.toList());

//        List<Character> charactersWithoutThis = new ArrayList<>();
//        for (Character c: characters) {
//            if (c.symbol != this.symbol) {
//                charactersWithoutThis.add(c);
//            }
//        }

        for (Character c: charactersWithoutThis) {
            if (c.getxCoord() == this.xCoord && c.yCoord == this.yCoord) {
                randomiseCoordinates(world);
            }
        }
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

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
