package school.furniture;

import school.Furniture;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Sofa extends Furniture {

    public Sofa(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
    }

    public Shape gibAktuelleFigur() {
        //aüßere Umrandung
        GeneralPath sofa = new GeneralPath();
        sofa.moveTo(0, 0);
        sofa.lineTo(breite, 0);
        sofa.lineTo(breite, tiefe);
        sofa.lineTo(0, tiefe);
        sofa.lineTo(0, 0);

        //Innere Umrandung
        sofa.moveTo(5, tiefe);
        sofa.lineTo(5, 5);
        sofa.lineTo(breite - 5, 5);
        sofa.lineTo(breite - 5, tiefe);

        //linie in der Mitte
        sofa.moveTo(breite / 2, 5);
        sofa.lineTo(breite / 2, tiefe);

        // transformieren:
       return sofa;
    }


}
