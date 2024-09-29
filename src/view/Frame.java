package view;

import javax.swing.*;

public class Frame {

    public Frame(Panel panel) {
        JFrame jframe = new JFrame();
        jframe.setSize(800, 600);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.add(panel);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }

}