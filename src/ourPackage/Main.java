package ourPackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Simulation simulation = new Simulation();
        primaryStage.setTitle("CitSimmy");
        primaryStage.setScene(new Scene(simulation, 1000, 600));
        primaryStage.show();
        simulation.start();
    }



}
