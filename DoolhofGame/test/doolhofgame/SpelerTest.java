/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Karen
 */
public class SpelerTest {
    
    public SpelerTest() {
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
     * Test of canMove method, of class Speler.
     */
    @Test
    public void testCanMove() {
        System.out.println("canMove");
        Vakje buur = new Muur();
        Speler instance = new Speler();
        boolean expResult = false;
        boolean result = instance.canMove(buur);
        assertEquals(expResult, result);
        if(!buur.isWalkable){
            System.out.println("Buur is not walkable");
        }
        
    }
    
    @Test
    public void testCanMove2() {
        System.out.println("canMove");
        Vakje buur = new Pad();
        Speler instance = new Speler();
        boolean expResult = true;
        boolean result = instance.canMove(buur);
        assertEquals(expResult, result);
        if(buur.isWalkable){
            System.out.println("Buur is walkable");
        }
        
    }

    
}
