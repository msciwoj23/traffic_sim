package ourPackage;

import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;

public class CarGeneratorField {


    private int positionX;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Direction getDirection() {
        return direction;
    }

    private int positionY;
    private Direction direction;
    private Pane pane;
    private double timer;
    private double shortestTimeToGenerateFirstCarInSeconds=2;
    private double nextCarMinimumTimeInSeconds=5;
    private double nextCarTimeWindowInSeconds=3;
    private final int framesPerSecond=60;
    private int carLength=44;
    private int carWidth=30;
    private int translateRight=65;
    private int translateLeft=15;
    private int translateUp=3;
    private int translateDown=53;


    public CarGeneratorField(int positionX, int positionY, Direction direction,Pane pane) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
        this.pane=pane;
        this.timer=Math.random()+shortestTimeToGenerateFirstCarInSeconds * framesPerSecond;
    }
    public void printField(){}

    public void timer(){timer--;}
    public void carToN() throws FileNotFoundException {
        Car car = new Car(pane, carWidth, carLength, direction.getDirection());
        car.setX(positionX + translateRight);
        car.setY(positionY + translateDown);
        car.toFront();
    }
    public void carToS() throws FileNotFoundException {
        Car car = new Car(pane, carWidth, carLength, direction.getDirection());
        car.setX(positionX + translateLeft);
        car.setY(positionY + translateUp);
        car.toFront();
    }
    public void carToE() throws FileNotFoundException {
        Car car = new Car(pane, carWidth, carLength, direction.getDirection());
        car.setX(positionX + translateLeft);
        car.setY(positionY + translateDown);
        car.toFront();
    }
    public void carToW() throws FileNotFoundException {
        Car car = new Car(pane, carWidth, carLength, direction.getDirection());
        car.setX(positionX + translateRight);
        car.setY(positionY + translateUp);
        car.toFront();
    }

    public void tryToGenerateCar() throws FileNotFoundException {


         if (timer<0){
             if (direction == Direction.N) {carToN();}
             if (direction == Direction.S) {carToS();}
             if (direction == Direction.E) {carToE();}
             if (direction == Direction.W) {carToW();}

             timer = Math.random()*nextCarTimeWindowInSeconds * framesPerSecond  + nextCarMinimumTimeInSeconds * framesPerSecond;
            }
     }
}
