/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Karen
 */
public class Speler extends JComponent {

    private int positieX, positieY;
    private Image image, imgR, imgL, imgU, imgD;
    private Vakje pad;
    private int dir;// 0:up 1:right 2:down 3:left
    private SpelItem gepakt = null;

    public Speler() {

        image = new ImageIcon(getClass().getResource("/resources/imgR.png")).getImage();
        loadImages();
    }

    public void setPad(Vakje pad) {
        this.pad = pad;
        pad.setSpeler(this);
    }

    public Vakje getPad() {
        return pad;
    }

    public void setGepakt(SpelItem bazooka) {
        this.gepakt = bazooka;
        if (gepakt != null) {
            gepakt.setSpeler(this);
        }

    }

    public SpelItem getGepakt() {
        return gepakt;
    }

//
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }

    public void schietMuur(int dir) {
        if (gepakt != null) {
            gepakt.voerActie(dir);
            setGepakt(null);
        } else {
            JOptionPane.showMessageDialog(null,
                    "U hebt geen bazooka!",
                    "Melding",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void move(int d) {
        Vakje buur = getBuur(d);
        if (canMove(buur)) {
            if (buur.getSpelitem() != null) {
                if (!(buur.getSpelitem() instanceof Vijand)) {
                    raakSpelItem(buur);
                    swapPad(pad, buur);
                }
            } else {
                swapPad(pad, buur);
            }

        }

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

    private void raakSpelItem(Vakje pad) {

        if (pad.getSpelitem().isPickable == true) {
            setGepakt((Bazooka) pad.getSpelitem());
            pad.setSpelitem(null);
        } else {
            pad.getSpelitem().voerActie();
            pad.setSpelitem(null);
        }
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

    private void loadImages() {

        imgR = new ImageIcon(getClass().getResource("/resources/imgR.png")).getImage();
        imgL = new ImageIcon(getClass().getResource("/resources/imgL.png")).getImage();
        imgU = new ImageIcon(getClass().getResource("/resources/imgU.png")).getImage();
        imgD = new ImageIcon(getClass().getResource("/resources/imgD.png")).getImage();
    }

    private void swapPad(Vakje from, Vakje to) {

        to.repaint();
        setPad(to);
        from.setSpeler(null);
        from.repaint();
        to.repaint();
    }

    public int getDir() {
        return dir;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getPositieX() {
        return positieX;
    }

    public void setPositieX(int positieX) {
        this.positieX = positieX;
    }

    public int getPositieY() {
        return positieY;
    }

    public void setPositieY(int positieY) {
        this.positieY = positieY;
    }
}
