package ourPackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Simulation simulation = new Simulation();
        // Parent root = FXMLLoader.load(getClass().getResource("ourPackage.fxml"));
        primaryStage.setTitle("CitSimmy");
        primaryStage.setScene(new Scene(simulation, 600, 600));
        primaryStage.show();
        simulation.start();
    }



}
