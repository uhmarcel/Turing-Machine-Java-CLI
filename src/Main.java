

public class Main {
    
    public static void main(String[] args) {
        
        TuringMachine TM = new TuringMachine();
        
        Program replaceZeroes = new Program();
        replaceZeroes.add(new Instruction(0,true,'0','1',0));
        replaceZeroes.add(new Instruction(0,true,'1','1',0));
        replaceZeroes.add(new Instruction(0,true,'#','#',1));
        replaceZeroes.add(new Instruction(1,false,'1','1',1));
        replaceZeroes.add(new Instruction(1,false,'0','0',1));
        replaceZeroes.add(new Instruction(1,false,'#','#',-1));
        
        System.out.println(TM);
        TM.setInput("00101001");        
        System.out.println(TM);
        
        while (!TM.isDone()) {
            System.out.println(TM.step(replaceZeroes));
        }
        
        System.out.println(TM);
        
        
    }
    
}
