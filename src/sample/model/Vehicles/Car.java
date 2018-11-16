package sample.model.Vehicles;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.model.Util.Direction;

public class Car extends Vehicles implements Movable {

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

    public ImageView getCarView() {
        return CarView;
    }

    private ImageView CarView=new ImageView(getCarImage());


    private final String CarShape = "car.png";
    private final double CarVmax = 10;
    private double CarSpeed = 0;


    public Car(Pane pane, Direction CarDirection, int posX, int posY){
        positionX=posX;
        positionY=posY;
        shape=CarShape;
        Vmax=CarVmax;
        acceleration=CarAcceleration;
        breaking=CarBreaking;
        speed=CarSpeed;
        direction=CarDirection;
        vehicleImage=CarImage;
        ImageView carView=new ImageView(getCarImage());
        vehicleView=carView;
        carView.setX(positionX);
        carView.setX(positionY);
//        pane.getChildren().add(carView);



    }
    public void step(Pane pane, double changeX, double changeY ) {
        pane.getChildren().remove(this.getCarView());

        getCarView().setX(this.getPositionX()+changeX);
        this.setPositionX(getCarView().getX());

        getCarView().setY(this.getPositionY()+changeY);
        this.setPositionY(getCarView().getY());

        pane.getChildren().add(getCarView());




    }
}
