import java.util.Scanner;

/**
 * Universal Automaton.
 *
 * TODO: Fill in your names and student IDs
 *
 * @author NAME
 * @id ID
 * @author NAME
 * @id ID
 */
class UniversalAutomaton {
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
     * Determines the next generation using a provided rule sequence with the edge cells assuming
     * missing neighbors are empty.
     *
     * @param rules   the eight rules for the patterns ordered by (left, self, right) bits
     * @param current the current generation
     * @return the next generation produced by the rule sequence
     */
    boolean[] nextGen(boolean[] rules, boolean[] current) {
        int length = current.length;
        boolean[] next = new boolean[length];
        for (int i = 0; i < length; i++) {
            boolean left = i > 0 && current[i - 1];
            boolean self = current[i];
            boolean right = i < length - 1 && current[i + 1];
            int index = (left ? 4 : 0) + (self ? 2 : 0) + (right ? 1 : 0);
            next[i] = rules[index];
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

    /**
     * Reads the eight rule bits defining the automaton behaviour.
     *
     * @return an array mapping each pattern index to the occupancy of the next generation
     */
    boolean[] readRuleSequence() {
        boolean[] rules = new boolean[8];
        for (int i = 0; i < 8; i++) {
            int value = scanner.nextInt();
            rules[i] = value == 1;
        }
        return rules;
    }

    void run() {
        // Read input to configure the universal automaton
        boolean[] ruleSequence = readRuleSequence();
        int generationLength = scanner.nextInt();
        int numberOfGenerations = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(generationLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numberOfGenerations; i++) {
            // Display the current generation
            System.out.println(genToString(gen));
            // Determine the next generation
            gen = nextGen(ruleSequence, gen);
        }
    }

    public static void main(String[] args) {
        new UniversalAutomaton().run();
    }
}
