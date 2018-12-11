package ourPackage;

import javafx.scene.layout.Pane;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoadGeneratorTest extends Pane {

    @Test
    public void generate() {
        Simulation simulation= new Simulation();
        simulation.getAllRoads().clear();
        simulation.getAllCrossroads().clear();
        simulation.getAllCarGenerators().clear();

        int start=100;
        int stop=1000;
        int secondParameter=100;
        boolean vertical1=true;
        boolean vertical2=false;
        int numberOfHorizontalGenerators=0;
        int numberOfVerticalGenerators=0;

        Pane pane=new Pane();
        RoadGenerator road=new RoadGenerator();
        road.generate(start, stop, secondParameter, vertical1,pane, simulation.allRoads);

        System.out.println("Nuber of roads tile");
        assertEquals((int)(stop-start)/100, simulation.getAllRoads().size());
        System.out.println("Correct");
        System.out.println("Vertical roads position");
        for (int i=0;i<simulation.getAllRoads().size();i++){
            if (simulation.getAllRoads().get(i).getPositionY()<=0){numberOfVerticalGenerators++;}
            if (simulation.getAllRoads().get(i).getPositionY()==(Main.getBoardHight()-simulation.getAllRoads().get(i).getSize())){numberOfVerticalGenerators++;}
            assertEquals(start+(i)*100, simulation.getAllRoads().get(i).getPositionY());
            assertEquals(secondParameter, simulation.getAllRoads().get(i).getPositionX());
        }
        System.out.println("Correct");
        System.out.println("Number of Vertical Car Generators");
        assertEquals(numberOfVerticalGenerators, simulation.getAllCarGenerators().size());
        System.out.println("Correct");


        simulation.getAllRoads().clear();
        simulation.getAllCrossroads().clear();
        simulation.getAllCarGenerators().clear();


        road.generate(start, stop, secondParameter, vertical2,pane, simulation.allRoads);
        System.out.println("Nuber of roads tile");
        assertEquals((int)(stop-start)/100, simulation.getAllRoads().size());
        System.out.println("Correct");
        System.out.println("Horizontal roads position");
        for (int i=0;i<simulation.getAllRoads().size();i++){
            if (simulation.getAllRoads().get(i).getPositionX()<=0){numberOfHorizontalGenerators++;}
            if (simulation.getAllRoads().get(i).getPositionX()==(Main.getBoardWidth()-simulation.getAllRoads().get(i).getSize())){numberOfHorizontalGenerators++;}
            assertEquals(start+(i)*100, simulation.getAllRoads().get(i).getPositionX());
            assertEquals(secondParameter, simulation.getAllRoads().get(i).getPositionY());
        }
        System.out.println("Correct");
        System.out.println("Number of Horizontal Car Generators");
        assertEquals(numberOfHorizontalGenerators, simulation.getAllCarGenerators().size());
        System.out.println("Correct");

        simulation.getAllRoads().clear();
        simulation.getAllCrossroads().clear();
        simulation.getAllCarGenerators().clear();


        road.generate(start, stop, secondParameter, vertical1,pane, simulation.allRoads);
        road.generate(start, stop, secondParameter, vertical2,pane, simulation.allRoads);

        System.out.println("Number of crossroad");
        assertEquals(1, simulation.getAllCrossroads().size());
        System.out.println("Correct");


    }

//    @Test
//    public void generateVerticalRoad() {
//    }
//
//    @Test
//    public void generateHorizontalRoad() {
//    }
}