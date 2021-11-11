package school.furniture;

import school.Furniture;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class Hocker extends Furniture {
    public Hocker(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
    }

    @Override
    protected Shape gibAktuelleFigur() {
        Ellipse2D ellipse2D = new Ellipse2D.Double(0,0,breite,tiefe);
        GeneralPath generalPath = new GeneralPath();
        generalPath.append(ellipse2D,false);
        return generalPath;
    }
}
