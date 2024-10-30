package view;

public class Simulation {

    public Simulation() {
        int FPS_LIMIT = 240;
        Panel panel = new Panel(FPS_LIMIT);
        new Frame(panel);
        panel.setFocusable(true);
        panel.requestFocus();
        new Thread(panel::gameLoop).start();
    }
}