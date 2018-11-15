package sample.model.Vehicles;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Movable extends ImageView {

    protected Pane pane;

    protected Movable(Pane pane) {
        this.pane = pane;
//        // add to the main loop.
//        Globals.addGameObject(this);
    }

    public void destroy() {
        if (getParent() != null) {
            pane.getChildren().remove(this);
        }
//        Globals.removeGameObject(this);
    }

    protected boolean isOutOfBounds() {
//        if (getX() > Globals.WINDOW_WIDTH || getX() < 0 ||
//                getY() > Globals.WINDOW_HEIGHT || getY() < 0) {
//            return true;
//        }
        return false;
    }
}