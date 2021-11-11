package de.raumplaner.objects;

import de.raumplaner.Furniture;

import java.awt.*;

public class Chair extends Furniture {

    public Chair(int x, int y, int width, int height, int degrees, String color, boolean visible) {
        super(x, y, width, height, degrees, color, visible);

    }
    @Override
    protected Graphics2D getModel(Graphics2D g2d) {
        g2d.drawLine(0,0, width, 0);
        g2d.drawLine(width, 0,width+(width/20+1), height);
        g2d.drawLine(width+(width/20+1), height,-(width/20+1), height);
        g2d.drawLine(-(width/20+1), height,0 , 0);

        g2d.drawLine(0,(width/10+1),width, (width/10+1));
        return g2d;
    }

}
