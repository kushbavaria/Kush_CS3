package Maze;

import java.io.*;
import java.util.Scanner;

public class Tester
{
    public static void main(String[] args){
        
        try(BufferedReader bReader = new BufferedReader(new FileReader("basicMaze.dat"))){            
             Scanner kb = new Scanner(bReader.readLine());
             
             int x = kb.nextInt();
             int y = kb.nextInt();    
             MazeCell[][] m = new MazeCell[x][y];        
             String line;
             for(int row = 0; row < x; row++){
                 line = bReader.readLine();
                 
                 Scanner scan = new Scanner(line);
                 for(int col = 0; col < y; col++){                  
                     if( scan.nextInt() == 0){
                         m[row][col] = new MazeCell(row, col, false, true);
                        }                        
                     else{
                         m[row][col] = new MazeCell(row, col, false, false);
                        }
                 }
             }             
             Maze maze = new Maze(m,0,0);
             System.out.println(maze);
             
             maze.solveMaze();
             
             System.out.println(maze);
        }
           
         catch(IOException e){
             
            System.out.println(e);
        }
    }
}