package sample.model.Vehicles;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.model.Util.Direction;

public abstract class Vehicles implements Movable {
    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    double positionX;
    double positionY;
    String shape;
    double Vmax;
    double acceleration;
    double breaking;
    Direction direction;
    double speed;
    Image vehicleImage;
    ImageView vehicleView;


    public double getSpeed() {
        return speed;
    }


    public void setSpeed(double speed) {
        this.speed = speed;
    }


    public Direction getDirection() {
        return direction;
    }


    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public void move(){

    }

}
