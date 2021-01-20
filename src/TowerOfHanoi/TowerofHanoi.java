package TowerOfHanoi;

import java.util.Stack;

public class TowerofHanoi
{
    private Stack<Integer> left;
    private Stack<Integer> middle;
    private Stack<Integer> right;
    private int disks;
    private int moves;
    private String output;
    
    public TowerofHanoi(){
        this(5);
    }
    
    public TowerofHanoi(int d){
        output = "";
        disks = d;
        moves = 0;
       
        left = new Stack<Integer>();
        middle = new Stack<Integer>();
        right = new Stack<Integer>();
        
        for(int i = disks; i > 0; i--){
            left.push(i);
        }
    } 
    
    public String toString(){

        return output;
    }
    

    public void solve(){
        output += print();
        solve(disks, left, right, middle);
    }
    
    public void move(Stack<Integer> start, Stack<Integer> end){
        int ring = start.pop();
        end.push(ring);
        moves++;
        output += "\n" + print();
    }
    public void solve(int disks, Stack<Integer> begin, Stack<Integer> end, Stack<Integer> avail){
        if(disks == 1){
            move(begin, end);
        }
        else{
            solve(disks - 1, begin,  avail, end);
            move(begin, end);
            solve(disks - 1, avail, end, begin);
        }
    }

    public String printLine(Stack<Integer> list, int i){
        if(list.size() > i)
            return " " + list.get(i);
        return " *"; 
    }
    
    public String print(){
        String out = "\n";
        
        for(int i = disks - 1; i > -1; i--){
            out += printLine(left, i);
            out += printLine(middle, i);
            out+= printLine(right, i);
            out += "\n";
        }
        
        out += " a b c\n moves = " + moves;
        return out;
    }
}