package sample.model.Vehicles;


import sample.model.Util.Direction;

public abstract class Vehicles  {
    String shape;
    double Vmax;
    double acceleration;
    double breaking;
    Direction direction;
    double speed;



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
