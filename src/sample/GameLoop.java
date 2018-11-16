package sample;

import javafx.animation.AnimationTimer;
import sample.model.Vehicles.Car;
import sample.model.Vehicles.Movable;
import sample.model.Vehicles.Vehicles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameLoop extends AnimationTimer {





    //
//    public Game() {
    public List<Vehicles> vehicles= new ArrayList<Vehicles>();
//
//    }

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {


        for (Vehicles vehicle : vehicles) {
//            vehicle.step(pane);

            // each time it asks about gameObjects to step.
//
//            if (vehicle instanceof Movable) {
//                Movable animObject = (Movable)vehicle;
//                animObject.step();
                 // this is from interface. Each Animatable has it's step() method
//            }
        }

    }
}
