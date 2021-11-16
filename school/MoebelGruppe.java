package school;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public abstract class MoebelGruppe extends Furniture{
    protected ArrayList<Furniture> furnitures = new ArrayList<>();

    public MoebelGruppe(int xPosition, int yPosition, int orientierung, String farbe, boolean istSichtbar, int breite, int tiefe) {
        super(xPosition, yPosition, orientierung, farbe, istSichtbar, breite, tiefe);
    }

    protected abstract ArrayList<Furniture> setArrayList(ArrayList<Furniture> furnitures);

    @Override
    protected Shape gibAktuelleFigur() {
        GeneralPath obj = new GeneralPath();
        for(Furniture objs : furnitures){
            obj.append(objs.gibTransformierteFigur(), false);
        }
        return obj;
    }
}
