package ourPackage;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CrossroadGenerator {
    private List<Integer> usedID = new ArrayList<>();

    private void chooseRoad1(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane) throws FileNotFoundException {
        for (int i = 0; i < allRoads.size(); i++) {
            chooseRoad2(allRoads, allCrossroads, pane, i);
        }
    }

    private void chooseRoad2(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane,int i) throws FileNotFoundException {
        for (int j = 0; j < allRoads.size(); j++) {
            checkIfRoadsAreNotSame(allRoads, allCrossroads, pane, i,j);
        }
    }

    private void checkIfRoadsAreNotSame(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane,int i, int j) throws FileNotFoundException {
        if (i != j) {
            checkPosition(allRoads, allCrossroads, pane, i,j);
        } else {}

    }

    private void checkPosition(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane,int i, int j) throws FileNotFoundException {
        if (allRoads.get(j).getPositionX() == allRoads.get(i).getPositionX() && allRoads.get(j).getPositionY() == allRoads.get(i).getPositionY() && usedID.contains(i) == false) {

            Crossroad crossroad=generateCrossroad(allRoads, allCrossroads, pane,i,j);
            addLights(allRoads, allCrossroads, pane, crossroad);

        }
    }


    private Crossroad generateCrossroad(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane,int i,int j) throws FileNotFoundException {
        Crossroad crossroad = new Crossroad(allRoads.get(j).getPositionX(), allRoads.get(j).getPositionY(), allRoads.get(j).getSize());
        allCrossroads.add(crossroad);
        allRoads.remove(j);
        allRoads.remove(i);
        return crossroad;
    }
    private int translateVisibleLightsLeft=-10;
    private int translateVisibleLightsRight=110;
    private int translateVisibleLightsUp=-20;
    private int translateVisibleLightsDown=120;
    private int hideMinus=-35;
    private int hidePlus=35;
    private int moveRight=5;
    private int moveLeft=-5;




    private void addLights(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane, Crossroad crossroad) throws FileNotFoundException {
        Light lightSE = new Light(pane, crossroad.getPositionX() + translateVisibleLightsRight + hideMinus, crossroad.getPositionY() + translateVisibleLightsDown,0,15);
        Light lightSEvisible = new Light(pane, crossroad.getPositionX() + translateVisibleLightsRight+moveRight, crossroad.getPositionY() + translateVisibleLightsDown,0,20);
        Light lightSW = new Light(pane, crossroad.getPositionX() + translateVisibleLightsLeft, crossroad.getPositionY() + translateVisibleLightsDown + hideMinus, 1000,15);
        Light lightSWvisible = new Light(pane, crossroad.getPositionX() + translateVisibleLightsLeft+moveLeft, crossroad.getPositionY() + translateVisibleLightsDown,1000,20);
        Light lightNW = new Light(pane, crossroad.getPositionX() + translateVisibleLightsLeft + hidePlus, crossroad.getPositionY() + translateVisibleLightsUp,0,15);
        Light lightNWvisible = new Light(pane, crossroad.getPositionX() + translateVisibleLightsLeft+moveLeft, crossroad.getPositionY() + translateVisibleLightsUp,0,20);
        Light lightNE = new Light(pane, crossroad.getPositionX() + translateVisibleLightsRight, crossroad.getPositionY() + translateVisibleLightsUp + hidePlus,1000,15);
        Light lightNEvisible = new Light(pane, crossroad.getPositionX() + translateVisibleLightsRight+moveRight, crossroad.getPositionY() +translateVisibleLightsUp,1000,20);
    }



    public void checkAndGenerate(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane) throws FileNotFoundException {
        chooseRoad1(allRoads, allCrossroads, pane);





    }
}
