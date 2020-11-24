package test_kush;

public class TestRunner
{
    public static void main(String[] args){
        int stomFill = 0;
        int stomMax = 50 + stomFill;
        DigestiveSystem dude = new DigestiveSystem("kush", stomFill, stomMax);
        System.out.println(dude);
        try{
            while(dude.canEat()){
                int foodSize = (int)(Math.random() * 10) + 1;
                System.out.println(dude.eating(foodSize));
                dude.eat(foodSize, false);
                System.out.println( dude.getName() + " has currently" + dude.getCurrentStomach() );
            }

            System.out.println( dude.getName() + " can't eat max capacity exact " );
        }
        catch(FullStomachException e){
            System.out.println( dude.getName() + " can't eat anymore because the guy reached his capacity of " + dude.getStomachSize());
        }

    }
}
