 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame;


import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Karen
 */
public class Main extends JFrame {

    private Level level;

    public Main() {
        setTitle("Dolhoof Game");
        setSize(900, 700);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(Color.BLACK);
        setLocationRelativeTo(null);


    }

    public void init() {


        level = new Level();
        level.addKeyListener(level);
        level.setFocusable(true);
        level.requestFocus(true);
        add(level);
        setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main principaal = new Main();
        principaal.init();
    }
}
