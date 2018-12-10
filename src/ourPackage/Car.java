package ourPackage;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Car extends Rectangle {

    protected Pane pane;

    private int unitsToWait = 0;

    private int unitsToGoStraight = 0;

    public enum WhereTo {
        THROUGH_CROSSROADS, LEFT, RIGHT, TO_NEXT_LIGHTS
    }

    private WhereTo whereTo = WhereTo.TO_NEXT_LIGHTS;

    private float speed = 0.7f;
    private float speedToTurn = 0.7f;
    private int currentDirection;

    private int directionWanted;

    public void setDir(int dir) {
        this.currentDirection = dir;
    }

    private Circle collisionDetector;


    Car(Pane pane, int xc, int yc, int dir) {

        super(xc,yc, Color.GREEN);

        this.currentDirection = dir;
        this.pane = pane;

        Circle collisionCircle = new Circle(
                getX(),
                getY(),
                14,
                Color.LIGHTYELLOW);

        this.collisionDetector = collisionCircle;

        pane.getChildren().addAll(this, collisionCircle);
        collisionCircle.toFront();
        Simulation.cars.add(this);
    }

    private void preventCollisionWith( Car car ) {
        if (car != this) {
            if (collisionDetector.getBoundsInParent().intersects(car.getBoundsInParent())) {
                // System.out.println("prevented collision with car");
                unitsToWait = 60;
            }
        }
    }

    private void moveCar(float varyingSpeed, int dir) {
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, varyingSpeed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());


        Bounds carBounds = this.getBoundsInParent();

        double centreY = (carBounds.getMinY() + carBounds.getMaxY())/2;
        double centreX = (carBounds.getMinX() + carBounds.getMaxX())/2;

        Point2D collisionHeading = Utils.directionToVector(dir, speed + 40);
        // collisionDetector.relocate(getX() + collisionHeading.getX(), getY() + collisionHeading.getY());
        collisionDetector.setCenterX(centreX + collisionHeading.getX());
        collisionDetector.setCenterY(centreY + collisionHeading.getY());
        // System.out.println("moving car and collision detector");
    }

    private boolean isAtLights() {
        for (Light light : Simulation.stopLights) {
            if (collisionDetector.getBoundsInParent().intersects(light.getBoundsInParent())) {
//                System.out.println("intersecting light");
                unitsToWait = light.getTimeToNextGreen();
//                System.out.println(unitsToWait);
                return true;
            }
        }
        return false;
    }

    private void choosePath() {
        // here should check if there are places free
        int dice = (int) (Math.random()*3);
        // or randomly choose path

        if (dice == 0) {
            whereTo = WhereTo.THROUGH_CROSSROADS;
            unitsToGoStraight = 400;
        } else if (dice == 1) {
            whereTo = WhereTo.RIGHT;
            unitsToGoStraight = 470;
            directionWanted = currentDirection + 90;
            if (directionWanted == 470) {
                directionWanted = 90;
            }
        } else if (dice == 2) {
            whereTo = WhereTo.LEFT;
            unitsToGoStraight = 730;
            directionWanted = currentDirection - 90;
            if (directionWanted == -90) {
                directionWanted = 270;
            }
        }
    }

    private void moveTowardsNextLightsAndDetectCars() {
        moveCar(speed, currentDirection);

        if (unitsToGoStraight > 0) {
            unitsToGoStraight--;
        } else {
            if (isAtLights()) {
                choosePath();
            }
        }
    }

    private void goThrough() {
        if (unitsToGoStraight == 0) {
            whereTo = WhereTo.TO_NEXT_LIGHTS;
            // System.out.println("changed to TO NEXT LIGHTS");
        } else {
            // System.out.println("going through");
            moveCar(0.4f, currentDirection);
            unitsToGoStraight--;
        }
    }

    private void turnRight() {
        if (unitsToGoStraight > 0) {
            moveCar(speedToTurn, currentDirection);
            unitsToGoStraight--;

        } else if (currentDirection == directionWanted) {
            whereTo = WhereTo.TO_NEXT_LIGHTS;
            // System.out.println("changed to TO NEXT LIGHTS");
        } else {
            // System.out.println("moving right");
            moveCar(speedToTurn, currentDirection);
            currentDirection++;
        }
    }

    private void turnLeft() {
        if (unitsToGoStraight > 0) {
            moveCar(speedToTurn, currentDirection);
            unitsToGoStraight--;

        } else if (currentDirection == directionWanted) {

            whereTo = WhereTo.TO_NEXT_LIGHTS;
            // System.out.println("changed to TO NEXT LIGHTS");
            unitsToGoStraight = 100;
        } else {
            //System.out.println("moving left");
            moveCar(speedToTurn, currentDirection);
            currentDirection--;
            if (currentDirection == -1) {
                currentDirection = 359;
            }
        }
    }

    void continueAppropriateMovement() {

        if (unitsToWait > 0) {
            unitsToWait--;
        } else {
            for (Car car : Simulation.cars) {

                preventCollisionWith(car);
            }
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
//            if (currentDirection == 90) {
//                this.whereToAtNextCrossroads = "straight";
//            } else if (this.unitsToGoStraight > 0) {
//                this.unitsToGoStraight--;
//            } else {
//                this.currentDirection = (int) currentDirection + 1;
//            }
//        }

        // Point2D collisionPoint = Utils.directionToVector(currentDirection, 20);

    }


    public int getCurrentDirection() {
        return currentDirection;
    }

    public int getUnitsToWait() {
        return unitsToWait;
    }

    public void setUnitsToWait(int unitsToWait) {
        this.unitsToWait = unitsToWait;
    }

    public Circle getCollisionDetector() {
        return collisionDetector;
    }
}
