package de.raumplaner.objects;

import de.raumplaner.Furniture;

import java.awt.*;

public class Hocker extends Furniture {
    public Hocker(int x, int y, int width, int height, int rotation, String color, boolean visible) {
        super(x, y, width, height, rotation, color, visible);
    }

    @Override
    protected Graphics2D getModel(Graphics2D g2d) {
        g2d.drawOval(0,0,width,height);
        return g2d;
    }
}
