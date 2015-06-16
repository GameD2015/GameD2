/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.ImageIcon;

/**
 *
 * @author Karen
 */
public class Vijand extends SpelItem implements Runnable {

    private int positieX, positieY;
    private Image imgR, imgL, imgU, imgD;
    private int dir;// 0:up 1:right 2:down 3:left
    private Thread vijand;
    private boolean doorgaan;
    private Doolhof doolhof;

    public Vijand() {
        image = new ImageIcon(getClass().getResource("/resources/vjandR.png")).getImage();
        loadImages();
        this.vijand = new Thread(this);
        this.doorgaan = true;
    }

    public Vijand(Doolhof doolhof) {
        image = new ImageIcon(getClass().getResource("/resources/vjandR.png")).getImage();
        loadImages();
        this.vijand = new Thread(this);
        this.doorgaan = true;
        this.doolhof = doolhof;
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

    public int getDir() {
        return getDir();
    }

    @Override
    public void setImage(Image image) {
        super.setImage(image);
    }

    public void setDir(int dir) {
        this.dir = dir;
        if (dir == 1) {
            setImage(imgR);
        }
        if (dir == 3) {
            setImage(imgL);
        }
        if (dir == 0) {
            setImage(imgU);
        }
        if (dir == 2) {
            setImage(imgD);
        }
    }

    public void kijkBuur(Vakje first, Vakje next) {
        if (next == first.getNorth()) {
            setDir(0);
        } else if (next == first.getEast()) {
            setDir(1);
        } else if (next == first.getSouth()) {
            setDir(2);
        } else if (next == first.getWest()) {
            setDir(3);
        }
    }

    private void swapPad(Vakje from, Vakje to, SpelItem sp) {

        to.repaint();
        setPad(to);
        from.setSpelitem(sp);
        from.repaint();
        to.repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void run() {

        try {
            do {
                Backtracking backtracking = new Backtracking();
                if (backtracking.wegVinden(this.pad, null, new Speler()) == true) {
                    backtracking.visitedVakjesWeg(this.pad);
                    Stack<Vakje> weg = backtracking.getWeg();
                    for (Iterator<Vakje> it = weg.iterator(); it.hasNext();) {
                        Vakje vk = it.next();
                        if (vk.getSpelitem() != null) {
                            SpelItem spelitem = vk.getSpelitem();
                            swapPad(this.pad, vk, spelitem);
                        } else {
                            swapPad(this.pad, vk, null);
                        }
                        slaap(100);
                        if (this.pad.getSpeler() != null) {
                            doorgaan = false;
                            doolhof.level.setGameOver(true);
                        }
                        
                    }
                }
            } while (doorgaan);
        } catch (IllegalThreadStateException ex) {
            System.out.println("error " + ex);
        }
    }

    public void slaap(int millisec) {
        try {
            Thread.sleep(millisec);

        } catch (InterruptedException ex) {
            System.out.println("error methode slaap" + ex);
        }

    }

    public void begin() {
        vijand.start();
    }
}
