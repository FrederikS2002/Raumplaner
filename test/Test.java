package test;

import java.util.ArrayList;

public class Test {
    ArrayList<Double> arrayList = new ArrayList<Double>();
    public Test() {
        for(double i = 1; i < 1.8*Math.pow(10, 308); i*=1.1){
            arrayList.add(i);
        }
        System.out.println("ArraySize: " + arrayList.size());
        for(double i : arrayList){
            System.out.println(i);
        }
    }
}
