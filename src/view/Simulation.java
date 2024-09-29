package view;

public class Simulation {

    public Simulation() {
        int FPS_LIMIT = 60;
        Panel panel = new Panel(FPS_LIMIT);
        new Frame(panel);
        panel.setFocusable(true);
        panel.requestFocus();
    }
}