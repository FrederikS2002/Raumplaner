package school.furniture;

import school.Furniture;

import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

public class Spuelbecken extends Furniture {

    public Spuelbecken(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
    }

    public Shape gibAktuelleFigur(){
        // einen GeneralPath definieren
        GeneralPath spuelbecken = new GeneralPath();
        //Umrandung
        Rectangle2D meinRect1 = new Rectangle2D.Double(0,0,breite,tiefe);
        spuelbecken.append(meinRect1,false);
        
        Rectangle2D meinRect2 = new Rectangle2D.Double(breite *0.05 ,tiefe*0.05,breite*0.45,tiefe*0.90);
        spuelbecken.append(meinRect2,false);
        
        Rectangle2D meinRect3 = new Rectangle2D.Double(breite*0.5,tiefe*0.2,breite*0.4,tiefe*0.05);
        spuelbecken.append(meinRect3,false);
        
        Rectangle2D meinRect4 = new Rectangle2D.Double(breite*0.5,tiefe*0.4,breite*0.4,tiefe*0.05);
        spuelbecken.append(meinRect4,false);
        
        Rectangle2D meinRect5 = new Rectangle2D.Double(breite*0.5,tiefe*0.6,breite*0.4,tiefe*0.05);
        spuelbecken.append(meinRect5,false);
        
        Rectangle2D meinRect6 = new Rectangle2D.Double(breite*0.5,tiefe*0.8,breite*0.4,tiefe*0.05);
        spuelbecken.append(meinRect6,false);
        //Ablauf
        Ellipse2D meineEllipse = new Ellipse2D.Double(breite*0.1, tiefe*0.1,breite*0.1, breite*0.1);
        spuelbecken.append(meineEllipse,false);
        return spuelbecken;
    }
   
}