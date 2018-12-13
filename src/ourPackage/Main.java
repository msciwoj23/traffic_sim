package ourPackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    public static int getBoardWidth() {
        return BOARD_WIDTH;
    }

    public static int getBoardHeight() {
        return BOARD_HEIGHT;
    }

    private static final int BOARD_WIDTH = 1000;
    private static final int BOARD_HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Simulation simulation = new Simulation();
        primaryStage.setTitle("CitSimmy");
        primaryStage.setScene(new Scene(simulation, BOARD_WIDTH, BOARD_HEIGHT));
        primaryStage.show();
        simulation.start();
    }



}
