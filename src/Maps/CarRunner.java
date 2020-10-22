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

        
        Queue<Car> CarsOrder = new PriorityQueue<Car>();
        for(String x: Cars.keySet())
            CarsOrder.add(Cars.get(x));
        
        while(!CarsOrder.isEmpty())
            System.out.println(CarsOrder.remove() + "\n");
    }
}
