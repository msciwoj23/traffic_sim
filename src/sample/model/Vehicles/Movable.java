package sample.model.Vehicles;

import javafx.scene.layout.Pane;

public interface Movable {

void step(Pane pane, double changeX, double changeY);
}