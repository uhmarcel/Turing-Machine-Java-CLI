

public class Instruction {
    
    public static final boolean LEFT = false;
    public static final boolean RIGHT = true;
    public static final int FINAL_STATE = -1;

    public final int state;
    public final boolean direction;
    public final char target;
    public final char replace;
    public final int nextState;
    
    public Instruction(int s, boolean d, char t, char r, int n) {
        this.state = s;
        this.direction = d;
        this.target = t;
        this.replace = r;
        this.nextState = n;
    }
    
    
}
