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

        Car carS = new Car(this, 30,44, 0);
        carS.setX(665);
        carS.setY(453);

        Car carS2 = new Car(this, 30,44, 0);
        carS2.setX(665);
        carS2.setY(553);

        Car carW = new Car(this, 30,44, 90);
        carW.setX(330);
        carW.setY(250);

        Car carW2 = new Car(this, 30,44, 90);
        carW2.setX(230);
        carW2.setY(250);

        Car carN = new Car(this, 30,44, 180);
        carN.setX(610);
        carN.setY(101);

        Car carN2 = new Car(this, 30,44, 180);
        carN2.setX(610);
        carN2.setY(1);

        Car carE = new Car(this, 30,44, 270);
        carE.setX(800);
        carE.setY(200);

        Car carE2 = new Car(this, 30,44, 270);
        carE2.setX(900);
        carE2.setY(200);

        Rectangle crossroads = new Rectangle(100,100, Color.DARKGRAY);
        crossroads.setX(600);
        crossroads.setY(200);

        Light lightSE = new Light(this, 700, 300,0);
        Light lightSW = new Light(this, 600, 300, 1000);
        Light lightNW = new Light(this, 600, 200,0);
        Light lightNE = new Light(this, 700, 200,1000);


        Rectangle roadS = new Rectangle(100,300, Color.GRAY);
        roadS.relocate(600,300);

        Rectangle roadN = new Rectangle(100,200, Color.GRAY);
        roadN.relocate(600,0);

        Rectangle roadW = new Rectangle(300,100, Color.GRAY);
        roadW.relocate(300,200);

        Rectangle roadE = new Rectangle(300,100, Color.GRAY);
        roadE.relocate(700,200);


        this.getChildren().addAll(crossroads, roadS, roadN, roadW, roadE);

        crossroads.toBack();
        roadS.toBack();
        roadN.toBack();
        roadW.toBack();
        roadE.toBack();

        // carS.toFront();
        lightSE.toFront();
        lightSW.toFront();
        lightNW.toFront();
        lightNE.toFront();
    }

    public void start() {

        SimLoop simLoop = new SimLoop();
        simLoop.start();
    }
}
