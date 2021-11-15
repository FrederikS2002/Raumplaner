package de.raumplaner;

import javax.swing.*;
import java.awt.*;

public class SettingsJFrame extends JFrame {

    public SettingsJFrame(){
        this.setTitle("Settings");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
