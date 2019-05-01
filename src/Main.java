

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        TuringMachine TM = new TuringMachine();
        
        Program replaceZeroes = new Program("ReplaceZeroes.tm");
        Program firstChar = new Program("FirstChar.tm");
        Program firstAndLast = new Program("FirstAndLast.tm");
        Program reverse = new Program("Reverse.tm");
        
        System.out.println(reverse);
        
        TM.setInput("00101001");        
        System.out.println(TM);
        
        while (!TM.isDone()) {
            String state = TM.step(reverse);
            System.out.println(state);
        }
        
        System.out.println(TM);
        
        
    }
    
}
