package de.raumplaner.objects;

import de.raumplaner.Furniture;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

public class Spuelmaschine extends Furniture {
    public Spuelmaschine(int x, int y, int width, int height, int rotation, String color, boolean visible) {
        super(x, y, width, height, rotation, color, visible);
    }

    @Override
    protected Graphics2D getModel(Graphics2D g2d) {
        g2d.drawRect(0,0,width,height);
        g2d.drawLine(0,0,width / 60 * 12,width / 60 * 12);
        g2d.drawLine(width,0,width - width / 60 * 12, width / 60 * 12);
        g2d.drawLine(0,height, width / 60 * 12, height - width / 60 * 12);
        g2d.drawLine(width,height, width - width / 60 * 12, height- width / 60 * 12);
        g2d.drawOval(width / 2 - width / 6 * 5 / 2, height / 2 - height / 6 * 5 / 2, width / 6 * 5, height / 6 * 5);
        g2d.drawOval(width / 2 - width / 10 / 2,height / 2 - height / 10 / 2,width / 10,height / 10);
        return g2d;
    }
}
