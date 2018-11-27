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

            for (int i=Math.round(start/size);i<Math.round(stop/size);i++){


                NormalRoad road= new NormalRoad(secondParameter,i*size, size);
                allRoads.add(road);
            }

        }else{
            for (int i=Math.round(start/size);i<Math.round(stop/size);i++){
                NormalRoad road= new NormalRoad(i*size, secondParameter, size);
                allRoads.add(road);
            }

        }
    }
}
