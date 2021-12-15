package school;

import school.furnitureComposition.TischGruppe;

import java.util.ArrayList;

public class Raumplaner {
    ArrayList<Furniture> furnitures = new ArrayList<>();
    private static Raumplaner instance;

    public static Raumplaner getInstance(){
        if(instance == null) instance = new Raumplaner();
        return instance;
    }

    public Raumplaner() {
        furnitures.add(new TischGruppe(0,0,5,5,0,"grün"));
        for (Furniture obj : furnitures){
            obj.zeige();
        }
    }
    public void changex(){
        furnitures.get(0).updatexPosition(10);
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
