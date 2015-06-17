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
public class Helper extends SpelItem {

    public Helper() {
        image = new ImageIcon(getClass().getResource("/resources/imgHelp2.png")).getImage();
    }

    @Override
    public void voerActie() {
        super.voerActie();
        actie();
    }

    public void actie() {
        
        Backtracking backtracking = new Backtracking();
        boolean gevonden = backtracking.wegVinden(this.pad, new Vriend(), null);
        
        if (gevonden == true) {
            Stack<Vakje> weg = backtracking.getHelperWeg();
            backtracking.visitedVakjesWeg(this.pad);
            printWeg(weg);
            
        }
        
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    private void printWeg(Stack<Vakje> weg) {

        Image imageWeg = new ImageIcon(getClass().getResource("/resources/pad2.png")).getImage();
        
        for (Iterator<Vakje> it = weg.iterator(); it.hasNext();) {
            Vakje vk = it.next();
            if (vk.getSpelitem() == null) {
                SpelItem spelItem = new SpelItem();
                spelItem.image = imageWeg;
                vk.setSpelitem(spelItem);
                vk.repaint();
            }
        }

    }
    public void setPad(Pad pad) {
        this.pad = pad;
    }

    public Vakje getPad() {
        return pad;
    }
}
