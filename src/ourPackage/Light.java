package ourPackage;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Light extends Circle {

    protected Pane pane;


    private int timer;
    private int timeToNextGreen;
    private int timeForGreen = 0;
    private int timeForYellowAftGreen = 700;
    private int timeForRed = 1000;
    private int timeForYellowAftRed = 1700;

    Image red = new Image(new FileInputStream("resources/red.png"));
    Image yellow = new Image(new FileInputStream("resources/yellow.png"));
    Image green = new Image(new FileInputStream("resources/green.png"));


    Light (Pane pane, int xc, int yc, int timer, int radius) throws FileNotFoundException {
        super(xc,yc,radius, Color.GREEN);

        this.timer = timer;

        Simulation.lights.add(this);
        Simulation.stopLights.add(this);
        pane.getChildren().add(this);
        this.setFill(new ImagePattern(green));
    }

    void senseTimePassingAndChange () {
        final int TIME_FOR_GREEN = 0;
        final int TIME_FOR_YELLOW_AFT_GREEN = 700;
        final int TIME_FOR_RED = 1000;
        final int TIME_FOR_YELLOW_AFT_RED = 1700;

        final int CYCLES_END = 2001;
        final int NOW = 0;

        if (timer == TIME_FOR_YELLOW_AFT_GREEN) {
            this.setFill(new ImagePattern(yellow));
        } else if (timer == TIME_FOR_RED) {
            this.setFill(new ImagePattern(red));
        } else if (timer == TIME_FOR_YELLOW_AFT_RED) {
            this.setFill(new ImagePattern(yellow));
        } else if (timer == CYCLES_END) {
            if (this.getFill() == new ImagePattern(green)) {
                timeToNextGreen = 1;
            } else {
                timeToNextGreen = CYCLES_END - timer;
            }
        }
    }

    int getTimeToNextGreen() {
        return timeToNextGreen;
    }
}
