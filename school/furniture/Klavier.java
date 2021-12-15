package school.furniture;

//import de.ljk.Furniture;

import school.Furniture;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Klavier extends Furniture {


    public Klavier(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
    }

    public Shape gibAktuelleFigur() {

        GeneralPath klavier = new GeneralPath();

        klavier.moveTo(0,0);
        klavier.lineTo(0,tiefe);
        klavier.lineTo(breite,tiefe);
        klavier.lineTo(breite,0);
        klavier.lineTo(0,0);



        for(int i = 0; i < 26; i ++) {

            klavier.moveTo(0, 10 + i * 5);
            klavier.lineTo(17,10 + i * 5);
            klavier.lineTo(17,(10 + i * 5) + 5);
            klavier.lineTo(0,(10 + i * 5) + 5);

        }

        // transformieren:
        return klavier;
    }

}