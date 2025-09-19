import java.util.Scanner;

/**
 * Automatons A and B.
 * 
 * TODO 1: Fill in your names and student IDs:
 * 
 * Luca Bosch
 * 2201178
 * Sylvi Deng
 * 2252953
 */
class ABAutomaton {
    private static final char Occupied = '*';
    private static final char Empty = ' ';

    Scanner scanner = new Scanner(System.in);

    String genToString(boolean[] gen) {
        String box = "";
        for (int i = 0; i < gen.length; i++) {
            if (gen[i]) {
                box = box + Occupied;
            } else {
                box = box + Empty;
            }
        }
        return box;
    }

    boolean[] nextGenA(boolean[] gen) {
        int n = gen.length;
        boolean[] next = new boolean[n];

        for (int i = 0; i < n; i++) {
            boolean left = (i > 0) && gen[i - 1];
            boolean self = gen[i];
            boolean right = (i < n - 1) && gen[i + 1];

            if (self) {
                next[i] = (left && !right) || (!left && right);
            } else {
                next[i] = left || right;
            }
        }

        return next;
    }

    boolean[] nextGenB(boolean[] gen) {
        int n = gen.length;
        boolean[] next = new boolean [n];

        for (int i = 0; i < n; i++) {
            boolean left = (i > 0) && gen[i - 1];
            boolean self = gen[i];
            boolean right = (i < n - 1) && gen[i + 1];

            if (self) {
                next[i] = !right;
            } else {
                next[i] = (left && !right) || (!left && right);
            }
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
