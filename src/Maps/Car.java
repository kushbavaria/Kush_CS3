package Maps;

import java.util.Arrays;
import java.util.ArrayList;
public class Car implements Comparable<Car>
{
    private int maxSpeed;
    private int CarId;
    private ArrayList<String> colors;
    private String model;
    
    public Car(){
        this.maxSpeed = 90;
        this.CarId = 123456;
        this.model = "Honda Civic";
        this.colors = new ArrayList<String>();
    }
    
    public Car(int maxSpee, int CarI, String mode, String ... color){
        maxSpeed = maxSpee;
        CarId = CarI;
        model = mode;
        colors = new ArrayList<String>(Arrays.asList(color));
    }
    
    public int compareTo(Car b){
        if(this.getmaxSpeed() == b.getmaxSpeed())
                return this.getmodel().compareTo(b.getmodel());
            else
                if(this.getmaxSpeed() < b.getmaxSpeed())
                    return -1;
                else
                    return 1;
    }
    
    public int getmaxSpeed(){
        return maxSpeed;
    }
    
    public int getCarId(){
        return CarId;
    }
    
    public ArrayList<String> getcolors(){
        return colors;
    }
    
    public String getmodel(){
        return model;
    }
    
    public void setmaxSpeed(int g){
        maxSpeed = g;
    }
    
    public void setCarId(int s){
        CarId = s;
    }
    
    public void setcolors(String ... c){
        colors = new ArrayList<String>(Arrays.asList(c));;
    }
    
    public void setmodel(String f){
        model = f;
    }
    
    public String format(ArrayList<String> colors){
        String output = "";
        for(int i = 0; i < colors.size()-1; i++)
            output += colors.get(i) + ", ";
        output += colors.get(colors.size()-1);
        return output;
    }
    
    public String toString(){
        return String.format("%s has a max speed of %d miles per hour, and the CarID is %d and the avialable  colors are %s", model, maxSpeed, CarId, format(colors));
    }
}