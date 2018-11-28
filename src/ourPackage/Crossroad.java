package ourPackage;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Crossroad extends Roads {
    public Crossroad(int posX,int posY,int roadSize) {
        setPositionX(posX);
        setPositionY(posY);
        setHeight(roadSize);
        setWidth(roadSize);
        Rectangle road = new Rectangle(roadSize,roadSize, Color.GRAY);
        road.relocate(posX,posY);
    }

}
