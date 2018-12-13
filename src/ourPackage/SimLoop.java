package ourPackage;

import javafx.animation.AnimationTimer;
import java.util.LinkedList;
import java.util.List;

public class SimLoop extends AnimationTimer {

    private List<Car> toRemoveList = new LinkedList<>();

    @Override
    public void handle(long now) {
        removingCarsIfOutOfWindow();
        changeLightAndTime();
        removingCarsFromList();
        toRemoveList.clear();
        timerGeneratroForCars();
        carsGenerator();
    }

    private void changeLightAndTime() {
        for (Light light : Simulation.lights) {
            light.senseTimePassingAndChange();
        }
    }

    private void removingCarsFromList() {
        for (Car car : toRemoveList) {
            car.pane.getChildren().removeAll(car.getCollisionDetector(), car);
            Simulation.cars.remove(car);
        }
    }

    private void timerGeneratroForCars() {
        for (CarGeneratorField carGenerator : Simulation.getAllCarGenerators()) {
            carGenerator.timer();
        }
    }

    private void carsGenerator() {
        if (Simulation.cars.size() < 12) {
            int dice = (int) (Math.random() * Simulation.getAllCarGenerators().size());
            Simulation.getAllCarGenerators().get(dice).tryToGenerateCar();
        }
    }

    private void removingCarsIfOutOfWindow() {
        final int UP_AND_LEFTMOST_PIXEL = -200;
        final int LOWEST_PIXEL = Main.getBoardHeight() + 100;
        final int RIGHTMOST_PIXEL = Main.getBoardWidth() + 100;

        for (Car car : Simulation.cars) {
            car.continueAppropriateMovement();
            if (car.getLayoutBounds().getMaxY() <= UP_AND_LEFTMOST_PIXEL) {
                toRemoveList.add(car);
            } else if (car.getLayoutBounds().getMinY() >= LOWEST_PIXEL) {
                toRemoveList.add(car);
            } else if (car.getLayoutBounds().getMaxX() <= UP_AND_LEFTMOST_PIXEL) {
                toRemoveList.add(car);
            } else if (car.getLayoutBounds().getMinX() >= RIGHTMOST_PIXEL) {
                toRemoveList.add(car);
            }
        }
    }
}
