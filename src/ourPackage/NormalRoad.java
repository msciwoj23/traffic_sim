package ourPackage;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class NormalRoad extends Roads {
    public boolean isVertical() {
        return Vertical;
    }

    public void setVertical(boolean vertical) {
        Vertical = vertical;
    }

    private boolean Vertical;
    public NormalRoad(int posX,int posY,int roadSize, boolean isVertical) throws FileNotFoundException {
    setPositionX(posX);
    setPositionY(posY);
    setHeight(roadSize);
    setWidth(roadSize);
    setSize(roadSize);
    setVertical(isVertical);


    Rectangle road = new Rectangle(roadSize,roadSize);
        Image image = new Image(new FileInputStream("resources/road.png"));
        road.setFill(new ImagePattern(image));
    road.relocate(posX,posY);
    }
}
