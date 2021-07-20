package ee.mihkel;

import ee.mihkel.character.Character;
//import java.lang.Character;

import java.util.ArrayList;
import java.util.List;

public class World {
    private int height;
    private int width;
    // null --- ei saa nullile juurde lisada, isegi kui tüüp on list
    // new ArrayList -- [] - siis saab juurde lisada .add() abil
    private List<Character> characters = new ArrayList<>();

    public World(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void addCharacter(Character character) {
        this.characters.add(character);
    }

    public void printMap() {
        char symbol = ' ';
        for (int y = 0; y < height; y++) {
            System.out.print("|");
            for (int x = 0; x < width; x++) {
                if (y == 0 || y == height-1) {
                    symbol = '-';
                } else {
                    symbol = ' ';
                }

                for (Character c:characters) {
                    if (c.getxCoord() == x && c.getyCoord() == y) {
                        symbol = c.getSymbol();
                    }
                }

                System.out.print(symbol);
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
