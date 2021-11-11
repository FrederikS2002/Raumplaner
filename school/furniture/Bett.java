package school.furniture;

import school.Furniture;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public class Bett extends Furniture {
    private final boolean bigBed;

    public Bett(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe, boolean big) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
        this.bigBed = big;
    }

    @Override
    protected Shape gibAktuelleFigur() {
        GeneralPath generalPath = new GeneralPath();
        if(bigBed){
            Rectangle2D rect = new Rectangle2D.Double(0,0,breite/ 2, tiefe);
            Rectangle2D rect2 = new Rectangle2D.Double(breite/2,0,breite / 2, tiefe);
            generalPath.append(rect, false);
            generalPath.append(rect2,false);
        }else{
            Rectangle2D rect = new Rectangle2D.Double(0,0, breite, tiefe);
            generalPath.append(rect, false);
        }
        generalPath.moveTo(0, tiefe / 5);
        generalPath.lineTo(breite, tiefe / 5);
        return generalPath;
    }
}
