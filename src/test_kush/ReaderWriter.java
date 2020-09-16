package test_kush;
import java.io.*;
import java.util.Scanner;

public class ReaderWriter {
    public static void main(String[] args){
        int sum = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("numbers.dat"))) {
            String line;

            while((line = reader.readLine()) != null){
                Scanner kush = new Scanner(line);
                while(kush.hasNext())
                    sum += kush.nextInt();
            }

        }
        catch(IOException e){
            System.out.println("reading no work");
        }

        try(PrintWriter writer = new PrintWriter(new FileWriter("sum.dat"))){
            writer.print(sum);
        }
        catch (IOException e){
            System.out.println("writing no work");

        }
        try(BufferedReader reader = new BufferedReader(new FileReader("sum.dat"))){
            String line = reader.readLine();
            System.out.println("the sum is: " + line);
        }
        catch(IOException e){
            System.out.println("sum print no work");
        }
    }
}
