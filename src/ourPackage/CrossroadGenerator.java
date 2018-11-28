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
