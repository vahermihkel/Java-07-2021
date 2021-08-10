package ee.mihkel.character;

import ee.mihkel.World;

public class Healer extends Character {
    public Healer(World world) {
        super(' ', world);
    }

    public void reboostPlayer(Player player) {
        player.reboost();
    }
}
