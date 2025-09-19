import java.util.Scanner;

/**
 * Universal Automaton.
 * 
 * TODO: Fill in your names and student IDs
 * 
 * Luca Bosch
 * 2201178
 * Sylvi Deng
 * 2252953
 */
class UniversalAutomaton {
    private static final char Occupied = '*';
    private static final char Empty = ' ';

    Scanner scanner = new Scanner(System.in);

    String genToString(boolean[] gen) {
        String line = "";
        for (int i = 0; i < gen.length; i++) {
            if (gen[i]) {
                line = line + Occupied;
            } else {
                line = line + Empty;
            }
        }
        return line;
    }

    boolean[] nextGen(boolean[] ruleSequence, boolean[] gen) {
        int n = gen.length;
        boolean[] next = new boolean[n];

        for (int i = 0; i < n; i++) {
            boolean left = (i > 0) && gen[i - 1];
            boolean self = gen[i];
            boolean right = (i < n - 1) && gen[i + 1];

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

            next[i] = ruleSequence[idx];
        }
    
        return next;
    }

    boolean[] readInitalGeneration(int length) {
        boolean[] gen = new boolean[length];

        String start = scanner.next(); 
        while (scanner.hasNextInt()) {
            int p = scanner.nextInt();
            if (p >= 1 && p <= length) {
                gen[p - 1] = true;
            }
        }
        String end = scanner.next();
        return gen;
    }

    boolean[] readRuleSequence() {
        boolean[] rulesSequence = new boolean[8];
        for (int i = 0; i < 8; i++) {
            int v = scanner.nextInt();
            rulesSequence[i] = (v == 1);
        }
        return rulesSequence;
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
