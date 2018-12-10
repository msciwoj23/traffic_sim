package ourPackage;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

class Light extends Circle {

    private int timer;
    private int timeToNextGreen;

    Light (Pane pane, int xc, int yc, int timer) {
        super(xc,yc,12, Color.GREEN);

        this.timer = timer;

        Simulation.lights.add(this);
        Simulation.stopLights.add(this);
        pane.getChildren().add(this);
    }

    void senseTimePassingAndChange () {
        final int TIME_FOR_GREEN = 0;
        final int TIME_FOR_YELLOW_AFT_GREEN = 700;
        final int TIME_FOR_RED = 1000;
        final int TIME_FOR_YELLOW_AFT_RED = 1700;

        final int CYCLES_END = 2001;
        final int NOW = 0;

        if (timer == TIME_FOR_YELLOW_AFT_GREEN) {
            this.setFill(Color.YELLOW);
        } else if (timer == TIME_FOR_RED) {
            this.setFill(Color.RED);
        } else if (timer == TIME_FOR_YELLOW_AFT_RED) {
            this.setFill(Color.YELLOW);
        } else if (timer == CYCLES_END){
            timer = 0;
            this.setFill(Color.GREEN);
        }

        timer++;
        if (this.getFill() == Color.GREEN) {
            timeToNextGreen = NOW;
        } else {
            timeToNextGreen = CYCLES_END - timer;
        }
    }

    int getTimeToNextGreen() {
        return timeToNextGreen;
    }
}
