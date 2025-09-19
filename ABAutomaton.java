import java.util.Scanner;

/**
 * Automatons A and B.
 *
 * TODO 1: Fill in your names and student IDs:
 *
 * @author NAME
 * @id ID
 * @author NAME
 * @id ID
 */
class ABAutomaton {
    private static final char OCCUPIED = '*';
    private static final char EMPTY = ' ';

    Scanner scanner = new Scanner(System.in);

    /**
     * Converts a generation to its textual representation using '*' for occupied and ' ' otherwise.
     *
     * @param gen the generation to convert
     * @return the textual representation of the generation
     */
    String genToString(boolean[] gen) {
        StringBuilder builder = new StringBuilder(gen.length);
        for (int i = 0; i < gen.length; i++) {
            builder.append(gen[i] ? OCCUPIED : EMPTY);
        }
        return builder.toString();
    }

    /**
     * Computes the next generation according to automaton A where edges treat missing neighbors
     * as empty cells.
     *
     * @param current the current generation
     * @return the next generation following automaton A rules
     */
    boolean[] nextGenA(boolean[] current) {
        int length = current.length;
        boolean[] next = new boolean[length];
        for (int i = 0; i < length; i++) {
            boolean left = i > 0 && current[i - 1];
            boolean self = current[i];
            boolean right = i < length - 1 && current[i + 1];
            if (self) {
                next[i] = left ^ right;
            } else {
                next[i] = left || right;
            }
        }
        return next;
    }

    /**
     * Computes the next generation according to automaton B where edges treat missing neighbors
     * as empty cells.
     *
     * @param current the current generation
     * @return the next generation following automaton B rules
     */
    boolean[] nextGenB(boolean[] current) {
        int length = current.length;
        boolean[] next = new boolean[length];
        for (int i = 0; i < length; i++) {
            boolean left = i > 0 && current[i - 1];
            boolean self = current[i];
            boolean right = i < length - 1 && current[i + 1];
            if (self) {
                next[i] = !right;
            } else {
                next[i] = left ^ right;
            }
        }
        return next;
    }

    /**
     * Reads the initial generation positions between markers "init_start" and "init_end".
     * Positions outside the provided length are ignored.
     *
     * @param length the length of the generation
     * @return an array indicating the initially occupied positions
     */
    boolean[] readInitialGeneration(int length) {
        boolean[] initial = new boolean[length];
        scanner.next(); // consume "init_start"
        while (true) {
            String token = scanner.next();
            if ("init_end".equals(token)) {
                break;
            }
            int position = Integer.parseInt(token);
            if (position >= 1 && position <= length) {
                initial[position - 1] = true;
            }
        }
        return initial;
    }

    /**
     * Wrapper to preserve the original method name used in run().
     *
     * @param length the length of the generation
     * @return the initial generation array
     */
    boolean[] readInitalGeneration(int length) {
        return readInitialGeneration(length);
    }

    void run() {
        // Read input to configure the automaton
        String automaton = scanner.next();
        int genLength = scanner.nextInt();
        int numOfGens = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(genLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numOfGens; i++) {
            // Display the current generation
            System.out.println(genToString(gen));

            // And determine the next generation
            if ("A".equals(automaton)) {
                gen = nextGenA(gen);
            } else {
                // B
                gen = nextGenB(gen);
            }
        }
    }

    public static void main(String[] args) {
        new ABAutomaton().run();
    }
}
