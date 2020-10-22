package Maps;

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class kush_relatives
{
  public static void main(String[] args){
      try(BufferedReader bReader = new BufferedReader(new FileReader("relatives.dat"))){
          Map<String,ArrayList<String>> hash;
          hash = new HashMap<String, ArrayList<String>>();
           int lines = Integer.parseInt(bReader.readLine());
          String key ="";
            String ma = "";
           Scanner kb;
           for(int i =0; i < lines;i++){
               kb = new Scanner(bReader.readLine());
              key = kb.next();
               ma = kb.next();
               if(hash.containsKey(key)){
                  hash.get(key).add(ma);
                } else{
                  ArrayList<String> list = new ArrayList<String>();
                  list.add(ma);
                  hash.put(key, list);
                }
            }
            String output = "";
            for(String kush : hash.keySet()){
               output+= kush + " is related to ";
               for(String z : hash.get(kush)){
                   output += z + "\n";
                }                                               
            }
            System.out.println(output);
        }
      catch(IOException e){
          System.out.println(e);
        }
      
      
    }
}