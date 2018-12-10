package ourPackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private final static int BOARD_WIDTH = 1000;
    private final static int BOARD_HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Simulation simulation = new Simulation();
        primaryStage.setTitle("CitSimmy");
        primaryStage.setScene(new Scene(simulation, BOARD_WIDTH, BOARD_HEIGHT));
        primaryStage.show();
        simulation.start();
    }

    static int getBoardwidth() {
        return BOARD_WIDTH;
    }

    static int getBoardheight() {
        return BOARD_HEIGHT;
    }
}
