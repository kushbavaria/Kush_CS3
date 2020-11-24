package Maze;

import java.util.Stack;
import java.util.ArrayList;

public class MainMaze
{
    private MazeStacks[][] maze;
    private Stack<MazeStacks> trail;
    private MazeStacks start;
    
    public MainMaze(MazeStacks[][] madeMaze, int xBegin, int yBegin)
    {
        maze = madeMaze;
        start = maze[xBegin][yBegin];
        trail = new Stack<MazeStacks>();
    }
    
    
    public void solveStep(){    
        
        start = trail.peek();
        MazeStacks left;
        MazeStacks right;
        MazeStacks up;
        MazeStacks down;
        if(start.getY() > 0 && check(left  = maze[start.getX()][start.getY() -1])){
            start = left;
            trail.push(start);
            start.setoldplace();
            start.setwallBinary("X");
        }
        else if(start.getY() < maze[0].length-1 && check(right = maze[start.getX()][start.getY() + 1])){               
            start = right;
            trail.push(start);
            start.setoldplace();
            start.setwallBinary("X");
        }
        
        
        else if(start.getX() > 0 && check(up = maze[start.getX() -1][start.getY()])){                         
            start = up;         
            trail.push(start);
            start.setoldplace();
            start.setwallBinary("X");
        }
        else if(start.getX() < maze.length-1 && check(down = maze[start.getX() + 1][start.getY()])){                         
            start = down;
            trail.push(start);
            start.setoldplace();
            start.setwallBinary("X");
        }
        
       
        else{
            trail.pop();
        }
    }
    public boolean check(MazeStacks spot){
        return spot.getBlank() && spot.getoldplace() == false;
    }
    public String Xplacer(){
        String stackTrail = "";
        ArrayList<MazeStacks> out = new ArrayList<MazeStacks>();
        out.addAll(trail);

        for(MazeStacks spot : out){
            stackTrail += spot.coordinates() + "\n";
        }
        return stackTrail;
    }


    public void solveMaze(){
        trail.push(start);
        start.setoldplace();
        while(!(start.getX() == maze.length-1 && start.getY() == maze[0].length-1)){
             solveStep();
        }   
    }
    
    
    public String toString(){
        String kushBoard = "";
        
        while(!trail.isEmpty()){
            trail.pop().setwallBinary("-");
        }
        
        for(MazeStacks[] row: maze){
            for(MazeStacks spot: row)
                kushBoard += spot + " ";
            kushBoard += "\n";
        }
        return kushBoard;
    }
}
