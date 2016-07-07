package me.pk.life.model;

import java.util.Arrays;

/**
 * This represents a two-dimensional grid
 * <p>
 * Created by prasad on 07/07/2016.
 */
public class Grid {

    /**
     * Datastructure that represents a two dimensional data structure. 'true' cells represent ON values, 'false' represents OFF values.
     */
    boolean[][] cells;
    private int m;
    private int n;

    public Grid(int m, int n) {
        this.m = m;
        this.n = n;
        cells = new boolean[m][n];
    }

    private Grid(boolean[][] cells) {
        this.m = cells.length;
        this.n = cells[0].length;
        this.cells = cells;
    }

    private boolean[][] copy(boolean[][] cells) {
        boolean[][] newGrid = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                newGrid[r][c]=cells[r][c];
            }
        }
        return newGrid;
    }


    public Grid nextGen() {
        Grid nextGrid = new Grid(copy(cells));

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int liveCells = findLiveCells(r, c);
                //System.out.println("live cells around "+r+","+c+": " + liveCells);

                if (cells[r][c]) {
                    // if live cells
                    //System.out.println("cell "+r+","+c+": live");
                    // 1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
                    if (liveCells < 2) nextGrid.setDead(r, c);

                    // 3. Any live cell with more than three live neighbours dies, as if by over-population.
                    if (liveCells > 3) nextGrid.setDead(r, c);

                    // 2. Any live cell with two or three live neighbours lives on to the next generation.
                    // continue - no change
                } else {
                    // if dead cells
                    //System.out.println("cell "+r+","+c+": dead");

                    // 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
                    if (liveCells == 3) nextGrid.setLive(r, c);
                }

            }
        }
        return nextGrid;
    }

    /**
     * Sets the cell at r,c dead
     * @param r
     * @param c
     */
    public void setDead(int r, int c) {
        //System.out.println("trying to set: "+r+","+c+" dead");
        cells[r][c] = false;
    }

    /**
     * Sets the cell at r,c live
     * @param r
     * @param c
     */
    public void setLive(int r, int c) {
        //System.out.println("trying to set: "+r+","+c+" live");
        cells[r][c] = true;
    }

    /**
     * This method returns the population of the neighbouring live and dead cells
     *
     * @param r row number
     * @param c column number
     * @return int returns number of live neighbouring cells
     */
    private int findLiveCells(int r, int c) {
        int count = 0;

        count += cells(r - 1,c - 1) ? 1 : 0;
        count += cells(r - 1,c) ? 1 : 0;
        count += cells(r - 1,c + 1) ? 1 : 0;

        count += cells(r,c - 1) ? 1 : 0;
        count += cells(r,c + 1) ? 1 : 0;

        count += cells(r + 1,c - 1) ? 1 : 0;
        count += cells(r + 1,c) ? 1 : 0;
        count += cells(r + 1,c + 1) ? 1 : 0;

        return count;
    }

    /**
     * Returns the value of the requested cell
     * @param r
     * @param c
     * @return true, if the cell at r,c is live. false if the cell at r,c is dead
     */
    public boolean cells(int r, int c) {
        if(r<0 || c<0 || r> m-1 || c > n-1) {
            return false;
        }
        return cells[r][c];
    }

    /**
     * Prints the grid on the console
     */
    public void print() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid = (Grid) o;

        if (m != grid.m) return false;
        if (n != grid.n) return false;
        return Arrays.deepEquals(cells, grid.cells);

    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(cells);
        result = 31 * result + m;
        result = 31 * result + n;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int r=0;r<m;r++) {
            for(int c=0;c<n;c++) {
                builder.append(cells(r,c)?1:0);
                if(c==n-1) {
                    builder.append("\n");
                } else {
                    builder.append(" ");
                }
            }
        }
        return builder.toString();
    }
}
