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
public class Vijand extends SpelItem {

    private int positieX, positieY;
    private Image image, imgR, imgL, imgU, imgD;
    private Vakje pad;
    private int dir;// 0:up 1:right 2:down 3:left

    public Vijand(Image image) {
        image = new ImageIcon(getClass().getResource("/resources/imgR.png")).getImage();
        loadImages();
    }

    private void loadImages() {

        imgR = new ImageIcon(getClass().getResource("/resources/imgR.png")).getImage();
        imgL = new ImageIcon(getClass().getResource("/resources/imgL.png")).getImage();
        imgU = new ImageIcon(getClass().getResource("/resources/imgU.png")).getImage();
        imgD = new ImageIcon(getClass().getResource("/resources/imgD.png")).getImage();
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
        Vakje buur = pad.getEast();
        if (d == 0) {
            buur = pad.getNorth();
            setDir(0);
        } else {
            if (d == 1) {
                buur = pad.getEast();
                setDir(1);
            } else {
                if (d == 2) {
                    buur = pad.getSouth();
                    setDir(2);
                } else {
                    if (d == 3) {
                        buur = pad.getWest();
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
    
    

    public void move(int d) {
        //move(d);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
