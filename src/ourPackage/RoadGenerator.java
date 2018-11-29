package ourPackage;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class RoadGenerator {
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    private int start;
    private int stop;
    private boolean vertical;
    private int size=100;

    public void generate(int start, int stop, int secondParameter, boolean vertical, Pane pane, List<NormalRoad> allRoads) {

        if (vertical){

            for (int i=Math.round(start/size);i<Math.round(stop/size)+1;i++){



                NormalRoad road= new NormalRoad(secondParameter,i*size, size);
                allRoads.add(road);
                System.out.println();
                if (i*size==0){

                    CarGeneratorField carGenerator = new CarGeneratorField(secondParameter,-100,Direction.S,pane);
                    Simulation.allCarGenerators.add(carGenerator);
                }
                if (i*size==Main.getBoardheight()){
                    CarGeneratorField carGenerator = new CarGeneratorField(secondParameter, Main.getBoardheight(),Direction.N,pane);
                    Simulation.allCarGenerators.add(carGenerator);
//                    System.out.println("tu jestem");
                }


            }

        }else{
            for (int i=Math.round(start/size);i<Math.round(stop/size)+1;i++){
                NormalRoad road= new NormalRoad(i*size, secondParameter, size);
                allRoads.add(road);
                if (Math.round(i*size)==0){
                    CarGeneratorField carGenerator = new CarGeneratorField(-100,secondParameter,Direction.E,pane);
                    Simulation.allCarGenerators.add(carGenerator);
                }
                if (i*size==Main.getBoardwidth()){
                    CarGeneratorField carGenerator = new CarGeneratorField(Main.getBoardwidth(), secondParameter,Direction.W,pane);
                    Simulation.allCarGenerators.add(carGenerator);
                }
            }

        }
    }
}
