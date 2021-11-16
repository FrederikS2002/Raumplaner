package school;

import school.FurnitureArray.TischGruppe;
import school.furniture.Schrankelement;
import school.furniture.Schrankwand;

import java.util.ArrayList;

public class Raumplaner {
    ArrayList<Furniture> furnitures = new ArrayList<Furniture>();

    public Raumplaner() {
        furnitures.add(new TischGruppe(5,5,3,2,0,"rot"));
        for (Furniture obj : furnitures){
            obj.zeige();
        }
    }

    public void zeigeFurniture(int index){
        System.out.println(furnitures.get(index));
    }

    public void zeigeFurnitureArray(){
        for(Furniture obj : furnitures){
            System.out.println(obj);
        }
    }

    public void deleteFromFurniture(int index){
        furnitures.remove(index);
    }

    public void deleteAllFromFurniture(){
        furnitures.clear();
    }
}
