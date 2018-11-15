package sample.model.Vehicles;
import javafx.scene.image.Image;

import sample.model.Util.Direction;

public class Car extends Vehicles {

    private final double CarAcceleration = 0.005;
    private final double CarBreaking = 0.003;

    public String getCarShape() {
        return CarShape;
    }

    public void setCarImage(Image carImage) {
        CarImage = carImage;
    }

    public Image getCarImage() {
        return CarImage;
    }

    private Image CarImage = new Image(getCarShape());

    private final String CarShape = "car.png";
    private final double CarVmax = 10;
    private double CarSpeed = 0;


    public Car(Direction CarDirection){
        shape=CarShape;
        Vmax=CarVmax;
        acceleration=CarAcceleration;
        breaking=CarBreaking;
        speed=CarSpeed;
        direction=CarDirection;



    }

}
