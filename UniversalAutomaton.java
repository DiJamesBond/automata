import java.util.Scanner;

/**
 * Universal Automaton (Part B).
 *
 * TODO: Fill in your names and student IDs below.
 * @author NAME
 * @id     ID
 * @author NAME
 * @id     ID
 */
class UniversalAutomaton {
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
        String line = "";
        for (int i = 0; i < gen.length; i++) {
            if (gen[i]) {
                line = line + OCCUPIED;
            } else {
                line = line + EMPTY;
            }
        }
        return line;
    }

    /**
     * Reads the 8-bit rule sequence as booleans (0 -> false, 1 -> true).
     * The sequence order is: l s r encoded as bits for indexes 0..7 (000..111).
     */
    boolean[] readRuleSequence() {
        boolean[] rules = new boolean[8];
        for (int i = 0; i < 8; i++) {
            int v = sc.nextInt();
            rules[i] = (v == 1);
        }
        return rules;
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
     * Computes the next generation using the universal rule table.
     * Each cell's neighbourhood (left, self, right) maps to an index 0..7.
     * Edges treat missing neighbours as empty (false).
     */
    boolean[] nextGen(boolean[] gen, boolean[] rules) {
        int n = gen.length;
        boolean[] next = new boolean[n];

        for (int i = 0; i < n; i++) {
            boolean left  = (i > 0) && gen[i - 1];
            boolean self  = gen[i];
            boolean right = (i < n - 1) && gen[i + 1];

            // Build the 3-bit pattern index using only basic constructs
            int idx = 0;
            if (left) {
                idx = idx + 4;
            }
            if (self) {
                idx = idx + 2;
            }
            if (right) {
                idx = idx + 1;
            }

            next[i] = rules[idx];
        }
        return next;
    }

    /**
     * Program flow as specified by the assignment: read the rule sequence (8 bits),
     * then length, number of generations, initial generation, then print and update.
     */
    void run() {
        boolean[] rules = readRuleSequence();
        int length = sc.nextInt();
        int generations = sc.nextInt();

        boolean[] gen = readInitialGeneration(length);

        for (int g = 0; g < generations; g++) {
            System.out.println(genToString(gen));
            gen = nextGen(gen, rules);
        }
    }

    public static void main(String[] args) {
        new UniversalAutomaton().run();
    }
}
