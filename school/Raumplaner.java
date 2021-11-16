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
