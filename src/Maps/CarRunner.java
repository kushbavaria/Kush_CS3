package Maps;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.PriorityQueue;

public class CarRunner
{
    public static void main(String[] args){
        Map<String, Car> Cars = new HashMap<String, Car>();
        Cars.put("Ford F150", new Car(100, 2883493, "Ford F150", "Red", "Blue", "Green", "Grey", "Organge"));
        Cars.put("Audi A4", new Car(150, 1182923 , "Audi A4", "White", "Black", "Grey", "Silver", "Marros"));



        System.out.println(Cars.keySet() + "\n");
        System.out.println(Cars.get("Ford F150") + "\n");
        System.out.println(Cars.get("Audi A4") + "\n");
    }
}
