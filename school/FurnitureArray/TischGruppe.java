package school.FurnitureArray;

import school.Furniture;
import school.MoebelGruppe;
import school.furniture.Stuhl;
import school.furniture.TischRechteckig;

import java.util.ArrayList;

public class TischGruppe extends MoebelGruppe {
    public TischGruppe(int xPosition, int yPosition, int breite, int tiefe,int orientierung, String farbe) {
        super(xPosition, yPosition, orientierung, farbe, false, breite, tiefe);
        this.furnitures = setArrayList(new ArrayList<Furniture>());
    }

    @Override
    protected ArrayList<Furniture> setArrayList(ArrayList<Furniture> furnitures) {
        int stuhlBreite = 30;
        for(int i = 0; i < tiefe;i++){
            furnitures.add(new Stuhl(0, (int)(stuhlBreite*1.27)+(stuhlBreite + stuhlBreite / 4)* i,270,farbe,false,stuhlBreite, stuhlBreite));
            furnitures.add(new Stuhl((int)(stuhlBreite*1.34)+(stuhlBreite + stuhlBreite / 4)* breite, (int)(stuhlBreite*1.27)+(stuhlBreite + stuhlBreite / 4)* i,90,farbe,false,stuhlBreite, stuhlBreite));

        }

        for(int i = 0; i < breite;i++){
            furnitures.add(new Stuhl((int)(stuhlBreite*1.27)+(stuhlBreite + stuhlBreite / 4)* i, 0,0,farbe,false,stuhlBreite, stuhlBreite));
            furnitures.add(new Stuhl((int)(stuhlBreite*1.27)+(stuhlBreite + stuhlBreite / 4)* i, (int)(stuhlBreite*1.34)+(stuhlBreite + stuhlBreite / 4)* tiefe,180,farbe,false,stuhlBreite, stuhlBreite));
        }

        furnitures.add(new TischRechteckig((stuhlBreite + stuhlBreite / 4),(stuhlBreite + stuhlBreite / 4),0,farbe,false, ((stuhlBreite + stuhlBreite / 4)*breite)-(int)(stuhlBreite*0.15),((stuhlBreite + stuhlBreite / 4)*tiefe)-(int)(stuhlBreite*0.15)));
        return furnitures;
    }
}
