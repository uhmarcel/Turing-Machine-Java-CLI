

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        TuringMachine TM = new TuringMachine();
        
        Program replaceZeroes = new Program("ReplaceZeroes.tm");
        
        
        TM.setInput("00101001");        
        System.out.println(TM);
        
        while (!TM.isDone()) {
            String state = TM.step(replaceZeroes);
            System.out.println(state);
        }
        
        System.out.println(TM);
        
        
    }
    
}
