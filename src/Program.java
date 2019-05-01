
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    private List<Instruction> instructions;
    private boolean[] direction;
    private Map<Character,Pair<Character,Integer>>[] instrMap;
    
    public Program() {
        instructions = new ArrayList<>();
        direction = new boolean[PROGRAM_SIZE];
        instrMap = new Map[PROGRAM_SIZE];
    }
    
    public Program(String file) throws Exception {
        this();
        this.load(file);
    }
    
    public void add(Instruction c) {
        instructions.add(c);
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

    public boolean getDirection(int state) {
        return direction[state];
    }
    
    public Pair getInstruction(int state, char target) {
        Pair instruction = instrMap[state].get(target);
        //Implicit instruction
        if (instruction == null) { 
            instruction = new Pair(target, state); 
        }
        return instruction;
    }
    
    public void load(String filename) throws Exception {
        Scanner scanner = new Scanner(new File(INPUT_PATH + filename));
        
        String fullNotation, fastNotation, fastSubNotation, shortcut;
        fullNotation = "^q([0-9]+)]([rl])\\((.)\\/(.),q(-?[0-9]+)\\)(#.*)?$";
        fastNotation = "^q([0-9]+)\\]([lr])(\\(.\\/.,q-?[0-9]+\\))*(#.*)?$";
        fastSubNotation = "\\((.)\\/(.),q(-?[0-9]+)\\)"; // (n/m,q)
        shortcut = "\\((.),q(-?[0-9]+)\\)"; // (#,q) -> (#/#,q)
                
        Pattern pFull = Pattern.compile(fullNotation);
        Pattern pFast = Pattern.compile(fastNotation);
        Pattern pSub  = Pattern.compile(fastSubNotation);
        
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine().replace(" ","");
            currentLine = currentLine.replaceAll(shortcut, "($1/$1,q$2)");
            
            Matcher m1 = pFull.matcher(currentLine);
            Matcher m2 = pFast.matcher(currentLine);
              
            if (m1.matches()) {
                int s = Integer.parseInt(m1.group(1));
                boolean d  = m1.group(2).equals("r") ? RIGHT : LEFT;
                char t = m1.group(3).charAt(0);
                char r = m1.group(4).charAt(0);
                int n = Integer.parseInt(m1.group(5));
                this.add(new Instruction(s,d,t,r,n));
            }
            else if (m2.matches()) {
                int s = Integer.parseInt(m2.group(1));
                boolean d  = m2.group(2).equals("r") ? RIGHT : LEFT;
                
                Matcher m3 = pSub.matcher(currentLine);
                while (m3.find()) {
                    char t = m3.group(1).charAt(0);
                    char r = m3.group(2).charAt(0);
                    int n = Integer.parseInt(m3.group(3));
                    this.add(new Instruction(s,d,t,r,n));
                }
            }
        }
        System.out.println(this.toString());
    }
    
    public String toString() {
        String output = new String();
        for (Instruction c : instructions)
            output += c + "\n";
        return output;
    }
    
}