package BigOSearch;

import java.util.Arrays;

public class LinearSearch
{
    public static void main(String[] args){
        System.out.println("Linear Search");
        
        int[] bigO = new int[3];
        
        int[] test10 = makeTest(10);
        System.out.println("original array is: " + Arrays.toString(test10));
        System.out.println("searching for 10 random nums in a list of 10");
        
        bigO = runTest(test10, 10);
        System.out.println("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);
        
        int[] test100 = makeTest(100);
        System.out.println("original array is: " + Arrays.toString(test100));
        System.out.println("searching for 100 random nums in a list of 10");
        
        bigO = runTest(test100, 100);
        System.out.println("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);
        
        int[] test1000 = makeTest(1000);
        System.out.println("original array is: " + Arrays.toString(test1000));
        System.out.println("searching for 1000 random nums in a list of 10");
        
        bigO = runTest(test1000, 1000);
        System.out.println("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);
        
    }
    public static int[] runTest(int[] n, int a){
          int[] r = new int[3];
           r[0] = Integer.MAX_VALUE;
         for(int i = 0; i < a; i++){
             int random = (int)(Math.random()* n.length) + 1;
             int calc = 0;
              for(int j = 0; j < n.length; j++){
                calc++;
                if(n[j] == random) {
                    break;
                }
            }
            r[1]+= calc;
             if(calc < r[0]) {
                 r[0] = calc;
             }
              if(calc > r[2]) {
                  r[2] = calc;
              }
        }
         r[1]/=a;
          return r;
    }
    public static int[] makeTest(int n){
             int[] r = new int[n];
          for(int i = 0; i < n; i++) {
              r[i] = (int) (Math.random() * n) + 1;
          }
           return r;
    }

}
