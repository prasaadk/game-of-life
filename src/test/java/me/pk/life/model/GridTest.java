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
        Grid grid = new Grid(3, 3);
        grid.setLive(1, 1);
        grid.setLive(0, 0);
        grid.print();
        // 1,0,0
        // 0,1,0
        // 0,0,0

        // When
        Grid nextGen = grid.nextGen();
        grid.print();

        // Then

        Grid expected = new Grid(3, 3);

        System.out.println("expected");
        expected.print();

        System.out.println("actual");
        nextGen.print();

        assertEquals("the two should be equal", expected, nextGen);
    }

    @Test
    public void testRule3() throws Exception {
        // Given
        Grid grid = new Grid(3, 3);
        grid.setLive(0, 0);
        grid.setLive(1, 1);
        grid.setLive(0, 0);
        grid.print();
        // 1,0,0
        // 0,1,0
        // 0,0,1

        // When
        Grid nextGen = grid.nextGen();
        grid.print();

        // Then

        Grid expected = new Grid(3, 3);

        System.out.println("expected");
        expected.print();

        System.out.println("actual");
        nextGen.print();

        assertEquals("the two should be equal", expected, nextGen);
    }


    @Test
    public void testBlock() throws Exception {
        // Given
        Grid grid = new Grid(4, 4);
        grid.setLive(1, 1);
        grid.setLive(1, 2);
        grid.setLive(2, 1);
        grid.setLive(2, 2);
        grid.print();
        System.out.println("setup done");
//        0 0 0 0
//        0 1 1 0
//        0 1 1 0
//        0 0 0 0

        // When
        Grid nextGen = grid.nextGen();
        nextGen.print();

        // Then

        Grid expected = new Grid(4, 4);
        expected.setLive(1, 1);
        expected.setLive(1, 2);
        expected.setLive(2, 1);
        expected.setLive(2, 2);

        System.out.println("expected");
        expected.print();

        System.out.println("actual");
        nextGen.print();

        assertEquals("the two should be equal", expected, nextGen);
    }

    @Test
    public void testBlinker() throws Exception {
        // Given
        Grid grid = new Grid(5, 5);
        grid.setLive(2, 1);
        grid.setLive(2, 2);
        grid.setLive(2, 3);
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
        Grid expected = new Grid(5, 5);
        expected.setLive(1, 2);
        expected.setLive(2, 2);
        expected.setLive(3, 2);
        System.out.println("expected");
        expected.print();

        System.out.println("actual");
        nextGen.print();

        assertEquals("the two should be equal", expected, nextGen);
    }
}