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

    private void generateVerticalRoad(int start, int stop, int secondParameter, Pane pane, List<NormalRoad> allRoads){
        for (int i=Math.round(start/size);i<Math.round(stop/size);i++){
            NormalRoad road= new NormalRoad(secondParameter,i*size, size);
            allRoads.add(road);
            if (i*size==0){
                CarGeneratorField carGenerator = new CarGeneratorField(secondParameter,-size,Direction.S,pane);
                Simulation.allCarGenerators.add(carGenerator);
            }
            if (i*size==Main.getBoardHight()-size){
                CarGeneratorField carGenerator = new CarGeneratorField(secondParameter, Main.getBoardHight(),Direction.N,pane);
                Simulation.allCarGenerators.add(carGenerator);
            }
        }

    }

    private void generateHorizontalRoad(int start, int stop, int secondParameter, Pane pane, List<NormalRoad> allRoads){
        for (int i=Math.round(start/size);i<Math.round(stop/size);i++){
            NormalRoad road= new NormalRoad(i*size, secondParameter, size);
            allRoads.add(road);
            if (Math.round(i*size)==0){
                CarGeneratorField carGenerator = new CarGeneratorField(-size,secondParameter,Direction.E,pane);
                Simulation.allCarGenerators.add(carGenerator);
            }
            if (i*size==Main.getBoardWidth()-size){
                CarGeneratorField carGenerator = new CarGeneratorField(Main.getBoardWidth(), secondParameter,Direction.W,pane);
                Simulation.allCarGenerators.add(carGenerator);
            }
        }
    }

    public void generate(int start, int stop, int secondParameter, boolean vertical, Pane pane, List<NormalRoad> allRoads) {

        if (vertical){ generateVerticalRoad(start, stop, secondParameter,pane,allRoads);
        }else{generateHorizontalRoad(start, stop, secondParameter,pane,allRoads);}
    }
}
