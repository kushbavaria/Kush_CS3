package MagicSquares;

import java.io.*;
public class MagicSquareTwo
{
    public static void main(String[] args){
        try(BufferedReader bReader = new BufferedReader(new FileReader("magic2.dat"))){
          String kush;
          while((kush = bReader.readLine()) != null){
              int size = Integer.parseInt(kush);
              int[][] square = new int[size][size];
              createMagicSquare(square);
              System.out.println(printMagicSquare(square));
          }
        }
        catch(IOException e){
            System.out.println("Doesnt Work");
        }
    }
    public static String printMagicSquare(int[][] arr){
        String print = "";
        for(int r = 0; r < arr.length; r++){
            for(int c = 0; c < arr[0].length; c++){
                print += String.format("%-2s\t", arr[r][c] + "");
            }
            print += "\n";
        }
        return print;
    }
    public static void createMagicSquare(int[][] arr){
        int rows = 0;
        int colummns = arr.length/2;
        int numbers = 2;
        arr[rows][colummns] = 1;
        int length = arr.length;        
        while(numbers <= length * length){
            if(rows - 1 < 0){
                rows = length - 1;
            }
            else{
                rows--;
            }           
            if(colummns + 1 > length - 1){
                colummns = 0;
            }
            else{
                colummns++;
            }               
            if(arr[rows][colummns] > 0){
                if(rows + 1 > length - 1){
                    rows = 0;
                }
                else{
                    rows++;
                }    
                if(rows + 1 > length - 1){
                    rows = 0;
                }
                else{
                    rows++;
                }    
                if(colummns - 1 < 0){
                    colummns = length - 1;
                }
                else{
                    colummns--;
                }
            }            
            arr[rows][colummns] = numbers;
            numbers++;
        }        
    }    
   
}