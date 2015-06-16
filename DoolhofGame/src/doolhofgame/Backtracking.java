/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.ImageIcon;

/**
 *
 * @author Karen
 */
public class Backtracking {
    
    private ArrayList<Vakje> popVakjes;
    private Stack<Vakje> weg;
    
    public Backtracking() {
        popVakjes = new ArrayList<>();
        weg = new Stack<>();
    }
    
    public boolean wegVinden(Vakje vakje, Vriend vriend, Speler speler) { // vakje is de pad waar de zoektoch gaat beginnen
        boolean gevonden = false;
        
        weg.add(vakje);
        if (vriend != null) {
            SpelItem spelitem = vakje.getSpelitem();
            vakje.isVisited = true;
            if (spelitem instanceof Vriend) {
                gevonden = true;
                return gevonden;
                
            }
        } else if (speler != null) {
            vakje.isVisited = true;
            if (vakje.getSpeler() != null) {
                gevonden = true;
                return gevonden;
                
            }
        }
        
        if (vakje.getSouth() != null) {
            if ((vakje.getSouth().isWalkable) && (!vakje.getSouth().isVisited)) {
                gevonden = wegVinden(vakje.getSouth(), vriend, speler);
                if (gevonden == false) {
                    Vakje pop = weg.pop();
                    popVakjes.add(pop);
                } else {
                    return gevonden;
                }
            }
        }
        if (vakje.getEast() != null) {
            if ((vakje.getEast().isWalkable) && (!vakje.getEast().isVisited)) {
                gevonden = wegVinden(vakje.getEast(), vriend, speler);
                if (gevonden == false) {
                    Vakje pop = weg.pop();
                    popVakjes.add(pop);
                } else {
                    return gevonden;
                }
            }
        }
        if (vakje.getNorth() != null) {
            if ((vakje.getNorth().isWalkable) && (!vakje.getNorth().isVisited)) {
                gevonden = wegVinden(vakje.getNorth(), vriend, speler);
                if (gevonden == false) {
                    Vakje pop = weg.pop();
                    popVakjes.add(pop);
                } else {
                    return gevonden;
                }
            }
        }
        if (vakje.getWest() != null) {
            if ((vakje.getWest().isWalkable) && (!vakje.getWest().isVisited)) {
                gevonden = wegVinden(vakje.getWest(), vriend, speler);
                if (gevonden == false) {
                    Vakje pop = weg.pop();
                    popVakjes.add(pop);
                } else {
                    return gevonden;
                }
            }
        }
        return gevonden;
    }
    
    
    
    public void visitedVakjesWeg(Vakje vakje) {
        if (vakje.getNorth() != null) {
            if ((vakje.getNorth().isVisited)) {
                vakje.setIsVisited(false);
                visitedVakjesWeg(vakje.getNorth());
            }
        }
        if (vakje.getEast() != null) {
            if ((vakje.getEast().isVisited)) {
                vakje.setIsVisited(false);
                visitedVakjesWeg(vakje.getEast());
            }
        }
        if (vakje.getSouth() != null) {
            if ((vakje.getSouth().isVisited)) {
                vakje.setIsVisited(false);
                visitedVakjesWeg(vakje.getSouth());
            }
        }
        if (vakje.getWest() != null) {
            if ((vakje.getWest().isVisited)) {
                vakje.setIsVisited(false);
                visitedVakjesWeg(vakje.getWest());
            }
        }
        
    }
    
    public Stack<Vakje> getWeg() {
        return weg;
        
    }
    
    public ArrayList<Vakje> getListWeg() {
      
        ArrayList<Vakje> listWeg = null;
        if (!weg.empty()) {
            listWeg = new ArrayList<>();
            for (Iterator<Vakje> it = weg.iterator(); it.hasNext();) {
                Vakje vk = it.next();
                listWeg.add(vk);
                
            }
        }
        return listWeg;
    }
//    
}
