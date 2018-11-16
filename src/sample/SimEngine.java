package sample;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.model.Roads.NormalRoad;
import sample.model.Roads.Road;
import sample.model.Util.Direction;
import sample.model.Vehicles.*;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.*;
import static javafx.geometry.Pos.TOP_LEFT;





public class SimEngine extends StackPane  {
    private AnimationTimer timer;

    public void start(Stage stage) throws InterruptedException {

        Pane pane = new Pane();
        Scene scene=new Scene(pane,1500,1000);
        stage.setScene(scene);


        GameLoop  simulation= new GameLoop();
        Car car =new Car(pane, Direction.W,0,0);

//        simulation.vehicles.add(car);

//        hBox.getChildren().add(carImage);


        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {if (car.getCarView().getY()<100){car.step(pane,0,0.5);}
            else {car.step(pane,0,1}
//                x=cos(1)*50+50
//                y=sin(1)*50+50

            }

        };
        timer.start();

//        simulation.start();
        stage.show();



    }

}

