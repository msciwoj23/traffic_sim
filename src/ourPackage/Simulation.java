package ourPackage;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;
import java.util.List;


public class Simulation extends Pane {

    public static List<Car> cars = new LinkedList<>();

    public static List<Light> lights = new LinkedList<>();

    public static List<Light> stopLights = new LinkedList<>();

    static final int WINDOW_HEIGHT = 800;
    static final int WINDOW_WIDTH = 1200;

    public Simulation() {

        Car car = new Car(this, 30,44);
        car.setX(665);
        car.setY(553);

        Rectangle crossroads = new Rectangle(100,100, Color.DARKGRAY);
        crossroads.setX(600);
        crossroads.setY(200);

        Light light = new Light(this, 670, 315);


        Rectangle roadS = new Rectangle(100,300, Color.GRAY);
        roadS.relocate(600,300);


        Rectangle roadN = new Rectangle(100,200, Color.GRAY);
        roadN.relocate(600,0);


        Rectangle roadW = new Rectangle(300,100, Color.GRAY);
        roadW.relocate(300,200);


        Rectangle roadE = new Rectangle(300,100, Color.GRAY);
        roadE.relocate(700,200);


        this.getChildren().addAll(crossroads, roadS, roadN, roadW, roadE);
        // System.out.println(this.getChildren());

        crossroads.toBack();
        roadS.toBack();
        roadN.toBack();
        roadW.toBack();
        roadE.toBack();

        car.toFront();
        light.toFront();

    }

    public void start() {

        SimLoop simLoop = new SimLoop();
        simLoop.start();
    }
}
