package ourPackage;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class Simulation extends Pane {

    static List<Car> cars = new LinkedList<>();

    static List<Light> lights = new LinkedList<>();

    static List<Light> stopLights = new LinkedList<>();

    static List<CarGeneratorField> allCarGenerators= new ArrayList<>();

    static List<CarGeneratorField> getAllCarGenerators() {
        return allCarGenerators;
    }

    Simulation() {
        List<NormalRoad> allRoads = new ArrayList<>();
        List<Crossroad> allCrossroads = new ArrayList<>();

        RoadGenerator road=new RoadGenerator();
        road.generate(0,1000,100, false, this,allRoads);
        road.generate(0,1000,300, true, this,allRoads);
        road.generate(0,300,300, false, this,allRoads);
        road.generate(0,1000,500, true, this,allRoads);
        CrossroadGenerator crossroads= new CrossroadGenerator();
        crossroads.checkAndGenerate(allRoads, allCrossroads, this);
        RoadsPrinter printRoads=new RoadsPrinter();
        printRoads.printRoads(allRoads,allCrossroads,this);

    }

    void start() {
        SimLoop simLoop = new SimLoop();
        simLoop.start();
    }
}
