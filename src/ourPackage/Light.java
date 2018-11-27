package ourPackage;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Light extends Circle {

    protected Pane pane;

    int timer = 0;

    double multiplier = 0.5;
    double timeForRed = 700*multiplier;
    double timeForYellowAftRed = 1000*multiplier;
    double timeForGreen = 1700*multiplier;
    double timeForYellowAftGreen = 2000*multiplier;

    Light (Pane pane, int xc, int yc) {
        super(xc,yc,15, Color.RED);

        this.pane = pane;

        Simulation.lights.add(this);
        Simulation.stopLights.add(this);
        pane.getChildren().add(this);
    }

    public void senseTimePassingAndChange () {
        timer++;
        System.out.println(timer);

        if (timer < timeForRed ) {
            this.setFill(Color.RED);
        } else if (timer < timeForYellowAftRed) {
            this.setFill(Color.YELLOW);
        } else if (timer < timeForGreen) {
            this.setFill(Color.GREEN);
        } else if (timer < timeForYellowAftGreen) {
            this.setFill(Color.YELLOW);
        } else if (timer == timeForYellowAftGreen){
            timer = 0;
        }

    }
}
