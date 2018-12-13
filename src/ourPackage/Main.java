package ourPackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    public static int getBoardWidth() {
        return boardWidth;
    }

    public static int getBoardHight() {
        return boardHight;
    }

    private static int boardWidth= 1000;
    private static int boardHight= 600;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Simulation simulation = new Simulation();
        primaryStage.setTitle("CitSimmy");
        primaryStage.setScene(new Scene(simulation, boardWidth, boardHight));
        primaryStage.show();
        simulation.start();
    }



}
