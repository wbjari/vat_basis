package Presentation;

import javax.swing.*;

public class Frame extends JFrame {
    /**
     * Setup new Frame
     * setDefaultCloseOperation shutdown the program.
     * @param title
     */
    public Frame(String title) {
        this.setTitle(title);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Setup new Panel
     * @param panel
     */
    public void addPanel(JPanel panel) {
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }

}
