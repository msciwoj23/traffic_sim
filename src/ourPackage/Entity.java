package ourPackage;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

public class Entity extends ImageView {

    protected Pane pane;

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
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());


        for (Entity entity : Globals.gameObjects) {

            if (entity != this) {
                if (this.getBoundsInLocal().intersects(entity.getBoundsInLocal())) {
                    // pane.getChildren().remove(this);
                    this.speed = 0;
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
}
