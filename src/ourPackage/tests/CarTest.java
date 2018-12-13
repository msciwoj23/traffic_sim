package ourPackage.tests;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import ourPackage.Car;
import ourPackage.Simulation;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import org.junit.Test;
import ourPackage.Utils;
import ourPackage.Light;

import static org.junit.Assert.*;

public class CarTest {

    private final int CAR_WIDTH = 30;
    private final int CAR_LENGTH = 44;
    private final int DIRECTION = 90;
    private final float REGULAR_SPEED = 0.6f;

    private Bounds collisionDetectorBounds(Car car) {
        return car.getCollisionDetector().getBoundsInParent();
    }


    @Test
    public void testCar() {
        Simulation pane = new Simulation();
        Car car = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);

        Circle circleActual = car.getCollisionDetector();
        Circle circleExpected = new Circle(car.getX(), car.getY(), 14, Color.LIGHTYELLOW);

        assertEquals(circleExpected.getCenterX(), circleActual.getCenterX(), 0.01);
        assertEquals(circleExpected.getCenterY(), circleActual.getCenterY(), 0.01);
        assertEquals(circleExpected.getRadius(), circleActual.getRadius(), 0.01);
        assertEquals(circleExpected.getFill(), circleActual.getFill());

        int lastIndex = pane.getChildren().size() - 1;
        int indexBeforeLast = lastIndex - 1;

        Circle circleAddedToPane = (Circle) pane.getChildren().get(lastIndex);
        Car rectangleAddedToPane = (Car) pane.getChildren().get(indexBeforeLast);

        assertEquals(car, rectangleAddedToPane);
        assertEquals(circleActual, circleAddedToPane);

        lastIndex = Simulation.cars.size() - 1;
        Car carAddedToCars = Simulation.cars.get(lastIndex);

        assertEquals(car, carAddedToCars);
    }

    @Test
    public void testPreventCollisionWith() {
        final int TO_WAIT_ON_COLLISION = 60;

        Simulation pane = new Simulation();
        Car car = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);
        Car car2 = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);

        car.preventCollisionWith(car2);
        assertEquals(TO_WAIT_ON_COLLISION, car.getTimeToWait());

        car2.relocate(60,60);
        car2.getCollisionDetector().relocate(60,60);

        car2.preventCollisionWith(car);
        assertEquals(0, car2.getTimeToWait());
    }

    @Test
    public void testMoveCollisionDetector() {
        final int COLLISION_LIGHT_DISTANCE = 40;

        Simulation pane = new Simulation();
        Car car = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);
        car.moveCollisionDetector(DIRECTION);

        Car car2 = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);

        Bounds carBounds = car2.getBoundsInParent();
        double carCenterY = (carBounds.getMinY() + carBounds.getMaxY())/2;
        double carCenterX = (carBounds.getMinX() + carBounds.getMaxX())/2;

        Circle car2collisionDetector = car2.getCollisionDetector();
        Point2D collisionLightHeading = Utils.directionToVector(DIRECTION,
                REGULAR_SPEED + COLLISION_LIGHT_DISTANCE);

        double targetCoordinateX = carCenterX + collisionLightHeading.getX();
        double targetCoordinateY = carCenterY + collisionLightHeading.getY();

        car2collisionDetector.setCenterX(targetCoordinateX);
        car2collisionDetector.setCenterY(targetCoordinateY);

        assertEquals(car2.getCollisionDetector().getBoundsInParent(),
                car.getCollisionDetector().getBoundsInParent());

        Car carSomeplaceElse = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);
        carSomeplaceElse.relocate(90,90);
        carSomeplaceElse.getCollisionDetector().relocate(90,90);

        assertNotEquals(collisionDetectorBounds(carSomeplaceElse),
                collisionDetectorBounds(car));
    }

    @Test
    public void testMoveCar() {

        Simulation pane = new Simulation();
        Car car = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);
        car.moveCar(REGULAR_SPEED, DIRECTION);

        Car car2 = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);

        car2.setRotate(DIRECTION);
        Point2D carHeading = Utils.directionToVector(DIRECTION, REGULAR_SPEED);
        car2.setX(car2.getX() + carHeading.getX());
        car2.setY(car2.getY() + carHeading.getY());

        assertEquals(car2.getBoundsInParent(), car.getBoundsInParent());

        car2.moveCollisionDetector(DIRECTION);

        assertEquals(collisionDetectorBounds(car2),
                collisionDetectorBounds(car));

        Car carSomeplaceElse = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);
        carSomeplaceElse.relocate(90,90);

        assertNotEquals(carSomeplaceElse.getBoundsInParent(), car);
    }

    @Test
    public void testIsAtLights() {

        Simulation pane = new Simulation();
        Car car = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);
        Light mylight = new Light(pane,0,0,0 );
        assertTrue(car.isAtLights());

        car.moveCar(60, 45);

        assertFalse(car.isAtLights());

    }

    @Test
    public void testDirectStraight() {
        final int AMOUNT_WHEN_THROUGH_CROSSROADS = 400;

        Simulation pane = new Simulation();
        Car car = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);

        car.directStraight();
        assertEquals(Utils.WhereTo.THROUGH_CROSSROADS, car.getWhereTo());
        assertEquals(AMOUNT_WHEN_THROUGH_CROSSROADS, car.getGoStraightTime());
    }

    @Test
    public void testDirectToRight() {
        final int AMOUNT_BEFORE_TURNING_RIGHT = 470;

        Simulation pane = new Simulation();
        Car car = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);

        car.directToRight();
        assertEquals(Utils.WhereTo.RIGHT, car.getWhereTo());
        assertEquals(AMOUNT_BEFORE_TURNING_RIGHT, car.getGoStraightTime());
    }

    @Test
    public void directToLeft() {
        final int AMOUNT_BEFORE_TURNING_LEFT = 730;

        Simulation pane = new Simulation();
        Car car = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);

        car.directToLeft();
        assertEquals(Utils.WhereTo.LEFT, car.getWhereTo());
        assertEquals(AMOUNT_BEFORE_TURNING_LEFT, car.getGoStraightTime());
    }

    @Test
    public void towardsNextLights() {
        Simulation pane = new Simulation();
        Car car = new Car(pane, CAR_WIDTH, CAR_LENGTH, DIRECTION);
        Light mylight = new Light(pane, 0, 0, 0);
        Bounds oldCarPosition = car.getBoundsInParent();

        car.setGoStraightTime(0);
        car.towardsNextLights();
        mylight.relocate(40, 30);
        assertNotEquals(oldCarPosition, car.getBoundsInParent());
        assertTrue(car.isAtLights());
    }
}