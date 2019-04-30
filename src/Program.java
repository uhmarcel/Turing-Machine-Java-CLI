
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.util.Pair;


public class Program {
    
    public static final int PROGRAM_SIZE = 256;
    public static final String INPUT_PATH = "src/Programs/";
    public static final boolean LEFT = false;
    public static final boolean RIGHT = true;

    private boolean[] direction;
    private Map<Character,Pair<Character,Integer>>[] instrMap;
    
    public Program() {
        direction = new boolean[PROGRAM_SIZE];
        instrMap = new Map[PROGRAM_SIZE];
    }
    
    public Program(String file) throws Exception {
        this();
        this.load(file);
    }
    
    public void add(Instruction c) {
        direction[c.state] = c.direction;
        if (instrMap[c.state] == null) 
            instrMap[c.state] = new HashMap<>();
        instrMap[c.state].put(c.target, new Pair(c.replace, c.nextState));
    }
    
    public void addAll(Instruction[] cs) {
        for (Instruction c : cs) {
            this.add(c);
        }
    }
    
    public void load(String filename) throws Exception {
        Scanner scanner = new Scanner(new File(INPUT_PATH + filename));
        String pattern = "^q([0-9]+)]([rl])\\((.)\\/(.),q(-?[0-9]+)\\)";
        Pattern p = Pattern.compile(pattern);
        
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine().trim();
            Matcher m = p.matcher(currentLine);
            if (m.matches()) {
                int s = Integer.parseInt(m.group(1));
                boolean d  = m.group(2).equals("r") ? RIGHT : LEFT;
                char t = m.group(3).charAt(0);
                char r = m.group(4).charAt(0);
                int n = Integer.parseInt(m.group(5));
                this.add(new Instruction(s,d,t,r,n));
            }         
        }
    }
    
    public boolean getDirection(int state) {
        return direction[state];
    }
    
    public Pair getInstruction(int state, char target) {
        return instrMap[state].get(target);
    }
    
}