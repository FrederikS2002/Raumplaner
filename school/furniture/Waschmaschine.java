package school.furniture;

import school.Furniture;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class Waschmaschine extends Furniture {

    public Waschmaschine(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
    }

    public Shape gibAktuelleFigur()
    {
        GeneralPath waschmaschine = new GeneralPath();
        waschmaschine.moveTo(0 , 0);
        waschmaschine.lineTo(breite, 0);
        waschmaschine.lineTo(breite, tiefe);
        waschmaschine.lineTo(0, tiefe);
        waschmaschine.lineTo(0 , 0);


        Shape kreisAussen = new Ellipse2D.Double(5 , 5, 50, 50);
        Shape kreisInnen = new Ellipse2D.Double(27,27,6,6);


        waschmaschine.append(kreisAussen, false);
        waschmaschine.append(kreisInnen, false);


        return waschmaschine;
    }

}
