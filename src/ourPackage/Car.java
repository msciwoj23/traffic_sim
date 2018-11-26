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

    private Circle oldCollisionCircle;

    private int untitsToWait = 0;

    private int unitsToGoStraight = 0;

    private String whereToAtNextCrossroads = "straight";

    private String type;
    private float speed = 0.2f;
    private int dir = 0;


    public Car(Pane pane, int xc, int yc, String type) {

        super(xc,yc, Color.GREEN);

        this.type = type;
        this.pane = pane;

//        Point2D collisionPoint = Utils.directionToVector(dir, 20);
//        this.collisionCircle = new Circle(
//                getX() + collisionPoint.getX(),
//                getY() + collisionPoint.getY(),
//                20,
//                Color.YELLOW);


        pane.getChildren().addAll(this);
        Simulation.objectsToMove.add(this);
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


        BoundingBox collisionCourse = new BoundingBox(this.getBoundsInLocal().getMinX(),
                this.getBoundsInLocal().getMinY() - 20,
                this.getBoundsInLocal().getWidth(),
        this.getBoundsInLocal().getHeight());



        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());

        Point2D collisionPoint = Utils.directionToVector(dir, 20);
        Circle collisionCircle = new Circle(
                getX() + collisionPoint.getX(),
                getY() + collisionPoint.getY(),
                20,
                Color.YELLOW);
        
        pane.getChildren().remove(this.oldCollisionCircle);
        pane.getChildren().add(collisionCircle);
        this.oldCollisionCircle = collisionCircle;

//        for (Entity entity : Globals.objectsToMove) {
//
//            if (entity != this) {
//                if (collisionCourse.intersects(entity.getBoundsInLocal())) {
//
//                    this.untitsToWait = 120;
//                    Globals.objectsToMove.remove(entity);
//                    pane.getChildren().remove(entity);
//                    this.turningRight = true;
//                    this.unitsToGoStraight = 200;
//                }
//            }
//        }
    }


    public int getDir() {
        return dir;
    }

    public String getType() {
        return type;
    }

    public int getUntitsToWait() {
        return untitsToWait;
    }

    public void setUntitsToWait(int untitsToWait) {
        this.untitsToWait = untitsToWait;
    }
}
