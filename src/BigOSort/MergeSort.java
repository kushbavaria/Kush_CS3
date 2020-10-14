package BigOSort;

import java.util.Arrays;

public class MergeSort
{
    public static void main(String args[]){
        int[] testone = random(10);
        System.out.println("original: " + Arrays.toString(testone));
        int comp1 = mergeSort(testone,0,testone.length-1);
        System.out.println("comp: " + comp1);
        System.out.println("sorted: " + Arrays.toString(testone));
        int[] testtwo = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("\nsorted is: " + Arrays.toString(testtwo));
        int comp2 = mergeSort(testtwo, 0, testtwo.length-1);
        System.out.println("comp: " + comp2);
        int[] testthree = {10,9,8,7,6,5,4,3,2,1};
        System.out.println("\nsorted is: " + Arrays.toString(testthree));
        int comp3 = mergeSort(testthree, 0, testthree.length-1);
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

    public static int mergeSort(int[] a, int start, int end){
        int comp = 0;
        if(start < end){
            int m = (start+end)/2;
            comp += mergeSort(a, start, m) + mergeSort(a, m+1, end);
            return comp + merge(a, start, m, end);
        }
        return comp;
    }
    public static int[] random(int nums){
       int[] arr = new int[nums];
       for(int i = 0; i < arr.length; i++) {
           arr[i] = (int)(Math.random() * nums) + 1;
       }
       return arr;
    }
    public static int[] test(int nums){
        int[] out = new int[3];
        out[0] = nums;
        for(int i = 0; i < 10; i++){
            int[] rand = random(nums);
            int sort = mergeSort(rand, 0, nums-1);
            out[1] += sort;
            if(sort < out[0]){
                out[0] = sort;
            }
            if(sort > out[2]){
                out[2] = sort;
            }
        }
        out[1] = out[1] / 10;
        return out;
    }
    public static int merge(int[] a, int start, int mid, int end){
        int comp = 0;        
        int left = mid - start + 1; 
        int right = Math.abs(mid - end);
        int[] l = new int[left];
        int[] r = new int[right];
        int lIndex = 0;
        int rIndex = 0; 
        int aIndex = start;
        for (int i = 0; i < left; i++){
            l[i] = a[start + i]; 
        }
        for (int j = 0; j < right; j++){
            r[j] = a[mid + 1 + j]; 
        }
        while (lIndex < left && rIndex < right) 
        { 
            if (l[lIndex] <= r[rIndex]){ 
                a[aIndex] = l[lIndex]; 
                lIndex++; 
                comp++;
            } 
            else{
                a[aIndex] = r[rIndex]; 
                rIndex++; 
                comp++;
            }
            comp++;
            aIndex++; 
        }
        while(lIndex < left){
             a[aIndex] = l[lIndex]; 
             lIndex++;
             aIndex++;
        }
        while (rIndex < right) {
            a[aIndex] = r[rIndex];
            rIndex++;
            aIndex++;
        }
        return comp;
    }
}