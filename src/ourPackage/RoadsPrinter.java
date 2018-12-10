package ourPackage;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class RoadsPrinter {
    public void printRoads(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane){

        for (NormalRoad road:allRoads) {
            Rectangle roadRepresentation = new Rectangle(road.getWidth(),road.getHeight(), Color.GRAY);
            roadRepresentation.relocate(road.getPositionX(),road.getPositionY());
            pane.getChildren().add(roadRepresentation);
        }
        for (Crossroad crossroad:allCrossroads) {
            Rectangle roadRepresentation = new Rectangle(crossroad.getWidth(), crossroad.getHeight(), Color.DARKGRAY);
            roadRepresentation.relocate(crossroad.getPositionX(), crossroad.getPositionY());

            pane.getChildren().add(roadRepresentation);
        }

    }
}
