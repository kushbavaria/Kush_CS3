package inputOutputQuiz;

import java.io.*;
import java.util.Scanner;

public class FiveByFive
{
    public static void main(String[] args){
        
        createRandFile("nums.dat",5,5);
        printFileContents("nums.dat");
        replaceNegatives("nums.dat", "change.dat");
        printFileContents("change.dat");
    }
    
    public static void createRandFile(String fileName, int x, int y){
        try(PrintWriter printer = new PrintWriter(new FileWriter(fileName))){
            for(int r = 0; r < x; r++){
                String line = "";
                for(int c = 0; c < y; c++){
                    line += ((int)((Math.random() * 5 ) - (Math.random() * 5 )) + 1 + " ");
                }
                printer.println(line);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static void printFileContents(String fileName){
        System.out.println();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String x = reader.readLine();
            while(x != null){
                System.out.println(x);
                x = reader.readLine();
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static void replaceNegatives(String fileIn, String fileOut){
        String out = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(fileIn))){
            String x = reader.readLine();
            while(x != null){
                String liner = "";
                Scanner line = new Scanner(x);
                while(line.hasNext()){
                    liner += Math.abs(line.nextInt()) + " ";
                }
                out += liner + "\n";
                x = reader.readLine();
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        
        try(PrintWriter printer = new PrintWriter(new FileWriter(fileOut))){
            printer.print(out);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    
}
