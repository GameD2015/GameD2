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
public class Bazooka extends SpelItem {

    public Bazooka() {
        image = new ImageIcon(getClass().getResource("/resources/imgBaz.png")).getImage();
        isPickable = true;

    }

    public void setPad(Pad pad) {
        this.pad = pad;
    }

    public Pad getPad() {
        return pad;
    }

    @Override
    public void setSpeler(Speler speler) {
        super.setSpeler(speler);
    }

    public void voerActie(int dir) {

        if (dir == 0) {
            Vakje north = speler.getPad().getNorth();
            int muur = 0;
            do {
                if (north instanceof Muur) {
                    north.setIsWalkable(true);
                    muur = 1;
                } else {
                    north = north.getNorth();
                }
            } while (muur == 0);

        } else {
            if (dir == 1) {
                Vakje east = speler.getPad().getEast();
                int muur = 0;
                do {
                    if (east instanceof Muur) {
                        east.setIsWalkable(true);
                        muur = 1;
                    } else {
                        east = east.getEast();
                    }
                } while (muur == 0);
            } else {
                if (dir == 2) {
                    Vakje south = speler.getPad().getSouth();
                    int muur = 0;
                    do {
                        if (south instanceof Muur) {
                            south.setIsWalkable(true);
                            muur = 1;
                        } else {
                            south = south.getSouth();
                        }
                    } while (muur == 0);
                } else {
                    if (dir == 3) {
                        Vakje west = speler.getPad().getWest();
                        int muur = 0;
                        do {
                            if (west instanceof Muur) {
                                west.setIsWalkable(true);
                                muur = 1;
                            } else {
                                west = west.getSouth();
                            }
                        } while (muur == 0);
                    }
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
