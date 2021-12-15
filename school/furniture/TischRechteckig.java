package school.furniture;

import school.Furniture;

import java.awt.*;
import java.awt.geom.GeneralPath;


/**
 * ein rechteckiger Tisch mit den Ma�en 80*120
 * 
 * @author Claus Albowski
 */
public class TischRechteckig extends Furniture
{
    public TischRechteckig(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
    }

    public Shape gibAktuelleFigur() {
        // einen GeneralPath definieren
        GeneralPath tisch = new GeneralPath();
        tisch.moveTo(0 , 0);
        tisch.lineTo(breite, 0);
        tisch.lineTo(breite , tiefe);
        tisch.lineTo(0 , tiefe);
        tisch.lineTo(0 , 0);
        
        return tisch;
    }
}

