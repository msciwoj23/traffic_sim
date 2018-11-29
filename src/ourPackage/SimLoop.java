package ourPackage;

import javafx.animation.AnimationTimer;

import java.util.LinkedList;
import java.util.List;

public class SimLoop extends AnimationTimer {

    private List<Car> toRemoveList = new LinkedList<>();

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {
//        System.out.println(now/10000000);

        final int UP_AND_LEFTMOST_PIXEL = -200;
        final int LOWEST_PIXEL = Main.getBoardheight() + 100;
        final int RIGHTMOST_PIXEL = Main.getBoardwidth() + 100;

        for (Car car : Simulation.cars) {

            car.continueAppropriateMovement();

            if (car.getLayoutBounds().getMaxY() <= UP_AND_LEFTMOST_PIXEL) {
                System.out.println("out");
                toRemoveList.add(car);
            } else if (car.getLayoutBounds().getMinY() >= LOWEST_PIXEL) {
                System.out.println("out");
                toRemoveList.add(car);
            } else if (car.getLayoutBounds().getMaxX() <= UP_AND_LEFTMOST_PIXEL) {
                System.out.println("out");
                toRemoveList.add(car);
            } else if (car.getLayoutBounds().getMinX() >= RIGHTMOST_PIXEL) {
                System.out.println("out");
                toRemoveList.add(car);
                System.out.println(toRemoveList.size());
            }
        }

        for (Light light : Simulation.lights) {
            light.senseTimePassingAndChange();
        }

        for (Car car : toRemoveList) {
            System.out.println("removing");
            car.pane.getChildren().removeAll(car.getCollisionDetector(), car);
            Simulation.cars.remove(car);
        }

        toRemoveList.clear();

        for (CarGeneratorField carGenerator : Simulation.getAllCarGenerators()) {
            carGenerator.timer();
        }
        if (Simulation.cars.size() < 12) {
            int dice = (int) (Math.random()*Simulation.getAllCarGenerators().size());
            System.out.println(dice);
            Simulation.getAllCarGenerators().get(dice).tryToGenerateCar();
        }
    }
}
