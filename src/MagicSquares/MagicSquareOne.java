package MagicSquares;

import java.util.Scanner;
import java.io.*;
public class MagicSquareOne{
    public static void main (String [] args){
        try(BufferedReader bReader = new BufferedReader(new FileReader("magic1.dat"))){
            int[][] magicsquare;
            int num;
            String okay;
            int numberOfmagicsquares = Integer.parseInt(bReader.readLine());            
            for(int i=0;i<numberOfmagicsquares;i++){               
                num = Integer.parseInt(bReader.readLine());
                magicsquare = new int[num][num];
                okay = bReader.readLine();
                makemagicsquare(magicsquare,num,okay);
                System.out.print(output(magicsquare,num));
                if(magicSquareorNo(magicsquare,num)){
                   System.out.println("MAGIC SQUARE\n");
                }
                else{
                    System.out.println("NOT A MAGIC SQUARE\n");
                }
            }
        }
        catch(IOException e){
            System.out.println("Doesnt work");
        }
    }
  
    public static int[][] makemagicsquare(int[][] array, int n, String o){
       Scanner bruh = new Scanner(o);
       for(int i=0;i<n;i++)
           for(int j=0;j<n;j++)
               array[i][j] = (bruh.nextInt());       
       return array;
    } 
    public static String output(int[][] arr2d, int num){
        String magicsquare = "";
        for(int i = 0;i<num;i++){
           for(int j = 0;j<num;j++)
              magicsquare+= arr2d[i][j] + " ";     
           magicsquare += "\n";
        }     
        return magicsquare;
    }
    
    public static boolean magicSquareorNo(int[][] arr2d, int num){
       int kush = 0;
       int pos = 0;
       for(int i =0;i<num;i++){
           kush+= arr2d[0][i];
       }
       for(int i=0;i<num;i++){
        pos = 0;
        for(int j=0;j<num;j++){
              pos+=arr2d[i][j];  
        }
          if(pos!=kush){
            return false;
        }
       }
       for(int i=0;i<num;i++){
        pos = 0;
        for(int j = 0;j<num;j++)
             pos += arr2d[j][i];            
          if(pos!=kush){
            return false;
        }
        }
       pos = 0;
       for(int i = 0;i<num;i++){
          pos += arr2d[i][i];  
       }
       if(pos!=kush){
           return false;
       }
       pos = 0;
       for(int i = 0;i<num;i++){
         pos += arr2d[i][num-1-i];   
       }
       if(pos!=kush){
           return false;    
       }
       return true;
    }
}
