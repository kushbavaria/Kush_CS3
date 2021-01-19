package TowerOfHanoi;

public class TowerRunner
{
    public static void main(String[] args){
        Tower t = new Tower(3);
        t.solve();
        System.out.println(t);
    }
}
