package ourPackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    public static int getBoardwidth() {
        return boardwidth;
    }

    public static int getBoardheight() {
        return boardheight;
    }

    private static int boardwidth= 1000;
    private static int boardheight= 600;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Simulation simulation = new Simulation();
        primaryStage.setTitle("CitSimmy");
        primaryStage.setScene(new Scene(simulation, boardwidth, boardheight));
        primaryStage.show();
        simulation.start();
    }



}
