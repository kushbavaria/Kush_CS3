package BigOSort;

import java.util.Arrays;

public class QuickSort
{
    public static void main(String args[]){
        int[] testone = random(10);
        System.out.println("original: " + Arrays.toString(testone));
        int comp1 = quickSort(testone,0,testone.length-1);
        System.out.println("comp: " + comp1);
        System.out.println("sorted: " + Arrays.toString(testone));
        int[] testtwo = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("\nsorted is: " + Arrays.toString(testtwo));
        int comp2 = quickSort(testtwo, 0, testtwo.length-1);
        System.out.println("comp: " + comp2);
        int[] testthree = {10,9,8,7,6,5,4,3,2,1};
        System.out.println("\nsorted is: " + Arrays.toString(testthree));
        int comp3 = quickSort(testthree, 0, testthree.length-1);
        System.out.println("comp: " + comp3);
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
    public static int quickSort(int[] a, int start, int end){
        int kush = 0;
        if(start < end){
            int[] current = partition(a, start, end);
            kush += current[0];
            int pivot = current[1];
            return kush + quickSort(a, start, pivot - 1) + quickSort(a, pivot + 1, end);
        }
        return kush;
    }
    public static int[] random(int number){
        int[] arr = new int[number];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * number) + 1;
        }
        return arr;
    }
    public static int[] test(int number){
        int[] out = new int[3];
        out[0] = number;
        for(int i = 0; i < 10; i++){
            int[] rand = random(number);
            int sort = quickSort(rand, 0, number-1);
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
    public static int[] partition(int[] a, int start, int end){
        int pivot = a[end];
        int kb = end;
        int c = 0;
        for (int j = end - 1; j > start - 1; j--){
            if (pivot < a[j]){
                kb--;
                int t = a[kb];
                a[kb] = a[j];
                a[j] = t;
            }
            c++;
        }  
        int t = a[kb];
        a[kb] = a[end];
        a[end] = t;        
        int[] partitionData = {c,kb};
        return partitionData;
    }
}