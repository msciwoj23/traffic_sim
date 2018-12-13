package ourPackage;

import javafx.scene.layout.Pane;

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

        RoadGenerator road=new RoadGenerator();
        road.generate(0,1000,100, false, this,allRoads);
        road.generate(0,1000,300, true, this,allRoads);
        road.generate(0,300,300, false, this,allRoads);
        road.generate(0,1000,500, true, this,allRoads);

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
