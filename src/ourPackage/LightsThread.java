package ourPackage;

public class LightsThread {

    void run() {
        new Thread(this::lightsHandle).start();
    }

    public void lightsHandle() {
        while (true) {
            changeLightAndTime();
            try {
            Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void changeLightAndTime() {
        for (Light light : Simulation.lights) {
            light.senseTimePassingAndChange();
        }
    }
}
