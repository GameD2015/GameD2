/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Karen
 */
public class Teller extends JPanel {
    
    private int teller;
    private javax.swing.Timer timer;
    private Level level;

    public Teller(Level level, int sec) {
        this.teller = sec;// aantal seconden
        this.level = level;
        timer = new javax.swing.Timer(1000, new Teller.TimerHandler());
        setBackground(Color.BLACK);
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.setFont(new Font("SansSerif", Font.BOLD, 14));
        g.drawString("Timer: " + teller, 10, 20);

    }

    public int getTeller() {
        return teller;
    }

    public void setTeller(int teller) {
        this.teller = teller;
    }
    
    public void addTime(int teller){
        this.teller += teller;
    }

    class TimerHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (teller > 0) {
                teller--;
                repaint();
            } else {
                if (teller < 1) {
                    stopTimer();
                    level.setGameOver(true);
                }
            }

        }
    }
}
