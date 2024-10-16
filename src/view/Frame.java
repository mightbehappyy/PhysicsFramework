package view;

import javax.swing.*;

public class Frame {
    public static final int WIDTH = 1600;
    public static final int HEIGHT = 900;

    public Frame(Panel panel) {

        JFrame jframe = new JFrame();
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setTitle("Physics Framework");
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.add(panel);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}