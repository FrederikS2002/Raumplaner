package de.raumplaner.objects;

import de.raumplaner.Furniture;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public class Bed extends Furniture {
    private boolean bigBed;
    public Bed(int x, int y, int width, int height, int rotation, String color, boolean visible, boolean bigBed) {
        super(x, y, width, height, rotation, color, visible);
    }

    @Override
    protected Graphics2D getModel(Graphics2D g2d) {
        if(bigBed){
            g2d.drawRect(0,0,width/ 2, height);
            g2d.drawRect(width/2,0,width / 2, height);
        }else{
            g2d.drawRect(0,0, width, height);
        }
        g2d.drawLine(0, height / 5, width, height / 5);
        return g2d;
    }

}
