package BigOSort;

import java.util.Arrays;

public class InsertionSort
{
    public static void main(String args[]){
        int[] testone = random(10);
        System.out.println("original: " + Arrays.toString(testone));
        int comp = insertionSort(testone);
        System.out.println("comparisons: " + comp);
        System.out.println("sorted: " + Arrays.toString(testone));
        int[] testtwo = new int[]{1,2,3,4,5,6,7,8,9,10};
        int comp2 = insertionSort(testtwo);
        System.out.println("\nsorted is: " + Arrays.toString(testtwo));
        System.out.println("comparisons: " + comp2);
        int[] testthree = new int[]{10,9,8,7,6,5,4,3,2,1};
        int comp3 = insertionSort(testthree);
        System.out.println("\nsorted is: " + Arrays.toString(testthree));
        System.out.println("comparisons: " + comp3);
        System.out.println("\nsorting 10 lists of n = " + 10);
        int[] sort = sort(10);
        System.out.println("\nbest: " + sort[0] + ", average: " + sort[1] + ", worst: " + sort[2]);
        System.out.println("\nnlog2n = " + Math.round(10 * Math.log(10)/Math.log(2)) + "\tn^2 = " + ((int)Math.pow(10,2)));
        System.out.println("\nsorting 10 lists of n = " + 100);
        sort = sort(100);
        System.out.println("\nbest: " + sort[0] + ", average: " + sort[1] + ", worst: " + sort[2]);
        System.out.println("\nnlog2n = " + Math.round(100 * Math.log(100)/Math.log(2)) + "\tn^2 = " + ((int)Math.pow(100,2)));
        System.out.println("\nsorting 10 lists of n = " + 1000);
        sort = sort(1000);
        System.out.println("\nbest: " + sort[0] + ", average: " + sort[1] + ", worst: " + sort[2]);
        System.out.println("\nnlog2n = " + Math.round(1000 * Math.log(1000)/Math.log(2)) + "\tn^2 = " + ((int)Math.pow(1000,2)));
    }
    public static int[] random(int nums){
       int[] arrays = new int[nums];
       for(int i = 0; i < arrays.length; i++){
           arrays[i] = (int)(Math.random() * nums) + 1;
       }
       return arrays;
    }
    public static int insertionSort(int[] a){
        int compare = 0;
        for(int i = 1; i < a.length; i++){
            int place = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > place) { 
                a[j + 1] = a[j]; 
                j--;
                compare++;
            }
            a[j + 1] = place; 
            compare++;
        }
        return compare;
    }
    public static int[] sort(int nums){
        int[] out = new int[3];
        out[0] = nums;
        for(int i = 0; i < 10; i++){
            int[] ran = random(nums);
            int sort = insertionSort(ran);
            out[1] += sort;
            if(sort < out[0]){
                out[0] = sort;
            }
            if(sort > out[2]){
                out[2] = sort;
            }
        }
        out[1] /= 10;
        return out;
    }
}
