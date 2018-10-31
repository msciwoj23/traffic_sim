package ourPackage;

import javafx.animation.AnimationTimer;

public class SimLoop extends AnimationTimer {

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {

        for (Entity entity: Globals.gameObjects
             ) {

            if (entity.getType().equals("movable")) {
                entity.move(entity.getDir());
            }
        }
    }
}
