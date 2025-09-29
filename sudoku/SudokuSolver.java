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
        this.grid = grid;
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

         boolean found = solve ();
         if (found) {
            grid.print();
         } else {
            System.out.println("No solution");
         }


    }

    public static void main(String[] args) {
        // Create a SudokuGrid and a SudokuSolver

        int[][] initial = {
            {0,6,0, 0,0,1, 0,9,4},
            {3,0,0, 0,0,7, 1,0,0},
            {0,0,0, 0,9,0, 0,0,0},

            {7,0,6, 5,0,0, 2,0,9},
            {0,3,0, 0,2,0, 0,6,0},
            {9,0,2, 0,0,6, 3,0,1},

            {0,0,0, 0,5,0, 0,0,0},
            {0,0,7, 3,0,0, 0,0,2},
            {4,1,0, 7,0,0, 0,8,0},
        }
    }
}
