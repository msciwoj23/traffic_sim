package ourPackage;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Light extends Circle {

    protected Pane pane;

    int timer = 0;

    private int timeToNextGreen;

    // double multiplier = 0.5;

    private int timeForGreen = 0;
    private int timeForYellowAftGreen = 700;
    private int timeForRed = 1000;
    private int timeForYellowAftRed = 1700;


    Light (Pane pane, int xc, int yc) {
        super(xc,yc,15, Color.GREEN);

        this.pane = pane;

        Simulation.lights.add(this);
        Simulation.stopLights.add(this);
        pane.getChildren().add(this);
    }

    public void senseTimePassingAndChange () {

        if (timer == timeForYellowAftGreen) {
            this.setFill(Color.YELLOW);
        } else if (timer == timeForRed) {
            this.setFill(Color.RED);
        } else if (timer == timeForYellowAftRed) {
            this.setFill(Color.YELLOW);
        } else if (timer == 2001){
            timer = 0;
            this.setFill(Color.GREEN);
        }

        timer++;
        timeToNextGreen = 2001 - timer;
    }

    int getTimeToNextGreen() {
        return timeToNextGreen;
    }
}
