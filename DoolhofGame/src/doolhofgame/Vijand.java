/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Karen
 */
public class Vijand extends SpelItem {

    private int positieX, positieY;
    private Image imgR, imgL, imgU, imgD;
    private int dir;// 0:up 1:right 2:down 3:left

    public Vijand() {
        image = new ImageIcon(getClass().getResource("/resources/vjandR.png")).getImage();
        loadImages();

    }

    private void loadImages() {

        imgR = new ImageIcon(getClass().getResource("/resources/vjandR.png")).getImage();
        imgL = new ImageIcon(getClass().getResource("/resources/vjandL.png")).getImage();
        imgU = new ImageIcon(getClass().getResource("/resources/vjandU.png")).getImage();
        imgD = new ImageIcon(getClass().getResource("/resources/vjandD.png")).getImage();
    }

    @Override
    public void setPad(Vakje pad) {
        this.pad = pad;
        pad.setSpelitem(this);
    }

    public boolean canMove(Vakje buur) {
        boolean result = false;
        if (buur == null) {
            result = false;
        } else {
            if (buur.isWalkable) {
                result = true;
            }
        }

        return result;
    }

    private Vakje getBuur(int d) {
        Vakje buur = this.pad.getEast();
        if (d == 0) {
            buur = this.pad.getNorth();
            setDir(0);
        } else {
            if (d == 1) {
                buur = this.pad.getEast();
                setDir(1);
            } else {
                if (d == 2) {
                    buur = this.pad.getSouth();
                    setDir(2);
                } else {
                    if (d == 3) {
                        buur = this.pad.getWest();
                        setDir(3);
                    }
                }
            }
        }
        return buur;
    }

    public int getDir() {
        return getDir();
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public void move() {
        Backtracking backtracking = new Backtracking();
        boolean gevonden = backtracking.wegVinden(this.pad, null, new Speler());
        backtracking.visitedVakjesWeg(this.pad);
        if (gevonden == true) {
            Stack<Vakje> weg = backtracking.getWeg();
           
            for (Iterator<Vakje> it = weg.iterator(); it.hasNext();) {
                Vakje vk = it.next();
                if (vk.getSpelitem() == null) {
                    vk.setSpelitem(this);
                    vk.repaint();
                    
                    //swapPad(this.pad, vk);
                }
            }
            
        }
    }

    private void swapPad(Vakje from, Vakje to) {

        to.repaint();
        setPad(to);
        from.setSpeler(null);
        from.repaint();
        to.repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
