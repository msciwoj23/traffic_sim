package ourPackage;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class SimLoop extends AnimationTimer {

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {

        for (Car entity: Simulation.cars
             ) {
                entity.continueAppropriateMovement();

            if (0 > entity.getLayoutBounds().getMaxY()) {
                entity.pane.getChildren().removeAll(entity.getCollisionDetector(), entity);
                Simulation.cars.remove(entity);
            }
        }

        for (Light light: Simulation.lights) {
            light.senseTimePassingAndChange();
        }
    }
}
