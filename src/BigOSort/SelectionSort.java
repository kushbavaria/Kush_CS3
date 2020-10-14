package BigOSort;

import java.util.Arrays;

public class SelectionSort
{
    public static void main(String args[]){
        int[] testone = random(10);
        System.out.println("original: " + Arrays.toString(testone));
        int comp1 = selectionSort(testone);
        System.out.println("comparisons: " + comp1);
        System.out.println("sorted: " + Arrays.toString(testone));
        int[] testtwo = new int[]{1,2,3,4,5,6,7,8,9,10};
        int comp2 = selectionSort(testtwo);
        System.out.println("\nsorted is: " + Arrays.toString(testtwo));
        System.out.println("comparisons: " + comp2);
        int[] testhree = new int[]{10,9,8,7,6,5,4,3,2,1};
        int comp3 = selectionSort(testhree);
        System.out.println("\nsorted is: " + Arrays.toString(testhree));
        System.out.println("comparisons: " + comp3);
        System.out.println("\nsorting 10 lists of n = " + 10);
        int[] test = test(10);
        System.out.println("\nbest: " + test[0] + ", average: " + test[1] + ", worst: " + test[2]);
        System.out.println("\nnlog2n = " + Math.round(10 * Math.log(10)/Math.log(2)) + "\tn^2 = " + ((int)Math.pow(10,2)));
        System.out.println("\nsorting 10 lists of n = " + 100);
        test = test(100);
        System.out.println("\nbest: " + test[0] + ", average: " + test[1] + ", worst: " + test[2]);
        System.out.println("\nnlog2n = " + Math.round(100 * Math.log(100)/Math.log(2)) + "\tn^2 = " + ((int)Math.pow(100,2)));
        System.out.println("\nsorting 10 lists of n = " + 1000);
        test = test(1000);
        System.out.println("\nbest: " + test[0] + ", average: " + test[1] + ", worst: " + test[2]);
        System.out.println("\nnlog2n = " + Math.round(1000 * Math.log(1000)/Math.log(2)) + "\tn^2 = " + ((int)Math.pow(1000,2)));
    }

    public static int selectionSort(int[] a){
        int comparisons = 0;
        for(int i = 0; i < a.length-1; i++){
            int min = i;
            comparisons++;
            for(int j = i + 1; j < a.length; j++){
                if(a[j] < a[min]){
                    comparisons++;
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return comparisons;
    }
    public static int[] random(int nums){
        int[] arr = new int[nums];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * nums) + 1;
        }
        return arr;
    }
    public static int[] test(int nums){
        int[] out = new int[3];
        out[0] = nums;
        for(int i = 0; i < 10; i++){
            int[] rand = random(nums);
            int sort = selectionSort(rand);
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
