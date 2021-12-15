package school.furniture;

import school.Furniture;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Schrankelement extends Furniture {
    public Schrankelement(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
    }

    public Shape gibAktuelleFigur()
    {
        // einen GeneralPath definieren
        GeneralPath schrank = new GeneralPath();
        schrank.moveTo(0 , 0);
        schrank.lineTo(breite , 0);
        schrank.lineTo(breite , tiefe);
        schrank.lineTo(0 , tiefe);
        schrank.lineTo(0 , 0);
        schrank.lineTo(breite , tiefe);
        
        schrank.moveTo(breite , 0 );
        schrank.lineTo(0 , tiefe);
        
        // transformieren:
        return schrank;
    }
}
