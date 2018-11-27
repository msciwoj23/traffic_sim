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

    private String whatToDo = "go";

    private float speed = 0.6f;
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

    private void checkIfIntersectsAndWaitIfYes( Car car ) {
        if (car != this) {
            if (collisionDetector.intersects(car.getBoundsInLocal())) {
                whatToDo = "wait";
            }
        }
    }

    private void moveCarAndCollisionField() {
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
        this.collisionDetector.relocate(getX() - 5, getY() - 40);
    }


    public void move(double dir) {

        if (this.whereToAtNextCrossroads.equals("right")) {

            if (dir == 90) {
                this.whereToAtNextCrossroads = "straight";
            } else if (this.unitsToGoStraight > 0) {
                this.unitsToGoStraight--;
            } else {
                this.dir = (int) dir + 1;
            }
        }

        // Point2D collisionPoint = Utils.directionToVector(dir, 20);
        whatToDo = "go";
        for (Car car : Simulation.cars) {
            checkIfIntersectsAndWaitIfYes(car);
        }

        for (Light light : Simulation.stopLights) {
            if (collisionDetector.getBoundsInParent().intersects(light.getBoundsInParent()) && light.getFill() != Color.GREEN) {
                whatToDo = "wait";
            }
        }

        if (whatToDo.equals("go")) {
            moveCarAndCollisionField();
        }
    }


    public int getDir() {
        return dir;
    }

    public String getWhatToDo() { return whatToDo; }

    public int getUntitsToWait() {
        return untitsToWait;
    }

    public void setUntitsToWait(int untitsToWait) {
        this.untitsToWait = untitsToWait;
    }
}
