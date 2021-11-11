package de.raumplaner.objects;

import de.raumplaner.Furniture;

import java.awt.*;


public class Schrankwand extends Furniture {
    private final int elemente;

    public Schrankwand(int x, int y, int width, int height, int rotation, String color, boolean visible, int count) {
        super(x, y, width * count, height, rotation, color, visible);
        this.elemente = count;
    }

    @Override
    protected Graphics2D getModel(Graphics2D g2d) {
        for(int i = 0; i < elemente; i++){
            g2d = new Schrankelement(getWidth() / elemente * i,0, getWidth() / elemente, getHeight(), 0, getColorStringLoc(), true).transform(g2d);
        }
        return g2d;
    }

    public String getColorStringLoc() {
        if(isActive()){
            return "red";
        }else{
            return super.getColorString();
        }
    }
}
