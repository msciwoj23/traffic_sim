package ourPackage;

import javafx.animation.AnimationTimer;

public class SimLoop extends AnimationTimer {

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {

        for (Entity entity: Globals.gameObjects
             ) {

            if (entity.getType().equals("movable")) {

                int unitsToWait = entity.getUntitsToWait();
                if (unitsToWait > 0) {
                    System.out.println(unitsToWait);
                    entity.setUntitsToWait(unitsToWait - 1);
                } else {
                    System.out.println(unitsToWait);
                    entity.move(entity.getDir());
                }
            }
        }
    }
}
