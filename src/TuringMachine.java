
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;


public class TuringMachine {

    private final int TAPE_SIZE = 256;     
    private final char EMPTY_CHAR = '#';

    private List<Character> tape;
    private int position;
    private int state;

    public TuringMachine() {
        this.tape = new LinkedList<>();
        this.tape.add(EMPTY_CHAR);
        this.tape.add(EMPTY_CHAR);
        this.position = 0;
        this.state = 0;
    }
    
    
    public void resetTape() {
        this.tape = new ArrayList<>();
        this.tape.add(EMPTY_CHAR);
        this.tape.add(EMPTY_CHAR);
        this.state = 0;
    }
    
    public void setInput(String... input) {
        int temp = position;
        for (String s : input) {
            char[] c = s.toCharArray();   
            int i = 0;
            for (; i < c.length; i++)
                tape.add(position + i + 1, c[i]);
            position += i + 1;
            tape.add(position + 1, EMPTY_CHAR);
        }
        tape.remove(tape.size()-1);
        position = temp;
    }    
    
    public boolean isDone() {
        return state == Instruction.FINAL_STATE;
    }

    public String step(Program p) {
        if (position == tape.size() - 1)
            tape.add(EMPTY_CHAR);
        position += p.getDirection(state) ? 1 : -1;
        
        char currentToken = tape.get(position);
        Pair inst = p.getInstruction(state, currentToken);
        tape.remove(position);
        tape.add(position, (Character)inst.getKey());
        state = (Integer)inst.getValue();
        
        return this.toString();
    }
        
    public String toString() {
        String output = new String();
        for (int i = 0; i < tape.size(); i++) {
            if (i == position) 
                output += "[" + tape.get(i) + "]";
            else
                output += tape.get(i);
        } 
        return output + "  s = " + state;
    }
    
    public String getOutput() {
        String output = new String();
        int index = 0;
        while (index != tape.size() - 1) {
            char current = tape.get(index);
            if (current != '#') {
                output += current; 
            }
            index++;
        }
        return output;
    }
    
    
//    public void compute(Program p) {
//        int currentState = 0;
//        char currentToken;
//        
//        while (currentState != Instruction.FINAL_STATE) {
//            currentToken = tape.get(position);
//            Instruction inst = p.getInstruction(currentState, currentToken);
//            
//            position += inst.direction ? 1 : -1 ;
//            return;
//            
//        }
//        
//    }

}
