package ourPackage;

import javafx.scene.layout.Pane;

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
    public void carFromN(){
        Car car = new Car(pane, carWidth, carLength, direction.getDirection());
        car.setX(positionX + translateRight);
        car.setY(positionY + translateDown);
        car.toFront();
    }
    public void carFromS(){
        Car car = new Car(pane, carWidth, carLength, direction.getDirection());
        car.setX(positionX + translateLeft);
        car.setY(positionY + translateUp);
        car.toFront();
    }
    public void carFromE(){
        Car car = new Car(pane, carWidth, carLength, direction.getDirection());
        car.setX(positionX + translateLeft);
        car.setY(positionY + translateDown);
        car.toFront();
    }
    public void carFromW(){
        Car car = new Car(pane, carWidth, carLength, direction.getDirection());
        car.setX(positionX + translateRight);
        car.setY(positionY + translateUp);
        car.toFront();
    }

    public void tryToGenerateCar(){


         if (timer<0){
             if (direction == Direction.N) {carFromN();}
             if (direction == Direction.S) {carFromS();}
             if (direction == Direction.E) {carFromE();}
             if (direction == Direction.W) {carFromW();}

             timer = Math.random()*nextCarTimeWindowInSeconds * framesPerSecond  + nextCarMinimumTimeInSeconds * framesPerSecond;
            }
     }
}
