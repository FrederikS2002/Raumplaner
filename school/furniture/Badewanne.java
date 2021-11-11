package school.furniture;

import school.Furniture;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public class Badewanne extends Furniture {
    public Badewanne(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
    }

    @Override
    protected Shape gibAktuelleFigur() {
        int gap;
        if(breite < tiefe){
            gap = breite / 10;
        }else{
            gap = tiefe / 10;
        }
        GeneralPath test = new GeneralPath();
        Rectangle2D rect = new Rectangle2D.Double(0,0,breite, tiefe);
        Ellipse2D oval = new Ellipse2D.Double((int)Math.round(gap * 1.5), tiefe / 2 - gap / 4, gap / 2, gap / 2);
        Arc2D arc = new Arc2D.Double(breite - tiefe / 3 - (tiefe - gap * 2) / 2, gap, tiefe - gap * 2, tiefe - gap * 2, 90, -180, Arc2D.PIE);
        test.append(rect, false);
        test.append(oval, false);
        test.append(arc, false);
        test.moveTo(gap, gap);
        test.lineTo(breite - tiefe / 3, gap);
        test.moveTo(gap, tiefe- gap);
        test.lineTo(breite - breite / 3, tiefe - gap);
        test.moveTo(gap, gap);
        test.lineTo(gap, tiefe - gap);
        return test;
    }
}
