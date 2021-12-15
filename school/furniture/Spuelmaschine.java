package school.furniture;

import school.Furniture;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class Spuelmaschine extends Furniture {

    public Spuelmaschine(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
    }

    public Shape gibAktuelleFigur()
    {
        GeneralPath spuelmaschine = new GeneralPath();

        spuelmaschine.moveTo(0,0);
        spuelmaschine.lineTo(breite,0);
        spuelmaschine.lineTo(breite,tiefe);
        spuelmaschine.lineTo(0,tiefe);
        spuelmaschine.lineTo(0,0);

        spuelmaschine.moveTo(0,0);
        spuelmaschine.lineTo(13, 13);

        spuelmaschine.moveTo(breite,0);
        spuelmaschine.lineTo(breite - 13, 13);

        spuelmaschine.moveTo(0,tiefe);
        spuelmaschine.lineTo(13, tiefe - 13);

        spuelmaschine.moveTo(breite,tiefe);
        spuelmaschine.lineTo(breite - 13, tiefe- 13);

        Shape kreisAussen = new Ellipse2D.Double(5 , 5, 50, 50);
        Shape kreisInnen = new Ellipse2D.Double(27,27,6,6);


        spuelmaschine.append(kreisAussen, false);
        spuelmaschine.append(kreisInnen, false);


        return spuelmaschine;
    }

}
