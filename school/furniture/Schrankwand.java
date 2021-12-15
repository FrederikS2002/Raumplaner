package school.furniture;

import school.Furniture;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Schrankwand extends Furniture {
    public Schrankwand(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
    }

    protected Shape gibAktuelleFigur(){
        // einen GeneralPath definieren
        GeneralPath schrankwand = new GeneralPath();
        schrankwand.append(new Schrankelement(0,0,0,"cyan",false,breite/3,tiefe).gibTransformierteFigur(), false);
        schrankwand.append(new Schrankelement(breite/3,0,0,"cyan",false,breite/3,tiefe).gibTransformierteFigur(), false);
        schrankwand.append(new Schrankelement(2*breite/3,0,0,"cyan",false,breite/3,tiefe).gibTransformierteFigur(), false);

        return schrankwand;
    }
}