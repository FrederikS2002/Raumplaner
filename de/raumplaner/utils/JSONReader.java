package de.raumplaner.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JSONReader {
    ArrayList<FurnitureInfo> furnitureInfos = new ArrayList<FurnitureInfo>();
    private final String absolutePath;
    private String jsonString;
    private String name;
    JSONObject jsonObject;

    public JSONReader(String absolutePath) {
        this.absolutePath = absolutePath;
        try{
            getStringFromFile();
            this.jsonObject = new JSONObject(jsonString);
            this.name = jsonObject.getString("name");
            generateFurnitureInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateFurnitureInfo(){
        JSONArray objs = jsonObject.getJSONArray("obj");
        for (int i = 0; i < objs.length(); i++){
            furnitureInfos.add(new FurnitureInfo(
                    objs.getJSONObject(i).getString("type"),
                    objs.getJSONObject(i).getInt("x"),
                    objs.getJSONObject(i).getInt("y"),
                    objs.getJSONObject(i).getInt("width"),
                    objs.getJSONObject(i).getInt("height"),
                    objs.getJSONObject(i).getInt("rotation"),
                    objs.getJSONObject(i).getBoolean("visible"),
                    objs.getJSONObject(i).getString("color")
            ));
        }
    }

    private void getStringFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(absolutePath));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            this.jsonString = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    public ArrayList<FurnitureInfo> getFurnitureInfos() {
        return furnitureInfos;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public String getName() {
        return name;
    }
}
