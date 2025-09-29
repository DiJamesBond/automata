/**
 * SudokuSolver.
 * 
 * TODO 4: FIll in your names and student IDs:
 * 
 * Luca Bosch
 * @id ID
 * Sylvi Deng
 * 2252953
 */
public class SudokuSolver {

    public SudokuSolver(SudokuGrid grid) {
        // Initialize the SudokuSolver with the provided SudokuGrid
    }

    public boolean solve() {
        // Use a recursive strategy to solve the Sudoku puzzle

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (grid[r][c] == 0) {
                    for (int numberToTry = 1; numberToTry <= SIZE; numberToTry++) {
                        if ()
                    }
                }
            }
        }

        return false;
    }
    
    public void solveIt() {
         // Use solve() to solve the puzzle and print the solution or a message if no solution is found
    }

    public static void main(String[] args) {
        // Create a SudokuGrid and a SudokuSolver
    }
}