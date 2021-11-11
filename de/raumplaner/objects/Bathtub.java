package de.raumplaner.objects;

import de.raumplaner.Furniture;

import java.awt.*;

public class Bathtub extends Furniture {
    public Bathtub(int x, int y, int width, int height, int rotation, String color, boolean visible) {
        super(x, y, width, height, rotation, color, visible);
    }

    @Override
    protected Graphics2D getModel(Graphics2D g2d) {
        int gap;

        if(width < height){
            gap = width / 10;
        }else{
            gap = height / 10;
        }

        g2d.drawRect(0,0,width,height);
        g2d.drawLine(gap, gap, width - width / 3, gap);
        g2d.drawLine(gap, height- gap, width - width / 3, height - gap);
        g2d.drawLine(gap, gap, gap, height - gap);
        g2d.drawOval((int)Math.round(gap * 1.5), height / 2 - gap / 4, gap / 2, gap / 2);
        g2d.drawArc(width - width / 3 - (height - gap * 2) / 2, gap, height - gap * 2, height - gap * 2, 90, -180);
        return g2d;
    }
}
