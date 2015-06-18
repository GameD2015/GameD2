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

/**
 *
 * @author Karen
 */
public class Vijand extends SpelItem implements Runnable {

    private Image imgD;
    private Thread vijand;
    private boolean doorgaan;
    private int delay = 100;

    public Vijand() {
        image = new ImageIcon(getClass().getResource("/resources/vjandDicht.png")).getImage();
        loadImages();
        this.vijand = new Thread(this);
        this.doorgaan = true;
    }

    public Vijand(Doolhof doolhof) {
        image = new ImageIcon(getClass().getResource("/resources/vjandDicht.png")).getImage();
        loadImages();
        this.vijand = new Thread(this);
        this.doorgaan = true;
        this.doolhof = doolhof;
    }

    private void loadImages() {
        imgD = new ImageIcon(getClass().getResource("/resources/vjandD.png")).getImage();
    }

    @Override
    public void setPad(Vakje pad) {
        this.pad = pad;
        pad.setSpelitem(this);
    }

    @Override
    public void voerActie() {
        super.voerActie();


    }

    @Override
    public void setImage(Image image) {
        super.setImage(image);
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
            image = imgD;
            do {
                Backtracking backtracking = new Backtracking();
                if (backtracking.wegVinden(this.pad, null, new Speler()) == true) {
                    backtracking.visitedVakjesWeg(this.pad);
                    Stack<Vakje> weg = backtracking.getVijandWeg();
                    for (Iterator<Vakje> it = weg.iterator(); it.hasNext();) {
                        Vakje vk = it.next();
                        if (vk.getSpelitem() != null) {
                            SpelItem spelitem = vk.getSpelitem();
                            swapPad(this.pad, vk, spelitem);
                        } else {

                            swapPad(this.pad, vk, null);

                        }
                        slaap(delay);
                        if (this.pad.getSpeler() != null) {
                            doorgaan = false;
                            this.doolhof.setSpeler(null);
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
            doolhof.level.setGameOver(true);
        }

    }

    public void begin() {
        try {
            vijand.start();
        } catch (IllegalThreadStateException ie) {

            System.out.println("error methode begin" + ie);
        }
    }

    public void stop() {
        try {
            vijand.interrupt();
            doolhof.level.setGameOver(true);

        } catch (IllegalThreadStateException ie) {
            System.out.println("error methode stop" + ie);
        }
    }
}
