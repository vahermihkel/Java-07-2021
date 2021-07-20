package ee.mihkel.character;

import ee.mihkel.World;

public class Player extends Character {
    private Direction direction;

    public Player(World world) {
        super('X', world);
        this.direction = Direction.UP;
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
}
