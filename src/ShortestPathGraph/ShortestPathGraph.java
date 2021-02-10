package ShortestPathGraph;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Kush

import java.util.TreeMap;
import java.util.Scanner;

public class ShortestPathGraph {
    private TreeMap<String, String> map;
    private int shortest;
    public ShortestPathGraph(String line) {
        shortest = Integer.MAX_VALUE;
        map = new TreeMap<String, String> ();
        Scanner edges = new Scanner(line);
        while (edges.hasNext()) {
            String kush = edges.next();
            String first = kush.substring(0, 1);
            String next = kush.substring(1);
            if (!map.containsKey(first)) {
                map.put(first, next);
            } else {
                map.put(first, map.get(first) + next);
            }
            if (!map.containsKey(next)) {
                map.put(next, first);
            } else {
                map.put(next, map.get(next) + first);
            }
        }
    }
    public void check(String first, String second, String placesUsed, int steps) {
        if (first.equals(second) && steps<shortest) {
            shortest = steps;
        } else {
            String edges = map.get(first);
            for (int i = 0; i<edges.length(); i++) {
                if (placesUsed.indexOf(edges.substring(i, i + 1)) == -1) {
                    check(edges.substring(i, i + 1), second, placesUsed += first, steps + 1);
                }
            }
        }
    }
    public String toString() {
        if (shortest != Integer.MAX_VALUE) {
            return "yes in " + shortest  + " steps";
        } else {
            return "no";
        }
    }
}