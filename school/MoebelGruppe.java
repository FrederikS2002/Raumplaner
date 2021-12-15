package school;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class MoebelGruppe extends Furniture {
    protected ArrayList<Furniture> furnitures = new ArrayList<>();

    public MoebelGruppe(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
    }

    protected abstract void setArrayList();

    @Override
    protected Shape gibAktuelleFigur() {
        setArrayList();
        GeneralPath obj = new GeneralPath();
        for (Furniture objs : furnitures) {
            obj.append(objs.gibTransformierteFigur(), false);
        }
        return obj;
    }
    protected void addToArray(Furniture obj){
        furnitures.add(obj);
    }
    protected void removeFromArray(int index){
        furnitures.remove(index);
    }

}
