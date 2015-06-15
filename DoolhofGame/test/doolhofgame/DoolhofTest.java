/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import org.junit.*;

/**
 *
 * @author Karen
 */
public class DoolhofTest {
    
    public DoolhofTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of keyPressed method, of class Doolhof.
     */
    @Test
    public void testKeyPressedUp() throws AWTException{
        System.out.println("keyPressedUp");
        Level level = new Level();
        Doolhof instance = new Doolhof(level);
        KeyEvent key = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP,'U');
        instance.keyPressed(key);
        System.out.println(key.getKeyChar());
        System.out.println(key.getKeyCode());
               
    }
    
    @Test
    public void testKeyPressedRight() throws AWTException{
        System.out.println("keyPressedRight");
        Level level = new Level();
        Doolhof instance = new Doolhof(level);
        KeyEvent key = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT,'R');
        instance.keyPressed(key);
        System.out.println(key.getKeyChar());
        System.out.println(key.getKeyCode());
               
    }
    
     @Test
    public void testKeyPressedDown() throws AWTException{
        System.out.println("keyPressedDown");
        Level level = new Level();
        Doolhof instance = new Doolhof(level);
        KeyEvent key = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN,'D');
        instance.keyPressed(key);
        System.out.println(key.getKeyChar());
        System.out.println(key.getKeyCode());
               
    }
     
      @Test
    public void testKeyPressedLeft() throws AWTException{
        System.out.println("keyPressedLeft");
        Level level = new Level();
        Doolhof instance = new Doolhof(level);
        KeyEvent key = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT,'L');
        instance.keyPressed(key);
        System.out.println(key.getKeyChar());
        System.out.println(key.getKeyCode());
               
    }
}
