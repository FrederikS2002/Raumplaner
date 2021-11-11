package de.raumplaner;

import javax.swing.*;


public class InstanceJFrame extends JFrame {
    String title = "test";

    public InstanceJFrame(String filepath) {
        //TODO:READ JSON
        InstanceJPanel instanceJPanel = new InstanceJPanel(filepath);
        instanceJPanel.setINSTANCE(instanceJPanel);
        this.add(instanceJPanel);
        this.setTitle(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
