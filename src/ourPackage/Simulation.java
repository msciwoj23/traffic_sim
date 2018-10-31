package ourPackage;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Simulation extends Pane {

    public Simulation() {

       new Entity(this, 400,300, "movable");
       new Entity(this, 400,200, "immovable");
    }

    public void start() {

        Scene scene = getScene();

        SimLoop simLoop = new SimLoop();
        simLoop.start();
    }
}
