package Maps;

import java.util.Arrays;
import java.util.ArrayList;
public class Car
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
    
    public Car(int maxSpee, int CarI, String mode, ArrayList<String> k){
        maxSpeed = maxSpee;
        CarId = CarI;
        model = mode;
        colors = k;
    }

    public int getmaxSpeed(){
        return maxSpeed;
    }
    
    public int getCarId(){
        return CarId;
    }
    

    
    public String getmodel(){
        return model;
    }
    
    public void setmaxSpeed(int s){
        maxSpeed = s;
    }
    
    public void setCarId(int i){
        CarId = i;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> c) {
        colors = c;
    }

    public void setmodel(String m){
        model = m;
    }

    public String toString(){
        return String.format("%s has a max speed of %d miles per hour, and the CarID is %d and the avialable  colors are %s", model, maxSpeed, CarId, colorOrganizer(colors));
    }

    public String colorOrganizer(ArrayList<String> colors){
        String output = "";
        for(int i = 0; i < colors.size()-1; i++)
            output += colors.get(i) + ", ";
        output += colors.get(colors.size()-1);
        return output;
    }
}