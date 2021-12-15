package school;

import de.raumplaner.InstanceJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.*;

public class Leinwand {

    private static Leinwand leinwandSingleton;

    private final JFrame fenster;
    private final Zeichenflaeche zeichenflaeche;
    private Graphics2D graphic;
    private final Color hintergrundfarbe;
    private Image leinwandImage;
    private final List figuren;
    private final Map figurZuShape; // Abbildung von Figuren zu Shapes

    public static Leinwand getInstance() {
        if (leinwandSingleton == null) {
            leinwandSingleton = new Leinwand("Möbelprojekt Grafik", 700, 700, Color.white);
            leinwandSingleton.setzeSichtbarkeit(true);
        }
        return leinwandSingleton;
    }

    private Leinwand(String titel, int breite, int hoehe, Color grundfarbe) {
        fenster = new JFrame();
        fenster.addKeyListener(new MyKeyAdapter());
        zeichenflaeche = new Zeichenflaeche();
        fenster.setContentPane(zeichenflaeche);
        fenster.setTitle(titel);
        zeichenflaeche.setPreferredSize(new Dimension(breite, hoehe));
        hintergrundfarbe = grundfarbe;
        fenster.pack();
        figuren = new ArrayList();
        figurZuShape = new HashMap();

    }

    public void setzeSichtbarkeit(boolean sichtbar) {
        if (graphic == null) {
            Dimension size = zeichenflaeche.getSize();
            leinwandImage = zeichenflaeche.createImage(size.width, size.height);
            graphic = (Graphics2D) leinwandImage.getGraphics();
            graphic.setColor(hintergrundfarbe);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        fenster.setVisible(sichtbar);
    }

    public void zeichne(Object figur, String farbe, Shape shape) {
        figuren.remove(figur); // entfernen, falls schon eingetragen
        figuren.add(figur); // am Ende hinzuf�gen
        figurZuShape.put(figur, new ShapeMitFarbe(shape, farbe));
        erneutZeichnen();
    }
    public void test(){
        for(int i = 0; i < 200;i+= 10){
            System.out.println(i);

        }
    }

    public void entferne(Object figur) {
        figuren.remove(figur); // entfernen,falls schon eingetragen
        figurZuShape.remove(figur);
        erneutZeichnen();
    }

    public void setzeZeichenfarbe(String farbname) {
        switch (farbname) {
            case "rot" -> graphic.setColor(Color.red);
            case "blau" -> graphic.setColor(Color.blue);
            case "gelb" -> graphic.setColor(Color.yellow);
            case "gruen" -> graphic.setColor(Color.green);
            case "lila", "magenta" -> graphic.setColor(Color.magenta);
            case "weiss" -> graphic.setColor(Color.white);
            case "cyan" -> graphic.setColor(Color.cyan);
            default -> graphic.setColor(Color.black);
        }
    }

    public void warte(int millisekunden) {
        try {
            Thread.sleep(millisekunden);
        } catch (Exception e) {
        }
    }

    private void erneutZeichnen() {
        loeschen();
        for (Iterator i = figuren.iterator(); i.hasNext(); ) {
            ((ShapeMitFarbe) figurZuShape.get(i.next())).draw(graphic);
        }
        zeichenflaeche.repaint();
    }

    private void loeschen() {
        Color original = graphic.getColor();
        graphic.setColor(hintergrundfarbe);
        Dimension size = zeichenflaeche.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }

    private class Zeichenflaeche extends JPanel {
        public Zeichenflaeche() {

        }

        public void paint(Graphics g) {
            g.drawImage(leinwandImage, 0, 0, null);
        }
    }

    private class ShapeMitFarbe {
        private final Shape shape;
        private final String farbe;

        public ShapeMitFarbe(Shape shape, String farbe) {
            this.shape = shape;
            this.farbe = farbe;
        }

        public void draw(Graphics2D graphic) {
            setzeZeichenfarbe(farbe);
            graphic.draw(shape);
        }
    }
    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> ((Furniture) figuren.get(0)).updatexPosition(-10);
                case KeyEvent.VK_RIGHT -> ((Furniture) figuren.get(0)).updatexPosition(10);
                case KeyEvent.VK_UP -> ((Furniture) figuren.get(0)).updateyPosition(-10);
                case KeyEvent.VK_DOWN -> ((Furniture) figuren.get(0)).updateyPosition(10);
                default -> System.out.println();
            }
            int xcord = 500;
            int ycord = 500;
            if(((Furniture) figuren.get(0)).getxPosition() < xcord && ((Furniture) figuren.get(0)).getyPosition() == 0){
                ((Furniture) figuren.get(0)).updatexPosition(10);
            }
            if(((Furniture) figuren.get(0)).getxPosition() == xcord && ((Furniture) figuren.get(0)).getyPosition() < ycord){
                ((Furniture) figuren.get(0)).updateyPosition(10);
            }
            if(((Furniture) figuren.get(0)).getxPosition() == xcord && ((Furniture) figuren.get(0)).getyPosition() == ycord){
                ((Furniture) figuren.get(0)).setxPosition(200);
                ((Furniture) figuren.get(0)).setyPosition(200);
            }


            ((Furniture) figuren.get(0)).changecolor();
            ((Furniture) figuren.get(0)).rotate(10);
            ((Furniture) figuren.get(0)).zeichne();
            erneutZeichnen();
        }
    }
}
