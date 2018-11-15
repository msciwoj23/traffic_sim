package sample;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.model.Util.Direction;
import sample.model.Vehicles.*;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;


public class SimEngine extends Pane {
//
//    public Game() {
//
//    }
    public void start(Stage stage) {


        GameLoop  simulation= new GameLoop();
        Car car =new Car(Direction.W);
        System.out.println(car.getCarImage());


        stage.setTitle("ImageView Experiment 1");



        ImageView imageView = new ImageView(car.getCarImage());

        HBox hbox = new HBox();

        Scene scene = new Scene(hbox,1500, 1000);
        MoveTo moveTo = new MoveTo();
        moveTo.setX(0);
        moveTo.setY(0);
        hbox.getChildren().add(imageView);
        stage.setScene(scene);
        stage.show();
        PathTransition patht= new PathTransition();
        Path path = new Path();
        patht.setNode(imageView);
        path.getElements().add(moveTo);
        path.getElements().add(new VLineTo(200));
        patht.setDuration(Duration.seconds(5));
        patht.setPath(path);
        patht.play();


        simulation.start();
        stage.show();

    }

}
