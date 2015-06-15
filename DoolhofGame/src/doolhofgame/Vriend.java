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

  private Level level;

    public Vriend() {
        image = new ImageIcon(getClass().getResource("/resources/imgVriend.png")).getImage();

    }

    public Vriend(Level level) {
        image = new ImageIcon(getClass().getResource("/resources/imgVriend.png")).getImage();
        this.level = level;
    }

    @Override
    public void voerActie() {
        super.voerActie();
        actie();

    }

    public void setPad(Pad pad) {
        this.pad = pad;
    }

    private void actie() {
        if (level.getLevelNr() < 4) {
            level.setEndLevel(true);
            level.nextLevel();
        } else {
            level.setEndLevel(true);
        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }
}
