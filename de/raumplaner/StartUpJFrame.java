package de.raumplaner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUpJFrame extends JFrame implements ActionListener {
    JButton textbox;
    int response;
    String name = "";

    public StartUpJFrame(){
        this.setTitle(name);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        textbox = new JButton("Select JSON");
        textbox.addActionListener(this);
        this.add(textbox);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == textbox){
            JFileChooser fileChooser = new JFileChooser();
            response = fileChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                this.setVisible(false);
                new InstanceJFrame(fileChooser.getSelectedFile().getAbsolutePath());
            }
        }
    }
}
