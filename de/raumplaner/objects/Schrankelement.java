package de.raumplaner.objects;

import de.raumplaner.Furniture;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;

public class Schrankelement extends Furniture
{
    public Schrankelement(int x, int y, int width, int height, int rotation, String color, boolean visible) {
        super(x, y, width, height, rotation, color, visible);
    }

    @Override
    protected Graphics2D getModel(Graphics2D g2d) {
        g2d.drawRect(0,0, width, height);
        g2d.drawLine(0,0, width, height);
        g2d.drawLine(width , 0, 0, height);
        return g2d;
    }
}
