package Maps;

import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
public class TranslatorKush
{
    public static void main(String[] args){
        try(BufferedReader r = new BufferedReader(new FileReader("spantoeng.dat"))){
            Map<String,String> translator = new TreeMap<String,String>();
            int num = Integer.parseInt(r.readLine());
            for(int i = 0; i < num; i++){
                Scanner line = new Scanner(r.readLine()); 
                String k= line.next();
                String v = line.next();
                translator.put(k, v);
            }
            
            System.out.println("===\tMAP CONTENTS\t===");
            System.out.print("{\n");
            for(String kb : translator.keySet()){
                System.out.print(kb + "=" + translator.get(kb));
                System.out.println();
            }
            System.out.print("}\n");
            
            ArrayList<String> s = new ArrayList<String>();
            String text; 
            while((text = r.readLine()) != null){
                s.add(text);
            }
            
            for(String kb: s){
                String t = "";
                Scanner n = new Scanner(kb);
                while(n.hasNext()){
                    t += translator.get(n.next()) + " ";
                }
                System.out.println(t);
            }
        }
        catch(IOException e){
            System.out.println("It Broke");
        }
    }
}
