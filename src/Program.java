
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;


public class Program {
    
    public static final int PROGRAM_SIZE = 256;

    private Map<Character,Pair<Character,Integer>>[] instrMap;
    private boolean[] direction;
    
    public Program() {
        direction = new boolean[PROGRAM_SIZE];
        instrMap = new Map[PROGRAM_SIZE];
    }
    
    public void add(Instruction c) {
        direction[c.state] = c.direction;
        if (instrMap[c.state] == null) 
            instrMap[c.state] = new HashMap<>();
        instrMap[c.state].put(c.target, new Pair(c.replace, c.nextState));
    }
    
    public boolean getDirection(int state) {
        return direction[state];
    }
    
    public Pair getInstruction(int state, char target) {
        return instrMap[state].get(target);
    }
    
}