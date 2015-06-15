/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Karen
 */
public class Vakje extends JComponent {

    protected Image image;
    public Vakje[] buren = new Vakje[4];
    //north 0, east 1, south 2, west 3
    protected int posX, posY;
    protected boolean isWalkable;
    protected SpelItem spelitem = null;
    protected Speler speler;
    protected boolean isVisited;

    public Vakje() {
    }

    public void setIsWalkable(boolean isWalkable) {
        this.isWalkable = isWalkable;
    }

    public Vakje(SpelItem spelitem) {
        this.spelitem = spelitem;
    }

    public void setSpelitem(SpelItem spelitem) {
        this.spelitem = spelitem;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    
    

    public SpelItem getSpelitem() {
        return spelitem;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Vakje getNorth() {
        return buren[0];
    }

    public Vakje getEast() {
        return buren[1];
    }

    public Vakje getSouth() {
        return buren[2];
    }

    public Vakje getWest() {
        return buren[3];
    }

    public void setNorth(Vakje buur) {
        this.buren[0] = buur;
    }

    public void setEast(Vakje buur) {
        this.buren[1] = buur;
    }

    public void setSouth(Vakje buur) {
        this.buren[2] = buur;
    }

    public void setWest(Vakje buur) {
        this.buren[3] = buur;
    }
}
