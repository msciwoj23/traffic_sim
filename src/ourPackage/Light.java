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

    int timer;

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
        this.pane = pane;

        Simulation.lights.add(this);
        Simulation.stopLights.add(this);
        pane.getChildren().add(this);
        this.setFill(new ImagePattern(green));
    }

    public void senseTimePassingAndChange () {

        if (timer == timeForYellowAftGreen) {
            this.setFill(new ImagePattern(yellow));
        } else if (timer == timeForRed) {
            this.setFill(new ImagePattern(red));
        } else if (timer == timeForYellowAftRed) {
            this.setFill(new ImagePattern(yellow));
        } else if (timer == 2001){
            timer = 0;
            this.setFill(new ImagePattern(green));
        }

        timer++;
        if (this.getFill() == new ImagePattern(green)) {
            timeToNextGreen = 1;
        } else {
            timeToNextGreen = 2001 - timer;
        }
    }

    int getTimeToNextGreen() {
        return timeToNextGreen;
    }
}
