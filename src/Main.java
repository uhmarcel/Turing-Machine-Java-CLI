

public class Main {
    
    public static boolean validateArguments(String[] args) {
        return args.length == 2 || (args.length == 3 && args[2].equals("-v"));
    }
    
    public static void main(String[] args) throws Exception {
        
        if (!validateArguments(args)) {
            System.out.println("Invalid input");
            return;
        }
        
        String path = args[0];
        String input = args[1];
        boolean verbose = args.length == 3;
        
        TuringMachine TM = new TuringMachine();
        Program program = new Program(path);
        
        TM.setInput(input);
        
        if (verbose) {
            System.out.println(program);
            System.out.println(TM);
        }
        
        String trace;
        while (!TM.isDone()) {
            trace = TM.step(program);
            if (verbose) {
                System.out.println(trace);
            }
        }
        
        if (verbose) {
            System.out.println();
        }
        System.out.println(TM.getOutput());
        
    }
    
}
