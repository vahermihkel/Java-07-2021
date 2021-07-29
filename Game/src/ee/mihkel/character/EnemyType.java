package ee.mihkel.character;

import java.util.Random;

public enum EnemyType {
    RAT, CAT, DOG, GOBLIN, ORC, DRAGON, WIZARD;

    public static EnemyType getRandomEnemyType() {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)];
    }
}
