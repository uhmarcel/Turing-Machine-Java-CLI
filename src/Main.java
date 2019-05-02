

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        TuringMachine TM = new TuringMachine();
        
        Program replaceZeroes = new Program("ReplaceZeroes.tm");
        Program firstChar = new Program("FirstChar.tm");
        Program firstAndLast = new Program("FirstAndLast.tm");
        Program reverse = new Program("Reverse.tm");
        Program copyPaste = new Program("CopyPaste.tm");
        Program add = new Program("Add.tm");
        Program multiply = new Program("Multiply.tm");
        
        System.out.println(multiply);
        
        TM.setInput("1", "");        
        System.out.println(TM);
        
        while (!TM.isDone()) {
            String state = TM.step(multiply);
            System.out.println(state);
        }
        
        System.out.println(TM);
        
        
    }
    
}
