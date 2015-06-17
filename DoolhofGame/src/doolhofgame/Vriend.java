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
public class Vriend extends SpelItem {



    public Vriend() {
        image = new ImageIcon(getClass().getResource("/resources/imgVriend.png")).getImage();

    }

    public Vriend(Doolhof doolhof) {
        image = new ImageIcon(getClass().getResource("/resources/imgVriend.png")).getImage();
        this.doolhof = doolhof;
    }

    @Override
    public void voerActie() {
        super.voerActie();
        actie();

    }

 
    private void actie() {
        if (doolhof.level.getLevelNr() < 4) {
            doolhof.level.setEndLevel(true);
            doolhof.level.nextLevel();
        } else {
            doolhof.level.setEndLevel(true);
        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }
}
