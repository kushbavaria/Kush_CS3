package FinalProject;

import java.util.HashMap;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
public class Elfrunner {
    public static void main(String[] args) {
        String kush = "Santa's Workshop Software v0.1\n Enter the menu selection that you would like:\n1 - print list of children being monitored\n2 - record a nice action\n3 - record a naughty action\n4- update nice/naughty state\n5 - print the Christmas Eve santaRoute\n6 - exit";
        int choice = 0;
        Scanner kb = new Scanner(System.in);
        ArrayList<Kids> kids = makeChild();
        Map<Kids, Stack<String>> stocking = new HashMap<Kids, Stack<String>>();
        Map<Kids, ArrayList<String>> nice = new HashMap<Kids, ArrayList<String>>();
        Map<Kids, ArrayList<String>> naughty = new HashMap<Kids, ArrayList<String>>();
        PriorityQueue<Kids> santaRoute = new PriorityQueue<Kids>();
        for (int i = 0; i < kids.size(); i++) {
            stocking.put(kids.get(i), new Stack<String>());
            nice.put(kids.get(i), new ArrayList<String>());
            naughty.put(kids.get(i), new ArrayList<String>());
           
        }

        while (choice != 6) {
            System.out.println(kush);
            System.out.print("Enter menu selection: \n");
            choice = kb.nextInt();
        
            if (choice == 1) {
                for (int i = 0; i < kids.size(); i++) {
                    System.out.println(i + " " + kids.get(i));
                }

            } else if (choice == 2) {
                for (int i = 0; i < kids.size(); i++) {
                    System.out.println(i + " " + kids.get(i));
                }
                System.out.print("\nSelect the child you want to add a nice action to: ");
                int children = kb.nextInt();
                System.out.print("\nEnter a description of the nice action: ");
                String action = kb.next() + kb.nextLine();
                nice.get(kids.get(children)).add(action);
                kids.get(children).setNiceornaughty(nice.get(kids.get(children)).size() - naughty.get(kids.get(children)).size());
                printNaughtyorNice(kids, nice, naughty);
                System.out.println();

            } else if (choice == 3) {
                for (int i = 0; i < kids.size(); i++) {
                    System.out.println(i + " " + kids.get(i));
                }
                System.out.print("\nSelect the child you want to add a naughty action to: ");
                int children = kb.nextInt();
                System.out.print("\nEnter a description of the naughty action: ");
                String action = kb.next() + kb.nextLine();
                naughty.get(kids.get(children)).add(action);
                kids.get(children).setNiceornaughty(nice.get(kids.get(children)).size() - naughty.get(kids.get(children)).size());
                printNaughtyorNice(kids, nice, naughty);
                System.out.println();

            } else if (choice == 4) {
                System.out.println();
                System.out.println(updateNiceONaughty(kids, nice, naughty, stocking));

                
            } else if (choice == 5) {
                for (int i = 0; i < kids.size(); i++) {
                    santaRoute.add(kids.get(i));
                }
                while (!santaRoute.isEmpty()) {
                    Kids person = santaRoute.remove();
                    System.out.print(person.getName() + person.getAddress() + stocking.get(person).size());
                    if (stocking.get(person).isEmpty() || stocking.get(person).peek().indexOf("coal") >= 0) {
                        System.out.print(" lump(s) of coal");
                    } else {
                        System.out.print(" present(s)");
                    }
                    System.out.println();
                }
            }
        }
    }
    public static ArrayList<Kids> makeChild(){
        ArrayList<Kids> identifiers = new ArrayList<Kids>();
        String[] names = {"kush", "atul", "bonsall", "micheal", "Swain", "Bob", "Quinn", "Sion", "Urgot", "Ryze"};
        Integer[] ages = {17,27,32,43,31,12,4,2,12,55};
        String[] locations = {"kush street 1211", "bush street 321231", "lush street 438920", "dush boulavard 18282", "atul street 12921", "atul highway 12112", "rush drive 109201", "ratul dash 19191", "iush lane 321", "qush boulavard 19191"};
        for(int i = 0; i<10; i++){
            identifiers.add(new Kids(ages[i], names[i], locations[i]));
        }
        return identifiers;
    }
    public static void printNaughtyorNice(ArrayList<Kids> kids, Map<Kids, ArrayList<String>> nice, Map<Kids, ArrayList<String>> naughty) {
        System.out.println("\nNice");
        for (int i = 0; i < kids.size(); i++) {
            System.out.println(kids.get(i).getName() + " " + nice.get(kids.get(i)));
        }
        System.out.println("\nNaughty");
        for (int i = 0; i < kids.size(); i++) {
            System.out.println(kids.get(i).getName() + " " + naughty.get(kids.get(i)));
        }
    }

    public static String updateNiceONaughty(ArrayList<Kids> kids, Map<Kids, ArrayList<String>> nice, Map<Kids, ArrayList<String>> naughty, Map<Kids, Stack<String>> stocking) {
        String out = "\n" + "List of Presents";
        for (int i = 0; i < kids.size(); i++) {
            Stack<String> childsStocking = stocking.get(kids.get(i));
            if (kids.get(i).getNiceornaughty() <= 0) {

                if (childsStocking.isEmpty() || childsStocking.peek().indexOf("coal") >= 0) {
                    childsStocking.push("coal");
                } else {
                    childsStocking.pop();
                }
            } else {
                if (childsStocking.isEmpty() || childsStocking.peek().indexOf("present") >= 0) {
                    childsStocking.push("present");
                } else {
                    childsStocking.pop();
                }
            }
            out += "\n"+(kids.get(i).getName() + childsStocking);
        }
        return out;
    }


}
   
   