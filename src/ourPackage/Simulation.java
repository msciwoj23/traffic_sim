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

    public static List<Car> cars = new LinkedList<>();

    public static List<Light> lights = new LinkedList<>();

    public static List<Light> stopLights = new LinkedList<>();

    private List<NormalRoad> allRoads = new ArrayList<>();
    private List<Crossroad> allCrossroads = new ArrayList<>();

    public static List<CarGeneratorField> allCarGenerators= new ArrayList<>();

    public static List<CarGeneratorField> getAllCarGenerators() {
        return allCarGenerators;
    }

    public static void setAllCarGenerators(List<CarGeneratorField> allCarGenerators) {
        Simulation.allCarGenerators = allCarGenerators;
    }

    public Simulation() {

        Light lightSE = new Light(this, 700, 300,0);
        Light lightSW = new Light(this, 600, 300, 1000);
        Light lightNW = new Light(this, 600, 200,0);
        Light lightNE = new Light(this, 700, 200,1000);

        // carS.toFront();
        lightSE.toFront();
        lightSW.toFront();
        lightNW.toFront();
        lightNE.toFront();

        RoadGenerator road=new RoadGenerator();
        road.generate(0,1000,100, false, this,allRoads);
        road.generate(0,1000,300, true, this,allRoads);
        road.generate(0,400,300, false, this,allRoads);
        road.generate(0,1000,500, true, this,allRoads);
        System.out.println("to tu");
        for (CarGeneratorField generator:allCarGenerators){
            System.out.println(generator.getPositionX()+" "+generator.getPositionY()+" "+generator.getDirection());
        }
        System.out.println(allCarGenerators.size());
        CrossroadGenerator crossroads= new CrossroadGenerator();
        crossroads.checkAndGenerate(allRoads, allCrossroads, this);
        RoadsPrinter printroads=new RoadsPrinter();
        printroads.printRoads(allRoads,allCrossroads,this);

    }

    public void start() {

        SimLoop simLoop = new SimLoop();
        simLoop.start();
    }
}
