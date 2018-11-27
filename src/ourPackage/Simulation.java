package ourPackage;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Simulation extends Pane {


    public static List<Car> objectsToMove = new LinkedList<>();
    private List<NormalRoad> allRoads = new ArrayList<>();
    private List<Crossroad> allCrossroads = new ArrayList<>();
    public static List<Car> cars = new LinkedList<>();

    public static List<Light> lights = new LinkedList<>();

    public static List<Light> stopLights = new LinkedList<>();

    static final int WINDOW_HEIGHT = 800;
    static final int WINDOW_WIDTH = 1200;

    public Simulation() {

        Car car = new Car(this, 30,44);
        car.setX(365);
        car.setY(653);

//        Rectangle crossroads = new Rectangle(100,100, Color.DARKGRAY);
//        crossroads.setX(600);
//        crossroads.setY(200);
//
//        Rectangle roadS = new Rectangle(100,300, Color.GRAY);
//        roadS.relocate(600,300);
//
//        Rectangle roadN = new Rectangle(100,200, Color.GRAY);
//        roadN.relocate(600,0);
//
//        Rectangle roadW = new Rectangle(300,100, Color.GRAY);
//        roadW.relocate(300,200);
//
//        Rectangle roadE = new Rectangle(300,100, Color.GRAY);
//        roadE.relocate(700,200);
//
//        this.getChildren().addAll(crossroads, roadS, roadN, roadW, roadE);
        RoadGenerator road=new RoadGenerator();
        road.generate(0,1000,100, false, this,allRoads);
        road.generate(0,1000,300, true, this,allRoads);
//        road.generate(0,400,300, false, this,allRoads);
//        road.generate(0,1000,500, true, this,allRoads);

        System.out.println(allRoads.get(1).getSize());
        CrossroadGenerator crossroads= new CrossroadGenerator();
        crossroads.checkAndGenerate(allRoads, allCrossroads, this);
        RoadsPrinter printroads=new RoadsPrinter();
        printroads.printRoads(allRoads,allCrossroads,this);
        Light light = new Light(this, 370, 315);
        car.toFront();
        light.toFront();

    }

    public void start() {

        SimLoop simLoop = new SimLoop();
        simLoop.start();
    }
}
