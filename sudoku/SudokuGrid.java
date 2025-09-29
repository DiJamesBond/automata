import java.awt.Point;

/**
 * SudokuGrid.
 * 
 * TODO 4: FIll in your names and student IDs:
 * 
 * Luca Bosch
 * @id ID
 * Sylvi Deng
 * 2252953
 */

public class SudokuGrid {
    private static final int SIZE = 9;
    private static final int DIGIT_RANGE = 9;

    private int[][] grid;
    private int rEmpty, cEmpty; // Coordinates of the last found empty cell

    public SudokuGrid() {
        // Initialize the grid and set rEmpty and cEmpty to -1
    }

    public SudokuGrid copy() {
        // Create a copy of the SudokuGrid and return it
        return null;
    }

    public Point findEmptyCell() {
        // Find the next empty cell in reading order and return its coordinates as a Point
        return null;
    }

    public void print() {
        // Print the Sudoku grid
    }

    public void fillCell(int r, int c, int d) {
        // Fill the cell at row r and column c
    }

    public boolean givesConflict(int r, int c, int d) {
        // Check if filling the number d in the cell at row r and column c causes a conflict
        return false;
    }

    private boolean rowConflict(int r, int d) {
        // Check if there is a conflict in the row r when filling the number d

        for (int i = 0; i < SIZE, i++) {
            if (grid[r][i] == d) {
                return true;
            }
        }
        return false;
    }

    private boolean colConflict(int c, int d) {
        // Check if there is a conflict in the column c when filling the number d
        for (int i = 0; i < SIZE, i++) {
            if (grid[i][c] == d) {
                return true;
            }
        }
        return false;
    }

    private boolean boxConflict(int r, int c, int d) {
        // Check if there is a conflict in the 3x3 box containing the cell at row r and column c
        // when filling the number d

        int localBoxRow = r - r % 3;
        int localBoxColumn = c - c % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (grid[i][j] == d) {
                    return true;
                }
            }
        }
        return false;
    }
}