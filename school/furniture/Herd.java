package school.furniture;

import school.Furniture;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class Herd extends Furniture {
    private final boolean gas;
    public Herd(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe, boolean gas) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
        this.gas = gas;
    }

    @Override
    protected Shape gibAktuelleFigur() {
        int width = breite;
        int height = tiefe;
        Ellipse2D ellipse2D = new Ellipse2D.Double(0,0, width, height);
        Ellipse2D ellipse2D2;
        if(gas){
            ellipse2D2 = new Ellipse2D.Double(width / 2 - width / 4, height / 2 - height / 4, width / 2, height / 2);
        }else{
            ellipse2D2 = new Ellipse2D.Double(width / 2 - width / 10, height / 2 - height / 10, width / 5, height / 5);
        }
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(width, height / 2 - height / 20);
        generalPath.lineTo(width + width / 10, height / 2 - height / 20);
        generalPath.moveTo(width, height / 2 + height / 20);
        generalPath.lineTo(width + width / 10, height / 2 + height / 20);
        generalPath.moveTo(width + width / 10, height / 2 - height / 20);
        generalPath.lineTo(width + width / 10, height / 2 + height / 20);
        generalPath.append(ellipse2D, false);
        generalPath.append(ellipse2D2, false);
        return generalPath;
    }
}
