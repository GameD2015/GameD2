/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author Karen
 */
public class SpelItem extends JComponent {

    protected Image image;
    protected boolean isPickable = false;
    protected Vakje pad;
    protected Speler speler;
  
    

    public SpelItem() {
    }

    public void voerActie() {
        
    }

    public void voerActie(int d) {
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    public Vakje getPad() {
        return pad;
    }
    
    

    public void setPad(Vakje pad) {
        this.pad = pad;
    }

 
    

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }
}
