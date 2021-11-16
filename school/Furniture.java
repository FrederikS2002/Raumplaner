package school;

import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;

public abstract class Furniture {
    private int xPosition;
    private int yPosition;
    private int orientierung;
    protected String farbe;
    private boolean istSichtbar;
    protected int breite;
    protected int tiefe;

    public Furniture(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.orientierung = orientierung;
        this.farbe = farbe;
        this.istSichtbar = istSichtbar;
        this.breite = breite;
        this.tiefe = tiefe;
    }

    public void zeige() {
        if (!istSichtbar) {
            istSichtbar = true;
            zeichne();
        }
    }

    public void verberge() {
        loesche(); // "tue nichts" wird in loesche() abgefangen.
        istSichtbar = false;
    }

    public void dreheAuf(int neuerWinkel) {
        loesche();
        orientierung = neuerWinkel;
        zeichne();
    }

    public void bewegeHorizontal(int entfernung) {
        loesche();
        xPosition += entfernung;
        zeichne();
    }

    public void bewegeVertikal(int entfernung) {
        loesche();
        yPosition += entfernung;
        zeichne();

    }

    public void aendereFarbe(String neueFarbe) {
        loesche();
        farbe = neueFarbe;
        zeichne();
    }

    public GeneralPath form() {
        return null;
    }

    protected void zeichne() {
        if (istSichtbar) {
            Shape figur = gibTransformierteFigur();
            Leinwand leinwand = Leinwand.gibLeinwand();
            leinwand.zeichne(
                    this,           // leinwand kennt das Objekt
                    farbe,          // definiert seine Zeichenfarbe
                    figur);         // definiert seinen grafischen Aspekt
            leinwand.warte(10);
        }
    }

    protected abstract Shape gibAktuelleFigur();

    public void loesche() {
        if (istSichtbar) {
            Leinwand leinwand = Leinwand.gibLeinwand();
            leinwand.entferne(this);
        }
    }

    private Shape transformiere(Shape object) {
        AffineTransform t = new AffineTransform();
        t.translate(xPosition, yPosition);
        Rectangle2D umriss = object.getBounds2D();
        t.rotate(Math.toRadians(orientierung), umriss.getX() + umriss.getWidth() / 2, umriss.getY() + umriss.getHeight() / 2);
        return t.createTransformedShape(object);

    }

    public Shape gibTransformierteFigur() {
        return transformiere(gibAktuelleFigur());
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
}