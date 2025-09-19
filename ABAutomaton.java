import java.util.Scanner;

/**
 * Automatons A and B.
 * 
 * TODO 1: Fill in your names and student IDs:
 * 
 * @author NAME
 * @id ID
 * Sylvi Deng
 * 2252953
 */
class ABAutomaton {
    Scanner scanner = new Scanner(System.in);

    String genToString(boolean[] gen) {
        // TODO Implementation
        return "Hello";
    }

    boolean[] nextGenA(boolean[] gen) {
        // TODO Implementation
        return new boolean[] { true, false };
    }

    boolean[] nextGenB(boolean[] gen) {
        // TODO Implementation
        return new boolean[] { true, false };
    }

    boolean[] readInitalGeneration(int length) {
        // TODO Implementation
        return new boolean[] { true, false };
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

