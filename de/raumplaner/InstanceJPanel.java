package de.raumplaner;

import de.raumplaner.objects.*;
import de.raumplaner.utils.FurnitureInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;



public class InstanceJPanel extends JPanel  {

    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 600;
    private static final int ACTION_TURN = 1;
    public static final int ACTION_MOVE = 10;
    private static InstanceJPanel INSTANCE;
    private final Color backgroundColor = Color.black;
    public int activeObject = 0;
    ArrayList<Furniture> objects = new ArrayList<>();
    public static final InstanceJPanel getInstance(){
        return INSTANCE;
    }
    public void setINSTANCE(InstanceJPanel INSTANCE){
        InstanceJPanel.INSTANCE = INSTANCE;
    }

    public InstanceJPanel(ArrayList x) {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(backgroundColor);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.addMouseListener(new MyMouseAdapter());
        start(x);
        start();
    }
    public InstanceJPanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(backgroundColor);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.addMouseListener(new MyMouseAdapter());
        start();
    }
    public void start(ArrayList<FurnitureInfo> arrayList){

        for (FurnitureInfo furnitureInfo : arrayList){
            switch (furnitureInfo.getType()){
                case "chair":
                    objects.add(new Chair(furnitureInfo.getX(), furnitureInfo.getY(),furnitureInfo.getWidth(),furnitureInfo.getWidth(),furnitureInfo.getRotation(),furnitureInfo.getColor(),furnitureInfo.isVisible()));
                    break;
                default:
                    throw new IllegalArgumentException("Wrong Input");
            }
        }
    }
    public void start(){
        objects.get(activeObject).setActive(true);
        System.out.println("Use Arrow Keys to move object");
        System.out.println("Use Enter to switch objects");
        System.out.println("Use b/n to rotate");
        System.out.println("Press m to print out active module info");
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        for(Furniture object : objects){
            object.draw(g);
        }
    }

    public void checkCollision(){

    }

    public void actionPerformed(){
        repaint();
    }
    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> objects.get(activeObject).moveX(-ACTION_MOVE);
                case KeyEvent.VK_RIGHT -> objects.get(activeObject).moveX(ACTION_MOVE);
                case KeyEvent.VK_UP -> objects.get(activeObject).moveY(-ACTION_MOVE);
                case KeyEvent.VK_DOWN -> objects.get(activeObject).moveY(ACTION_MOVE);
                case KeyEvent.VK_B -> objects.get(activeObject).updateRotation(-ACTION_TURN);
                case KeyEvent.VK_N -> objects.get(activeObject).updateRotation(ACTION_TURN);
                case KeyEvent.VK_ENTER -> {
                    if (activeObject < objects.size() - 1) {
                        objects.get(activeObject).setActive(false);
                        activeObject++;
                    } else {
                        objects.get(activeObject).setActive(false);
                        activeObject = 0;
                    }
                    objects.get(activeObject).setActive(true);
                }
                case KeyEvent.VK_M -> System.out.println(objects.get(activeObject).getX() + ", " + objects.get(activeObject).getY() + ", " + objects.get(activeObject).getWidth() + ", " + objects.get(activeObject).getHeight() + ", " + objects.get(activeObject).getRotation() + ", " + objects.get(activeObject).getColorString() + ", true");
            }
            actionPerformed();
        }
    }

    public class MyMouseAdapter extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            //TODO:Check if pressed
            if(activeObject < objects.size() - 1){
                objects.get(activeObject).setActive(false);
                activeObject++;
            }else{
                objects.get(activeObject).setActive(false);
                activeObject = 0;
            }
            objects.get(activeObject).setActive(true);
            actionPerformed();
        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }
    }
}
