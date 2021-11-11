package de.raumplaner.objects;

import de.raumplaner.Furniture;

import java.awt.*;

public class Klavier extends Furniture {

    public Klavier(int x, int y, int width, int height, int rotation, String color, boolean visible) {
        super(x, y, width, height, rotation, color, visible);
    }

    @Override
    protected Graphics2D getModel(Graphics2D g2d) {
        g2d.drawRect(0,0,width,height);
        for(int i = 0; i < 26; i ++) {
            g2d.drawLine(0, height / 15 + i * height / 30, width / 60 * 17,height / 15 + i * height / 30);
            g2d.drawLine(width / 60 * 17,height / 15 + i * height / 30,width / 60 * 17,(height / 15 + i * height / 30) + height / 30);
            g2d.drawLine(width / 60 * 17,(height / 15 + i * height / 30) + height / 30, 0,(height / 15 + i * height / 30) + height / 30);
        }
        g2d.drawRect(width / 2 - width / 10,height / 2 - height / 4 ,width / 20, height / 2);
        return g2d;
    }
}