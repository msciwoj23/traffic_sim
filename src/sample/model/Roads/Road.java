package sample.model.Roads;

import sample.model.Util.Direction;
import javafx.scene.image.Image;

public abstract class Road {

    private int positionX;
    private int positionY;
    private Direction roadDirection;
    private boolean isOccupied;




    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Direction getRoadDirection() {
        return roadDirection;
    }

    public void setRoadDirection(Direction roadDirection) {
        this.roadDirection = roadDirection;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }



    public Road(int positionX, int positionY, Direction roadDirection, boolean isOccupied) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.roadDirection = roadDirection;
        this.isOccupied = isOccupied;
    }


}
