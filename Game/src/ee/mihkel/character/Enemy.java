package ee.mihkel.character;

import ee.mihkel.World;

import java.util.Random;

public class Enemy extends Character {
    public Enemy(World world) {
        super('Z', world);
    }

    public void randomiseCoordinates(World world) {
        Random rand = new Random();
        this.xCoord = rand.nextInt(world.getWidth());
        this.yCoord = rand.nextInt(world.getHeight()-2)+1;
        checkCoordinatesUniqueness(world);
    }
}
