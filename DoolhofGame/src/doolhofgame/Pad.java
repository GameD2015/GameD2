/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Karen
 */
public class Pad extends Vakje {

    public Pad() {
        image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
        isWalkable = true;
        isVisited = false;
    }

    public Pad(SpelItem spelitem) {
        this.spelitem = spelitem;
        isWalkable = true;
        if (spelitem != null) {
            image = spelitem.image;
        } else {
            image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
        }
    }

    public void setSpelitem(SpelItem spelitem) {
        this.spelitem = spelitem;
        if (spelitem != null) {
            image = spelitem.image;
        } else {
            image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
        }
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
        if (speler != null) {
            image = speler.getImage();
        } else {
            image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, posX, posY, this);
        if (speler != null) {
            speler.repaint();
        }
        if (spelitem != null) {
            spelitem.repaint();
        }
    }
}
