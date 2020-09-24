package Maze;

import java.util.Stack;
import java.util.ArrayList;

public class Maze
{
    private MazeCell[][] maze;
    private Stack<MazeCell> trail;
    private MazeCell start;
    
    public Maze(MazeCell[][] madeMaze, int xBegin, int yBegin)
    {
        maze = madeMaze;
        start = maze[xBegin][yBegin];
        trail = new Stack<MazeCell>();
    }
    
    
    public void solveStep(){    
        
        start = trail.peek();
        MazeCell left;    
        MazeCell right;
        MazeCell up; 
        MazeCell down;
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
    public boolean check(MazeCell spot){
        return spot.getBlank() && spot.getoldplace() == false;
    }
    public String Xplacer(){
        String stackTrail = "";
        ArrayList<MazeCell> out = new ArrayList<MazeCell>();
        out.addAll(trail);

        for(MazeCell spot : out){
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
        
        for(MazeCell[] row: maze){
            for(MazeCell spot: row)
                kushBoard += spot + " ";
            kushBoard += "\n";
        }
        return kushBoard;
    }
}
