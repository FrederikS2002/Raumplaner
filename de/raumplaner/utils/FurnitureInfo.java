package de.raumplaner.utils;

public class FurnitureInfo {
    private final String type;
    private int x;
    private int y;
    private final int width;
    private final int height;
    private final int rotation;
    private final boolean visible;
    private final String color;

    public FurnitureInfo(String type, int x, int y, int width, int height, int rotation, boolean visible, String color) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
        this.visible = visible;
        this.color = color;
    }
    public FurnitureInfo(String type, int width, int height, int rotation, boolean visible, String color) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
        this.visible = visible;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getRotation() {
        return rotation;
    }

    public boolean isVisible() {
        return visible;
    }

    public String getColor() {
        return color;
    }
}
