package sample.model.Roads;

import javafx.scene.image.Image;
import sample.model.Util.Direction;

public class NormalRoad extends Road {
    public Image getRoadImage() {
        return RoadImage;
    }

    private Image RoadImage = new Image(getRoadType());

    public String getRoadType() {
        return roadType;
    }

    private final String roadType = "road.png";

    public NormalRoad(int positionX, int positionY, Direction roadDirection, boolean isOccupied) {
        super(positionX, positionY, roadDirection, isOccupied);
    }
}
