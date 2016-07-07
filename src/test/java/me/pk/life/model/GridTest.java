package me.pk.life.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by prasad on 07/07/2016.
 */
public class GridTest {

    @Test
    public void testRule1() throws Exception {
        // Given
        Grid grid = new Grid(3,3);
        grid.setLive(1,1);
        grid.setLive(0,0);
        grid.print();
        // 1,0,0
        // 0,1,0
        // 0,0,0

        // When
        Grid nextGen = grid.nextGen();
        grid.print();

        assertFalse("grid 0,0 should be false", nextGen.cells(0,0));
        assertTrue("grid 0,1 should be true", nextGen.cells(0,1));
        assertFalse("grid 0,2 should be false", nextGen.cells(0,2));
        assertTrue("grid 1,0 should be true", nextGen.cells(1,0));
        assertFalse("grid 1,1 should be false", nextGen.cells(1,1));
        assertFalse("grid 1,2 should be false", nextGen.cells(1,2));
        assertFalse("grid 2,0 should be false", nextGen.cells(2,0));
        assertFalse("grid 2,1 should be false", nextGen.cells(2,1));
        assertFalse("grid 2,2 should be false", nextGen.cells(2,2));
    }

    @Test
    public void testBlock() throws Exception {
        // Given
        Grid grid = new Grid(4,4);
        grid.setLive(1,1);
        grid.setLive(1,2);
        grid.setLive(2,1);
        grid.setLive(2,2);
        grid.print();
        System.out.println("setup done");
        // 0,0,0,0
        // 0,1,1,0
        // 0,1,1,0
        // 0,0,0,0

        // When
        Grid nextGen = grid.nextGen();
        nextGen.print();

        //first row
        assertFalse("grid 0,0 should be false", nextGen.cells(0,0));
        assertFalse("grid 0,1 should be false", nextGen.cells(0,1));
        assertFalse("grid 0,2 should be false", nextGen.cells(0,2));
        assertFalse("grid 0,3 should be false", nextGen.cells(0,3));

        //second row
        assertFalse("grid 1,0 should be false", nextGen.cells(1,0));
        assertTrue("grid 1,1 should be true", nextGen.cells(1,1));
        assertTrue("grid 1,2 should be true", nextGen.cells(1,2));
        assertFalse("grid 1,3 should be false", nextGen.cells(1,3));

        //third row
        assertFalse("grid 2,0 should be false", nextGen.cells(2,0));
        assertTrue("grid 2,1 should be true", nextGen.cells(2,1));
        assertTrue("grid 2,2 should be true", nextGen.cells(2,2));
        assertFalse("grid 2,3 should be false", nextGen.cells(2,3));

        //fourth row
        assertFalse("grid 3,0 should be false", nextGen.cells(3,0));
        assertFalse("grid 3,1 should be false", nextGen.cells(3,1));
        assertFalse("grid 3,2 should be false", nextGen.cells(3,2));
        assertFalse("grid 3,3 should be false", nextGen.cells(3,3));
    }

    @Test
    public void testBlinker() throws Exception {
        // Given
        Grid grid = new Grid(5,5);
        grid.setLive(2,1);
        grid.setLive(2,2);
        grid.setLive(2,3);
        grid.print();
        System.out.println("setup done");
        // 0,0,0,0
        // 0,1,1,0
        // 0,1,1,0
        // 0,0,0,0

        // When
        Grid nextGen = grid.nextGen();
        nextGen.print();

        //Expected
        Grid expected = new Grid(5,5);
        grid.setLive(1,2);
        grid.setLive(2,2);
        grid.setLive(3,2);

        assertEquals("the two should be equal", expected, nextGen);
    }
}