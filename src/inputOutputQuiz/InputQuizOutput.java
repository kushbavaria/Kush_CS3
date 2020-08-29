package inputOutputQuiz;

import java.io.*;
import java.util.Scanner;

public class InputQuizOutput
{
     public static void main(String[] args){

         createRandFile("nums.dat",5,5);
        printFileContents("nums.dat");
        replaceNegatives("nums.dat", "change.dat");
        printFileContents("change.dat");
    }
    
      public static void createRandFile(String fileName, int x, int y){
         try(PrintWriter printer = new PrintWriter(new FileWriter(fileName))){
              for(int kush = 0; kush < x; kush++){
                  String next = "";
                     for(int b = 0; b < y; b++){
                       next += ((int)((Math.random() * 5 ) - (Math.random() * 5 )) + 1 + " ");
                 }
                  printer.println(next);
             }
         }
         catch(IOException e){
             System.out.println("File didn't create");
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
            System.out.println("File didn't print");
        }
    }
    
    public static void replaceNegatives(String fileIn, String fileOut){
        String out = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(fileIn))){
            String x = reader.readLine();
              while(x != null){
                   String saver = "";

                   Scanner line = new Scanner(x);
                 while(line.hasNext()){
                      saver += Math.abs(line.nextInt()) + " ";
                 }
                  out += saver + "\n";
                 x = reader.readLine();
            }
        }
          catch(IOException e){
             System.out.println("File didn't replace negatives");
        }






         try(PrintWriter printer = new PrintWriter(new FileWriter(fileOut))){
              printer.print(out);
        }
          catch(IOException e){
               System.out.println(" File didn't print part 2");
        }
    }
    
    
}
