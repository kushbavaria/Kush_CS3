package Maze;

import java.io.*;
import java.util.Scanner;

public class MazeRunner
{
    public static void main(String[] args){
        
        try(BufferedReader bReader = new BufferedReader(new FileReader("basicMaze.dat"))){            
             Scanner kb = new Scanner(bReader.readLine());
             
             int x = kb.nextInt();
             int y = kb.nextInt();    
             MazeStacks[][] m = new MazeStacks[x][y];
             String line;
             for(int row = 0; row < x; row++){
                 line = bReader.readLine();
                 
                 Scanner scan = new Scanner(line);
                 for(int col = 0; col < y; col++){                  
                     if( scan.nextInt() == 0){
                         m[row][col] = new MazeStacks(row, col, false, true);
                        }                        
                     else{
                         m[row][col] = new MazeStacks(row, col, false, false);
                        }
                 }
             }             
             MainMaze maze = new MainMaze(m,0,0);
             System.out.println(maze);
             
             maze.solveMaze();
             
             System.out.println(maze);
        }
           
         catch(IOException e){
             
            System.out.println(e);
        }
    }
}