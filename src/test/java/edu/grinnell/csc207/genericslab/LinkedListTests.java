/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.genericslab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ganellio
 */
public class LinkedListTests {
    @Test
    public void emptyListTest() {
        LinkedList<String> l = new LinkedList<String>();
        assertEquals(0, l.size());
    }

    @Test
    public void listAddSize10NumsAsStrings() {
        LinkedList<String> l = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            l.add(Integer.toString(i));
        }
        assertEquals(10, l.size());
    }

    @Test
    public void listGetOOB() {
        LinkedList<String> l = new LinkedList<String>();
        l.add("hello!");
        l.add("goodbye!");
        l.add("huh?");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(3);
        });
    }

    @Test
    public void listRemoveSome() {
        LinkedList<String> l = new LinkedList<String>();
        l.add("!");
        l.add("@");
        l.add(".");
        l.add("#");
        l.add("&");

        // @ #
        
        assertEquals(".", l.remove(2));
        assertEquals("@", l.get(1));
        assertEquals("#", l.get(2));
        
        assertEquals("!", l.remove(0));
        assertEquals("@", l.get(0));

        assertEquals("&", l.remove(2));
        assertEquals("#", l.get(1));
    }

    @Test
    public void listRemoveOOB() {
        LinkedList<String> l = new LinkedList<String>();
        l.add("A");
        l.add("B");
        l.add("C");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(3);
        });
    }
    
    @Test
    public void insertstuff(){
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(1);
        l.add(4);
        l.add(3);
        l.add(2);
        
        l.insertionSortalt();
        //l.printlst();
        assertEquals(1, l.get(0));
        assertEquals(2, l.get(1));
        assertEquals(3, l.get(2));
        assertEquals(4, l.get(3));
        assertEquals(5, l.get(4));
        
        
    }
}
