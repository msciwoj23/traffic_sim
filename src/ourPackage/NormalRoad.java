package ourPackage;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class NormalRoad extends Roads {
    public NormalRoad(int posX,int posY,int roadSize) {
    setPositionX(posX);
    setPositionY(posY);
    setHeight(roadSize);
    setWidth(roadSize);
    setSize(roadSize);
    Rectangle road = new Rectangle(roadSize,roadSize, Color.GRAY);
    road.relocate(posX,posY);
    }
}
