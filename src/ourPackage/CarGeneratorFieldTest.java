package ourPackage;

import javafx.scene.layout.Pane;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarGeneratorFieldTest extends Pane {


    @Test
    public void carToN() {
        Simulation simulation= new Simulation();
        simulation.cars.clear();
        int positionX=100;
        int positionY=100;
        Pane pane=new Pane();
        CarGeneratorField carGeneratorField=new CarGeneratorField(positionX,positionY,Direction.N,pane);
        carGeneratorField.carToN();
        System.out.println("Creation of cars to North");
        assertEquals(1, simulation.cars.size());
        assertEquals(Car.class, simulation.cars.get(0).getClass());
        assertEquals(Direction.N.getDirection(), simulation.cars.get(0).getCurrentDirection());


        System.out.println("Correct");



    }

    @Test
    public void carToS() {
        Simulation simulation= new Simulation();
        simulation.cars.clear();
        int positionX=100;
        int positionY=100;
        Pane pane=new Pane();
        CarGeneratorField carGeneratorField=new CarGeneratorField(positionX,positionY,Direction.S,pane);
        carGeneratorField.carToN();
        System.out.println("Creation of cars to South");
        assertEquals(1, simulation.cars.size());
        assertEquals(Car.class, simulation.cars.get(0).getClass());
        assertEquals(Direction.S.getDirection(), simulation.cars.get(0).getCurrentDirection());


        System.out.println("Correct");


    }

    @Test
    public void carToE() {
        Simulation simulation= new Simulation();
        simulation.cars.clear();
        int positionX=100;
        int positionY=100;
        Pane pane=new Pane();
        CarGeneratorField carGeneratorField=new CarGeneratorField(positionX,positionY,Direction.E,pane);
        carGeneratorField.carToN();

        System.out.println("Creation of cars to East");
        assertEquals(1, simulation.cars.size());
        assertEquals(Car.class, simulation.cars.get(0).getClass());
        assertEquals(Direction.E.getDirection(), simulation.cars.get(0).getCurrentDirection());


        System.out.println("Correct");
    }

    @Test
    public void carToW() {
        Simulation simulation= new Simulation();
        simulation.cars.clear();
        int positionX=100;
        int positionY=100;
        Pane pane=new Pane();
        CarGeneratorField carGeneratorField=new CarGeneratorField(positionX,positionY,Direction.W,pane);
        carGeneratorField.carToN();
        System.out.println("Creation of cars to West");
        assertEquals(1, simulation.cars.size());
        assertEquals(Car.class, simulation.cars.get(0).getClass());
        assertEquals(Direction.W.getDirection(), simulation.cars.get(0).getCurrentDirection());


        System.out.println("Correct");
    }
    @Test
    public void tryToGenerateCar() {
        Simulation simulation= new Simulation();
        simulation.cars.clear();
        int positionX=100;
        int positionY=100;
        Pane pane=new Pane();
        CarGeneratorField carGeneratorField1=new CarGeneratorField(positionX,positionY,Direction.N,pane);
        CarGeneratorField carGeneratorField2=new CarGeneratorField(positionX,positionY,Direction.S,pane);
        CarGeneratorField carGeneratorField3=new CarGeneratorField(positionX,positionY,Direction.E,pane);
        CarGeneratorField carGeneratorField4=new CarGeneratorField(positionX,positionY,Direction.W,pane);

    }


}