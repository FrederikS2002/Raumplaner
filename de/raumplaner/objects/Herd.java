package de.raumplaner.objects;

import de.raumplaner.Furniture;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Herd extends Furniture {
    private final boolean gas;
    public Herd(int x, int y, int width, int height, int rotation, String color, boolean visible, boolean gas) {
        super(x, y, width, height, rotation, color, visible);
        this.gas = gas;
    }

    @Override
    protected Graphics2D getModel(Graphics2D g2d) {
        g2d.drawOval(0,0, width, height);
        if(gas){
            g2d.drawOval(width / 2 - width / 4, height / 2 - height / 4, width / 2, height / 2);
        }else{
            g2d.drawOval(width / 2 - width / 10, height / 2 - height / 10, width / 5, height / 5);
        }
        g2d.drawLine(width, height / 2 - height / 20, width + width / 10, height / 2 - height / 20);
        g2d.drawLine(width, height / 2 + height / 20, width + width / 10, height / 2 + height / 20);
        g2d.drawLine(width + width / 10, height / 2 - height / 20, width + width / 10, height / 2 + height / 20);
    return g2d;
    }

}
