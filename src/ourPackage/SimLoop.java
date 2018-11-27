package ourPackage;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class SimLoop extends AnimationTimer {

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {

        for (Car entity: Simulation.cars
             ) {

            int unitsToWait = entity.getUntitsToWait();

            if (unitsToWait > 0) {
                entity.setUntitsToWait(unitsToWait - 1);

            } else {
                if (0 > entity.getLayoutBounds().getMaxY()) {
                    entity.pane.getChildren().remove(entity);
                    Simulation.cars.remove(entity);
                }
                entity.move(entity.getDir());
            }
        }

        for (Light light: Simulation.lights) {
            light.senseTimePassingAndChange();
        }
    }
}
