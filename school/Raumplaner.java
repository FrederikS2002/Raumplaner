package school;

import school.furniture.Schrankwand;

import java.util.ArrayList;

public class Raumplaner {
    ArrayList<Furniture> furnitures = new ArrayList<Furniture>();
    public Raumplaner() {
        furnitures.add(new Schrankwand(5,5,0,"cyan", false, 50*3,50));
        for (Furniture obj : furnitures){
            obj.zeige();
        }
    }
}
