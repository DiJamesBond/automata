import java.util.Scanner;

/**
 * Automatons A and B (Part A).
 *
 * TODO: Fill in your names and student IDs below.
 * @author NAME
 * @id     ID
 * @author NAME
 * @id     ID
 */
class ABAutomaton {
    // Characters used to render a generation
    private static final char OCCUPIED = '*'; // star denotes occupied (true)
    private static final char EMPTY    = ' '; // space denotes empty (false)

    // Single Scanner instance for standard input
    Scanner sc = new Scanner(System.in);

    /**
     * Converts a generation into a String consisting only of '*' and ' '.
     * '*' for true (occupied), ' ' for false (empty). Length equals gen.length.
     */
    String genToString(boolean[] gen) {
        String boxfilled = "";
        for (int i = 0; i < gen.length; i++) {
            if (gen[i]) {
                boxfilled = boxfilled + OCCUPIED;
            } else {
                boxfilled = boxfilled + EMPTY;
            }
        }
        return boxfilled;
    }

    /**
     * Computes the next generation using rule set A.
     * Edges treat missing neighbours as empty (false).
     */
    boolean[] nextGenA(boolean[] gen) {
        int n = gen.length;
        boolean[] next = new boolean[n];

        for (int i = 0; i < n; i++) {
            boolean left  = (i > 0) && gen[i - 1];
            boolean self  = gen[i];
            boolean right = (i < n - 1) && gen[i + 1];

            if (self) {
                // stays occupied iff exactly one neighbour is occupied
                next[i] = (left && !right) || (!left && right);
            } else {
                // empty becomes occupied iff at least one neighbour is occupied
                next[i] = left || right;
            }
        }
        return next;
    }

    /**
     * Computes the next generation using rule set B.
     * Edges treat missing neighbours as empty (false).
     */
    boolean[] nextGenB(boolean[] gen) {
        int n = gen.length;
        boolean[] next = new boolean[n];

        for (int i = 0; i < n; i++) {
            boolean left  = (i > 0) && gen[i - 1];
            boolean self  = gen[i];
            boolean right = (i < n - 1) && gen[i + 1];

            if (self) {
                // stays occupied only if the right neighbour is empty
                next[i] = !right;
            } else {
                // empty becomes occupied iff exactly one neighbour is occupied
                next[i] = (left && !right) || (!left && right);
            }
        }
        return next;
    }

    /**
     * Reads the initial generation between the markers "init_start" and "init_end".
     * Positions are 1-based in the input; positions > length are ignored.
     */
    boolean[] readInitialGeneration(int length) {
        boolean[] gen = new boolean[length];

        String start = sc.next(); // expects "init_start"
        // Read integers until a non-integer token ("init_end") occurs
        while (sc.hasNextInt()) {
            int p = sc.nextInt();
            if (p >= 1 && p <= length) {
                gen[p - 1] = true; // convert 1-based to 0-based index
            }
        }
        String end = sc.next(); // consume "init_end"
        return gen;
    }

    /**
     * Program flow as specified by the assignment: read automaton type, length,
     * number of generations, initial generation, then print G lines while updating.
     */
    void run() {
        String automaton = sc.next();   // "A" or "B"
        int length = sc.nextInt();      // number of cells (L)
        int generations = sc.nextInt(); // number of output lines (G)

        boolean[] gen = readInitialGeneration(length);

        for (int g = 0; g < generations; g++) {
            System.out.println(genToString(gen));

            if (automaton.equals("A")) {
                gen = nextGenA(gen);
            } else {
                gen = nextGenB(gen); // assume any non-"A" means "B" as in the template
            }
        }
    }

    public static void main(String[] args) {
        new ABAutomaton().run();
    }
}
