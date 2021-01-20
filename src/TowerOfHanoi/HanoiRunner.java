package TowerOfHanoi;

public class HanoiRunner
{
    public static void main(String[] args){
        TowerofHanoi t = new TowerofHanoi(3);
        t.solve();
        System.out.println(t);
    }
}
