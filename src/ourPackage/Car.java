package ourPackage;

import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class Car extends Rectangle {

    protected Pane pane;

    private int untitsToWait = 0;

    private int unitsToGoStraight = 0;

    private String whereToAtNextCrossroads = "straight";

    // private String whatToDo = "go";


    public enum WhereTo {
        THROUGH_CROSSROADS, LEFT, RIGHT, TO_NEXT_LIGHTS
    }

    private WhereTo whereTo = WhereTo.TO_NEXT_LIGHTS;


    private float speed = 0.2f;
    private int dir = 0;

    private Circle collisionDetector;


    Car(Pane pane, int xc, int yc) {

        super(xc,yc, Color.GREEN);

        this.pane = pane;

        Circle collisionCircle = new Circle(
                getX() + 15,
                getY() - 20,
                20,
                Color.LIGHTYELLOW);

        this.collisionDetector = collisionCircle;

        pane.getChildren().addAll(this, collisionCircle);
        collisionCircle.toFront();
        Simulation.cars.add(this);
    }

    private void preventCollisionWith( Car car ) {
        if (car != this) {
            if (collisionDetector.intersects(car.getBoundsInLocal())) {
                System.out.println("prevented collision with car");
                untitsToWait = 60;
            }
        }
    }

    private void moveCar() {
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());

        Point2D collisionHeading = Utils.directionToVector(dir, speed + 40);
        collisionDetector.relocate(getX() + collisionHeading.getX(), getY() + collisionHeading.getY());

        System.out.println("moving car and collision detector");
    }

    private boolean isAtLights() {
        for (Light light : Simulation.stopLights) {
            if (collisionDetector.getBoundsInParent().intersects(light.getBoundsInParent())) {
                System.out.println("intersecting light");
                untitsToWait = light.getTimeToNextGreen();
                System.out.println(untitsToWait);
                return true;
            }
        }
        return false;
    }

    private void choosePath() {
        // here should check if there are places free

        // or randomly choose path
//        whereTo = WhereTo.THROUGH_CROSSROADS;
//        System.out.println("changed to THROUGH CROSSROADS");
//        unitsToGoStraight = 720;

//        whereTo = WhereTo.RIGHT;
//        System.out.println("changed to RIGHT");
//        unitsToGoStraight = 520;

        whereTo = WhereTo.LEFT;
        System.out.println("changed to LEFT");
        unitsToGoStraight = 800;

    }

    private void moveTowardsNextLightsAndDetectCars() {
        moveCar();
        for (Car car : Simulation.cars) {

            preventCollisionWith(car);
        }
        if (isAtLights()) {
            choosePath();
        }
    }

    private void goThrough() {
        if (unitsToGoStraight == 0) {
            whereTo = WhereTo.TO_NEXT_LIGHTS;
            System.out.println("changed to TO NEXT LIGHTS");
        } else {
            System.out.println("going through");
            moveCar();
            unitsToGoStraight--;
        }
    }

    private void turnRight() {
        if (unitsToGoStraight > 0) {
            moveCar();
            unitsToGoStraight--;

        } else if (dir == 90) {
            whereTo = WhereTo.TO_NEXT_LIGHTS;
            System.out.println("changed to TO NEXT LIGHTS");
        } else {
            System.out.println("moving right");
            moveCar();
            dir++;
        }
    }

    private void turnLeft() {
        if (unitsToGoStraight > 0) {
            moveCar();
            unitsToGoStraight--;

        } else if (dir == 270) {
            whereTo = WhereTo.TO_NEXT_LIGHTS;
            System.out.println("changed to TO NEXT LIGHTS");
        } else {
            System.out.println("moving left");
            moveCar();
            dir--;
            if (dir == -1) {
                dir = 359;
            }
        }
    }

    void continueAppropriateMovementAndDetection() {

        if (untitsToWait > 0) {
            untitsToWait--;

        } else {
            switch (whereTo) {

                case TO_NEXT_LIGHTS:
                    moveTowardsNextLightsAndDetectCars();
                    break;

                case RIGHT:
                    turnRight();
                    break;

                case THROUGH_CROSSROADS:
                    goThrough();
                    break;

                case LEFT:
                    turnLeft();
                    break;
            }


        }

//        if (this.whereToAtNextCrossroads.equals("right")) {
//
//            if (dir == 90) {
//                this.whereToAtNextCrossroads = "straight";
//            } else if (this.unitsToGoStraight > 0) {
//                this.unitsToGoStraight--;
//            } else {
//                this.dir = (int) dir + 1;
//            }
//        }

        // Point2D collisionPoint = Utils.directionToVector(dir, 20);

    }


    public int getDir() {
        return dir;
    }

    public int getUntitsToWait() {
        return untitsToWait;
    }

    public void setUntitsToWait(int untitsToWait) {
        this.untitsToWait = untitsToWait;
    }

    public Circle getCollisionDetector() {
        return collisionDetector;
    }
}
