package de.raumplaner;

import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class Furniture {
    protected Graphics2D g2d;
    private int x;
    private int y;
    protected int width;
    protected int height;
    private int rotation;
    private boolean visible;
    private String color;
    private boolean drawOutline;
    private boolean active;

    public Furniture(int x, int y, int width, int height, int rotation, String color, boolean visible) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
        this.visible = visible;
        this.color = color;
        this.drawOutline = false;
    }

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveX(int x){
        this.x += x;
        if(collision()){
            this.x -= x;
        }
    }

    public void moveY(int y){
        this.y += y;
        if(collision()){
            this.y -= y;
        }

    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
        if(collision()){
            this.x -= x;
            this.y -= y;
        }
    }

    private boolean collision(){
        Furniture object;
        for(int i = 0; i < InstanceJPanel.getInstance().objects.size(); i++){
            if(i != InstanceJPanel.getInstance().activeObject){
                object = InstanceJPanel.getInstance().objects.get(i);
                if(intersectsRect(object.getX(), object.getY(), object.getWidth(),object.getHeight())){
                    return true;
                }
            }
        }
        return false;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public void updateRotation(int rotation){
        this.rotation += rotation;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDrawOutline(boolean drawOutline) {
        this.drawOutline = drawOutline;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public boolean isDrawOutline() {
        return drawOutline;
    }

    public boolean isActive() {
        return active;
    }

    public String getColorString(){
        return color;
    }

    public void draw(Graphics g){
        this.g2d = (Graphics2D) g;
        transform(g2d);
    }

    public Graphics2D transform(Graphics2D g2d){
        if(visible){
            AffineTransform old = g2d.getTransform();
            g2d.translate(this.x,this.y);
            g2d.rotate(Math.toRadians(rotation), getX() + getWidth() / 2, getY() + getHeight() / 2);
            if(active){
                g2d.setColor(Color.red);
            }else{
                g2d.setColor(getColor());
            }
            getModel(g2d);
            if(drawOutline){
                drawOutline();
            }
            g2d.setTransform(old);
        }
        return g2d;
    }

    private void drawOutline(){
        g2d.setColor(Color.white);
        g2d.drawLine(0,0, width, 0);
        g2d.drawLine(0,0, 0, height);
        g2d.drawLine(width,height, width, 0);
        g2d.drawLine(width,height, 0, height);
    }

    private Color getColor(){
        return switch (color) {
            case "back" -> Color.black;
            case "red" -> Color.red;
            case "blue" -> Color.blue;
            case "yellow" -> Color.yellow;
            case "green" -> Color.green;
            case "magenta" -> Color.magenta;
            case "white" -> Color.white;
            case "gray" -> Color.gray;
            case "cyan" -> Color.cyan;
            case "darkGray" -> Color.darkGray;
            case "lightGray" -> Color.lightGray;
            case "orange" -> Color.orange;
            case "pink" -> Color.pink;
            default -> throw new IllegalArgumentException("color doesnt exist");
        };
    }

    public boolean intersectsRect(int x,int y,int width, int height) {
        int tw = this.width;
        int th = this.height;
        int rw = width;
        int rh = height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.x;
        int ty = this.y;
        int rx = x;
        int ry = y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;

        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry) ||
                (tx < 0 || ty < 0 || tw > InstanceJPanel.SCREEN_WIDTH || th > InstanceJPanel.SCREEN_HEIGHT));
    }

    protected abstract Graphics2D getModel(Graphics2D g2d);

    //TODO:Durchschnitt
}
