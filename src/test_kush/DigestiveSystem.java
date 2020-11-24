package test_kush;

public class DigestiveSystem {
    private int currentStomach;
    private int stomachSize;
    private String name;
    
    public DigestiveSystem(String n, int cs, int ss){
        name = n;
        currentStomach = cs;
        stomachSize = ss;
    }

    public void eat(int ounces, boolean spicy) throws FullStomachException{
        if(currentStomach + ounces > stomachSize){
            throw new FullStomachException();
        }
        currentStomach += ounces;
    }
    
    public String getName(){

        return name;
    }
    
    public int getCurrentStomach(){

        return currentStomach;
    }
    
    public int getStomachSize(){

        return stomachSize;
    }
    
    public boolean canEat(){

        return getCurrentStomach() < getStomachSize();
    }
    
    public String eating(int foodSize){
        return  name + " got  " + foodSize ;
    }
    
    public String toString(){
        return  name + " has a  max capacity of " + stomachSize + " currently " + currentStomach ;
    }
}
