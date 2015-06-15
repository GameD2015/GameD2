/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame;

import org.junit.*;

/**
 *
 * @author Karen
 */
public class BazookaTest {

    public BazookaTest() {
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
     * Test of setPad method, of class Bazooka.
     */
//    @Test
//    public void testSetPad() {
//        System.out.println("setPad");
//        Pad pad = null;
//        Bazooka instance = new Bazooka();
//        instance.setPad(pad);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPad method, of class Bazooka.
//     */
//    @Test
//    public void testGetPad() {
//        System.out.println("getPad");
//        Bazooka instance = new Bazooka();
//        Pad expResult = null;
//        Pad result = instance.getPad();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setSpeler method, of class Bazooka.
//     */
//    @Test
//    public void testSetSpeler() {
//        System.out.println("setSpeler");
//        Speler speler = null;
//        Bazooka instance = new Bazooka();
//        instance.setSpeler(speler);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of voerActie method, of class Bazooka.
     */
    @Test
    public void testVoerActie() {
        System.out.println("voerActie");
        Pad pad = new Pad();
        pad.setNorth(new Muur()); //0
        pad.setEast(new Pad()); //1
        pad.setSouth(new Muur()); //2 
        pad.setWest(new Pad());//3
        Speler speler = new Speler();
        speler.setPad(pad);
        speler.setDir(0); //enumeratie
        int dir = speler.getDir();
        Bazooka instance = new Bazooka();
        instance.setSpeler(speler);
        instance.voerActie(dir);
    }
}
