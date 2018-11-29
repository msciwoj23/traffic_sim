package ourPackage;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class CrossroadGenerator {
    private List<Integer> usedID = new ArrayList<>();

    public void checkAndGenerate(List<NormalRoad> allRoads, List<Crossroad> allCrossroads, Pane pane) {
        for (int i = 0; i < allRoads.size(); i++) {
            for (int j = 0; j < allRoads.size(); j++) {
                if (allRoads.get(j).getPositionX() == allRoads.get(i).getPositionX() && allRoads.get(j).getPositionY() == allRoads.get(i).getPositionY() && usedID.contains(i) == false) {
                    if (i != j) {
                        Crossroad crossroad = new Crossroad(allRoads.get(j).getPositionX(), allRoads.get(j).getPositionY(), allRoads.get(j).getSize());
                        allCrossroads.add(crossroad);
                        allRoads.remove(j);
                        allRoads.remove(i);

                        Light lightSE = new Light(pane, crossroad.getPositionX() + 90, crossroad.getPositionY() + 110,0);
                        Light lightSEvisible = new Light(pane, crossroad.getPositionX() + 110, crossroad.getPositionY() + 110,0);
                        Light lightSW = new Light(pane, crossroad.getPositionX() - 10, crossroad.getPositionY() + 90, 1000);
                        Light lightSWvisible = new Light(pane, crossroad.getPositionX() - 10, crossroad.getPositionY() + 110,1000);
                        Light lightNW = new Light(pane, crossroad.getPositionX() - 10, crossroad.getPositionY() - 10,0);
                        Light lightNWvisible = new Light(pane, crossroad.getPositionX() + 10, crossroad.getPositionY() - 10,0);
                        Light lightNE = new Light(pane, crossroad.getPositionX() + 110, crossroad.getPositionY() + 10,1000);
                        Light lightNEvisible = new Light(pane, crossroad.getPositionX() + 110, crossroad.getPositionY() - 10,1000);


//                        i--;
//                        j--;

                    } else {
                    }
                }
            }

        }

        System.out.println("wygenerowano");
    }
}
