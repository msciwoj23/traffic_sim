package ourPackage;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class RoadsPrinter {
    public void printRoads(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane) throws FileNotFoundException {

        for (NormalRoad road:allRoads) {
            Rectangle roadRepresentation = new Rectangle(road.getWidth(),road.getHeight());
            Image image = new Image(new FileInputStream("resources/road.png"));
            roadRepresentation.setFill(new ImagePattern(image));

            if (road.isVertical()){

            }else{roadRepresentation.setRotate(90);
            }

            roadRepresentation.relocate(road.getPositionX(),road.getPositionY());
            pane.getChildren().add(roadRepresentation);
        }
        for (Crossroad crossroad:allCrossroads) {
            Rectangle roadRepresentation = new Rectangle(crossroad.getWidth(), crossroad.getHeight(), Color.DARKGRAY);
            Image image = new Image(new FileInputStream("resources/crossroads.png"));
            roadRepresentation.setFill(new ImagePattern(image));
            roadRepresentation.relocate(crossroad.getPositionX(), crossroad.getPositionY());
            pane.getChildren().add(roadRepresentation);
        }
    }
}
