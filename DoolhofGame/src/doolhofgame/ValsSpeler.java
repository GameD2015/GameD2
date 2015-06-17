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
public class ValsSpeler extends SpelItem {

 

    public ValsSpeler() {
        image = new ImageIcon(getClass().getResource("/resources/clockY.png")).getImage();

    }

    public ValsSpeler(Doolhof doolhof) {
        this.doolhof = doolhof;
        image = new ImageIcon(getClass().getResource("/resources/clockY.png")).getImage();

    }

    @Override
    public void voerActie() {
        super.voerActie();
        actie();
    }

    private void actie() {
        doolhof.level.timer.addTime(20);
        doolhof.level.timer.repaint();
        
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }
}
