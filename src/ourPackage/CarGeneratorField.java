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

    public CarGeneratorField(int positionX, int positionY, Direction direction,Pane pane) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
        this.pane=pane;
        this.timer=Math.random()+2*60;
    }
    public void printField(){}

    public void timer(){timer--;}

    public void tryToGenerateCar(){

        // System.out.println(timer);
         if (timer<0){



                if (direction == Direction.N) {
                    Car car = new Car(pane, 30, 44, 0);
                    car.setX(positionX + 65);
                    car.setY(positionY + 53);
                    car.toFront();
                }
                if (direction == Direction.S) {


                    Car car = new Car(pane, 30, 44, 180);
                    car.setX(positionX + 15);
                    car.setY(positionY + 53);
//                car.setX(100);
//                car.setY(100);
                    car.toFront();

                }
                if (direction == Direction.E) {
//                    System.out.println("activated");
                    Car car = new Car(pane, 30, 44, 90);
                    car.setX(positionX + 15);
                    car.setY(positionY + 53);
//                    System.out.println(car.getX() + " " + car.getY());
//                car.setX(100);
//                car.setY(100);
                    car.toFront();

                }
                if (direction == Direction.W) {
//                    System.out.println("activated");
                    Car car = new Car(pane, 30, 44, 270);
                    car.setX(positionX + 15);
                    car.setY(positionY + 3);
//                    System.out.println(car.getX() + " " + car.getY());
                    car.toFront();
                }

                timer = Math.random()*3*60  + 5 * 60;
//            System.out.println(timer);
            }
     }
}
