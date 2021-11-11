package de.raumplaner;

import de.raumplaner.utils.JSONReader;

import javax.swing.*;


public class InstanceJFrame extends JFrame {
    public InstanceJFrame(String filepath) {
        JSONReader jsonReader = new JSONReader(filepath);
        InstanceJPanel instanceJPanel = new InstanceJPanel(jsonReader.getFurnitureInfos());
        instanceJPanel.setINSTANCE(instanceJPanel);
        this.add(instanceJPanel);
        this.setTitle(jsonReader.getName());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public InstanceJFrame() {
        InstanceJPanel instanceJPanel = new InstanceJPanel();
        instanceJPanel.setINSTANCE(instanceJPanel);
        this.add(instanceJPanel);
        this.setTitle("TEST");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
