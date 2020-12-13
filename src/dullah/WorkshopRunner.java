package dullah;

import java.util.HashMap;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
public class WorkshopRunner
{
   public static void main(String[] args){
       String start = "\nSanta's Workshop Software\n Enter the menu selection that you would like:\n1 - print list of children we're watching\n2 - record something good they've done\n3 - record something trash they've done\n4- update nice/naughty status\n5 - print the Christmas Eve Route\n6 - exit";
       Scanner kb = new Scanner(System.in);
       int in = 0;
       ArrayList<Child> childs = generateChilds();
       Map<Child,ArrayList<String>> nice = new HashMap<Child,ArrayList<String>>();
       Map<Child,ArrayList<String>> naughty = new HashMap<Child,ArrayList<String>>();
       Map<Child,Stack<String>> stockings = new HashMap<Child,Stack<String>>();
       PriorityQueue<Child> route = new PriorityQueue<Child>();
       for(int i = 0; i < childs.size(); i++){
           nice.put(childs.get(i), new ArrayList<String>());
           naughty.put(childs.get(i), new ArrayList<String>());
           stockings.put(childs.get(i), new Stack<String>());
       }
       
       while(in != 6){
           System.out.println(start);
           System.out.print("enter a choice: ");
           in = kb.nextInt();
           System.out.println();
           if(in == 1){
               printChildren(childs);
           }
           else if(in == 2){
               printChildren(childs);
               System.out.print("\nwhich child did something good: ");
               int kid = kb.nextInt();
               System.out.print("\nwhatd they do: ");
               String thing = kb.next() + kb.nextLine();
               nice.get(childs.get(kid)).add(thing);
               childs.get(kid).setNiceLevel(nice.get(childs.get(kid)).size() - naughty.get(childs.get(kid)).size());
               printTheLists(childs,nice,naughty);
               System.out.println();
           }
           else if(in == 3){
               printChildren(childs);
               System.out.print("\nwhich child did something bad: ");
               int kid = kb.nextInt();
               System.out.print("\nwhatd they do: ");
               String thing = kb.next() + kb.nextLine();
               naughty.get(childs.get(kid)).add(thing);
               childs.get(kid).setNiceLevel(nice.get(childs.get(kid)).size() - naughty.get(childs.get(kid)).size());
               printTheLists(childs,nice,naughty);
               System.out.println();
           }
           else if(in == 4){
               System.out.println("Current Stockings");
               for(int i = 0; i < childs.size(); i++){
                   Stack<String> childsStocking = stockings.get(childs.get(i));
                   if(childs.get(i).getNiceLevel() <= 0){
                       if(childsStocking.isEmpty() || childsStocking.peek().indexOf("coal") >= 0){
                           childsStocking.push("coal");
                       }
                       else{
                           childsStocking.pop();
                       }
                   }
                   else{
                       if(childsStocking.isEmpty() || childsStocking.peek().indexOf("present") >= 0){
                           childsStocking.push("present");
                       }
                       else{
                           childsStocking.pop();
                       }
                   }
                   System.out.println(childs.get(i).getName() + childsStocking);
               }
           }
           else if(in == 5){
               for(int i = 0; i < childs.size(); i++){
                   route.add(childs.get(i));
               }
               while(!route.isEmpty()){
                   Child now = route.remove();
                   System.out.print(now.getName() + " who lives at " + now.getStreet() + " will get " + stockings.get(now).size());
                   if(stockings.get(now).isEmpty() || stockings.get(now).peek().indexOf("coal") >= 0){
                       System.out.print(" lump(s) of coal");
                   }
                   else{
                       System.out.print(" present(s)");
                   }
                   System.out.println();
               }
           }
       }
   }
   
   public static void printChildren(ArrayList<Child> childs){
       for(int i = 0; i < childs.size(); i++){
           System.out.println(i + " " + childs.get(i));
       }       
   }
   
   public static void printTheLists(ArrayList<Child> childs, Map<Child,ArrayList<String>> nice, Map<Child,ArrayList<String>> naughty){
       System.out.println("\nNice");
       for(int i = 0; i < childs.size(); i++){
           System.out.println(childs.get(i).getName() + " " + nice.get(childs.get(i)));
       }       
       System.out.println("\nNaughty");
       for(int i = 0; i < childs.size(); i++){
           System.out.println(childs.get(i).getName() + " " + naughty.get(childs.get(i)));
       }      
   }
   
   public static ArrayList<Child> generateChilds(){
       ArrayList<Child> descriptions = new ArrayList<Child>();
       String[] street = {"bruh boulevard 8237421", "vibes vomally 3462383", "job promaeely 3272932", "undrstamdable macacroni 218012", "inadequate tacobell 1217218", "lobsterified innout 0219120", "parabola hyperbola 238230", "binary hexademical 21021910", "chickfila popeyes 211920", "pluckers is soooo goooddd 27192271"};
       String[] names = {"richthekid", "lil baby", "dababy", "offset", "lil wayne", "takeoff", "quavo", "young thug", "gunna", "wheezy5x"};
       Integer[] ages = {26,27,10,49,38,20,48,19,12,20};
       for(int i = 0; i<10; i++){
           descriptions.add(new Child(ages[i], names[i], street[i]));
       }
       return descriptions;
   }
}
