package ourPackage;

import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

public class Entity extends ImageView {

    protected Pane pane;

    private int untitsToWait = 0;

    private boolean wannaTurnLeft = false;

    private String type;
    private float speed = 0.1f;
    private int dir = 0;



    public Image entityImage = new Image("Door.png");

    public Entity(Pane pane, int xc, int yc, String type) {
        this.type = type;
        this.pane = pane;
        setX(xc);
        setY(yc);
        setImage(entityImage);
        pane.getChildren().add(this);
        Globals.gameObjects.add(this);
    }

    public void move(double dir) {

//        BoundingBox box = this.getBoundsInLocal();

//        box.getMinZ();
//        box.getMinY();
//        box.getWidth();
//        box.getHeight() + 80;
        BoundingBox collisionCourse = new BoundingBox(this.getBoundsInLocal().getMinX(),
                this.getBoundsInLocal().getMinY() - 20,
                this.getBoundsInLocal().getWidth(),
        this.getBoundsInLocal().getHeight());



        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());



        // System.out.println(collisionCourse);
        for (Entity entity : Globals.gameObjects) {

            if (entity != this) {
                if (collisionCourse.intersects(entity.getBoundsInLocal())) {
                    // pane.getChildren().remove(this);
                    this.untitsToWait = 120;
                    Globals.gameObjects.remove(entity);
                    pane.getChildren().remove(entity);
                }
            }
        }
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
