package ourPackage;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class SimLoop extends AnimationTimer {

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {

        for (Car entity: Simulation.objectsToMove
             ) {

            if (entity.getType().equals("movable")) {

                int unitsToWait = entity.getUntitsToWait();

                if (unitsToWait > 0) {
                    entity.setUntitsToWait(unitsToWait - 1);
                } else {
                    entity.move(entity.getDir());
                }
            }
        }
    }
}
