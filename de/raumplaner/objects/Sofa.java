package de.raumplaner.objects;

import de.raumplaner.Furniture;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

public class Sofa extends Furniture {


    public Sofa(int x, int y, int width, int height, int rotation, String color, boolean visible) {
        super(x, y, width, height, rotation, color, visible);
    }

    @Override
    protected Graphics2D getModel(Graphics2D g2d) {
        g2d.drawRect(0,0,width,height);
        g2d.drawLine(width / 30, height, width / 30, width / 30);
        g2d.drawLine(width / 30,width / 30, width - width / 30,width / 30);
        g2d.drawLine(width - width / 30,width / 30, width - width / 30, height);

        g2d.drawLine(width - width / 30, height,width / 2, width / 30);
        g2d.drawLine(width / 2, width / 30, width / 2, height);
        return g2d;
    }
}
