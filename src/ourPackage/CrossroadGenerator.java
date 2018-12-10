package ourPackage;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class CrossroadGenerator {
    private List<Integer> usedID = new ArrayList<>();

    private void chooseRoad1(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane) {
        for (int i = 0; i < allRoads.size(); i++) {
            chooseRoad2(allRoads, allCrossroads, pane, i);
        }
    }

    private void chooseRoad2(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane,int i){
        for (int j = 0; j < allRoads.size(); j++) {
            checkIfRoadsAreNotSame(allRoads, allCrossroads, pane, i,j);
        }
    }

    private void checkIfRoadsAreNotSame(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane,int i, int j){
        if (i != j) {
            checkPosition(allRoads, allCrossroads, pane, i,j);
        } else {}

    }

    private void checkPosition(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane,int i, int j){
        if (allRoads.get(j).getPositionX() == allRoads.get(i).getPositionX() && allRoads.get(j).getPositionY() == allRoads.get(i).getPositionY() && usedID.contains(i) == false) {

            Crossroad crossroad=generateCrossroad(allRoads, allCrossroads, pane,i,j);
            addLights(allRoads, allCrossroads, pane, crossroad);

        }
    }


    private Crossroad generateCrossroad(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane,int i,int j){
        Crossroad crossroad = new Crossroad(allRoads.get(j).getPositionX(), allRoads.get(j).getPositionY(), allRoads.get(j).getSize());
        allCrossroads.add(crossroad);
        allRoads.remove(j);
        allRoads.remove(i);
        return crossroad;
    }
    private int translateVisibleLightsLeft=-10;
    private int translateVisibleLightsRight=110;
    private int translateVisibleLightsUp=-10;
    private int translateVisibleLightsDown=110;
    private int hideMinus=-20;
    private int hidePlus=20;





    private void addLights(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane, Crossroad crossroad){
        Light lightSE = new Light(pane, crossroad.getPositionX() + translateVisibleLightsRight + hideMinus, crossroad.getPositionY() + translateVisibleLightsDown,0);
        Light lightSEvisible = new Light(pane, crossroad.getPositionX() + translateVisibleLightsRight, crossroad.getPositionY() + translateVisibleLightsDown,0);
        Light lightSW = new Light(pane, crossroad.getPositionX() - translateVisibleLightsLeft, crossroad.getPositionY() + translateVisibleLightsDown + hideMinus, 1000);
        Light lightSWvisible = new Light(pane, crossroad.getPositionX() + translateVisibleLightsLeft, crossroad.getPositionY() + translateVisibleLightsDown,1000);
        Light lightNW = new Light(pane, crossroad.getPositionX() + translateVisibleLightsLeft + hidePlus, crossroad.getPositionY() + translateVisibleLightsUp,0);
        Light lightNWvisible = new Light(pane, crossroad.getPositionX() + translateVisibleLightsLeft, crossroad.getPositionY() + translateVisibleLightsUp,0);
        Light lightNE = new Light(pane, crossroad.getPositionX() + translateVisibleLightsRight, crossroad.getPositionY() + translateVisibleLightsUp + hidePlus,1000);
        Light lightNEvisible = new Light(pane, crossroad.getPositionX() + translateVisibleLightsRight, crossroad.getPositionY() +translateVisibleLightsUp,1000);
    }



    public void checkAndGenerate(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane) {
        chooseRoad1(allRoads, allCrossroads, pane);





    }
}
