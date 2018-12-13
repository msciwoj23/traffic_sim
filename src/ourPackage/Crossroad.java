package ourPackage;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Crossroad extends Roads {
    public Crossroad(int posX,int posY,int roadSize) throws FileNotFoundException {
        setPositionX(posX);
        setPositionY(posY);
        setHeight(roadSize);
        setWidth(roadSize);
        Rectangle road = new Rectangle(roadSize,roadSize);

        road.relocate(posX,posY);
    }

}
