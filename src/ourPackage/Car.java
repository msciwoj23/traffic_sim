package ourPackage;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Car extends Rectangle {

    private final int QUARTER_CIRCLE = 90;
    private final float REGULAR_SPEED = 0.6f;
    private final float SPEED_TO_TURN = 0.2f;


    Pane pane;


    private int timeToWait,
                goStraightTime = 0;

    private int currentDirection,
                directionWanted;

    private Utils.WhereTo whereTo = Utils.WhereTo.TO_NEXT_LIGHTS;
    private Circle collisionDetector;

    public Car(Pane pane, int xc, int yc, int dir) {
        super(xc,yc, Color.GREEN);
        int COLLISION_CIRCLE_RADIUS = 14;

        this.currentDirection = dir;
        this.pane = pane;

        Circle collisionCircle = new Circle(
                getX(),
                getY(),
                COLLISION_CIRCLE_RADIUS,
                Color.LIGHTYELLOW);

        this.collisionDetector = collisionCircle;

        pane.getChildren().addAll(this, collisionCircle);
        collisionCircle.toFront();
        Simulation.cars.add(this);
    }

    public void preventCollisionWith( Car car ) {
        final int TO_WAIT_ON_COLLISION = 60;
        if (car != this && collisionDetector.getBoundsInParent().intersects(car.getBoundsInParent())) {
            timeToWait = TO_WAIT_ON_COLLISION;
        }
    }

    public void moveCollisionDetector(int directionInDegrees) {
        final int COLLISION_LIGHT_DISTANCE = 40;

        Bounds carBounds = this.getBoundsInParent();
        double carCenterY = (carBounds.getMinY() + carBounds.getMaxY())/2;
        double carCenterX = (carBounds.getMinX() + carBounds.getMaxX())/2;

        Point2D collisionLightHeading = Utils.directionToVector(directionInDegrees,
                REGULAR_SPEED + COLLISION_LIGHT_DISTANCE);
        collisionDetector.setCenterX(carCenterX + collisionLightHeading.getX());
        collisionDetector.setCenterY(carCenterY + collisionLightHeading.getY());
    }

    public void moveCar(float varyingSpeed, int directionInDegrees) {

        setRotate(directionInDegrees);
        Point2D carHeading = Utils.directionToVector(directionInDegrees, varyingSpeed);
        setX(getX() + carHeading.getX());
        setY(getY() + carHeading.getY());

        moveCollisionDetector(directionInDegrees);

    }

    public boolean isAtLights() {
        for (Light light : Simulation.stopLights) {
            if (collisionDetector.getBoundsInParent().intersects(light.getBoundsInParent())) {
                timeToWait = light.getTimeToNextGreen();
                return true;
            }
        }
        return false;
    }

    public void directStraight() {
        final int AMOUNT_WHEN_THROUGH_CROSSROADS = 400;

        whereTo = Utils.WhereTo.THROUGH_CROSSROADS;
        goStraightTime = AMOUNT_WHEN_THROUGH_CROSSROADS;
    }

    public void directToRight() {
        final int AMOUNT_BEFORE_TURNING_RIGHT = 470;
        final int DEGREES_OVER_SCALE = 470;
        final int EAST_IN_DEGREES = 90;

        whereTo = Utils.WhereTo.RIGHT;
        goStraightTime = AMOUNT_BEFORE_TURNING_RIGHT;
        directionWanted = currentDirection + QUARTER_CIRCLE;

        if (directionWanted == DEGREES_OVER_SCALE) {
            directionWanted = EAST_IN_DEGREES;
        }
    }

    public void directToLeft() {
        final int AMOUNT_BEFORE_TURNING_LEFT = 730;
        final int DEGREES_UNDER_SCALE = -90;
        final int WEST_IN_DEGREES = 270;

        whereTo = Utils.WhereTo.LEFT;
        goStraightTime = AMOUNT_BEFORE_TURNING_LEFT;
        directionWanted = currentDirection - QUARTER_CIRCLE;

        if (directionWanted == DEGREES_UNDER_SCALE) {
            directionWanted = WEST_IN_DEGREES;
        }
    }

    private void choosePath() {
        int randomNumber = (int) (Math.random()*3);
        if (randomNumber == 0) {
            directStraight();
        } else if (randomNumber == 1) {
            directToRight();
        } else if (randomNumber == 2) {
            directToLeft();
        }
    }

    public void towardsNextLights() {
        moveCar(REGULAR_SPEED, currentDirection);

        if (goStraightTime > 0) {
            goStraightTime--;
        } else {
            if (isAtLights()) {
                choosePath();
            }
        }
    }

    private void goThrough() {
        final float SPEED_WHILE_GOING_THROUGH = 0.4f;

        if (goStraightTime == 0) {
            whereTo = Utils.WhereTo.TO_NEXT_LIGHTS;
        } else {
            moveCar(SPEED_WHILE_GOING_THROUGH, currentDirection);
            goStraightTime--;
        }
    }

    private void turnRight() {
        if (goStraightTime > 0) {
            moveCar(SPEED_TO_TURN, currentDirection);
            goStraightTime--;

        } else if (currentDirection == directionWanted) {
            whereTo = Utils.WhereTo.TO_NEXT_LIGHTS;
        } else {
            moveCar(SPEED_TO_TURN, currentDirection);
            currentDirection++;
        }
    }

    private void turnLeft() {
        final int AMOUNT_AFTER_TURNING_LEFT = 100;

        if (goStraightTime > 0) {
            moveCar(SPEED_TO_TURN, currentDirection);
            goStraightTime--;

        } else if (currentDirection == directionWanted) {

            whereTo = Utils.WhereTo.TO_NEXT_LIGHTS;
            goStraightTime = AMOUNT_AFTER_TURNING_LEFT;
        } else {
            moveCar(SPEED_TO_TURN, currentDirection);
            currentDirection--;
            if (currentDirection == -1) {
                currentDirection = 359;
            }
        }
    }

    void continueAppropriateMovement() {

        if (timeToWait > 0) {
            timeToWait--;
        } else {
            for (Car car : Simulation.cars) {

                preventCollisionWith(car);
            }
            switch (whereTo) {

                case TO_NEXT_LIGHTS:
                    towardsNextLights();
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
    }

    public Circle getCollisionDetector() {
        return collisionDetector;
    }

    public int getTimeToWait() {
        return timeToWait;
    }

    public int getGoStraightTime() {
        return goStraightTime;
    }

    public void setGoStraightTime(int goStraightTime) {
        this.goStraightTime = goStraightTime;
    }

    public Utils.WhereTo getWhereTo() {
        return whereTo;
    }
}
