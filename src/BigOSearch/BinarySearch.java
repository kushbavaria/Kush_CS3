package BigOSearch;

import java.util.Arrays;

public class BinarySearch {


    public static void main(String[] args) {
        System.out.println("Binary Search");

        int[] bigO = new int[3];

        int[] test10 = makeTest(10);
        System.out.println("original array is: " + Arrays.toString(test10));
        System.out.println("searching for 10 random nums in a list of 10");

        bigO = runTest(test10, 10);
        System.out.println("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);

        int[] test100 = makeTest(100);
        System.out.println("original array is: " + Arrays.toString(test100));
        System.out.println("searching for 100 random nums in a list of 100");

        bigO = runTest(test100, 100);
        System.out.println("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);

        int[] test1000 = makeTest(1000);
        System.out.println("original array is: " + Arrays.toString(test1000));
        System.out.println("searching for 1000 random nums in a list of 1000");

        bigO = runTest(test1000, 1000);
        System.out.println("best: " + bigO[0] + ", average: " + bigO[1] + ", worst: " + bigO[2]);

    }

    public static int binarySearch(int array[], int x, int l, int r) {
        int center = l + (r - l) / 2;
        if (r >= l) {
             if (array[center] == x) {
                return 1;
            } else if (array[center] > x) {
                return 1 + binarySearch(array, x, l, center - 1);
            } else {
                return 1 + binarySearch(array, x, center + 1, r);
            }
        }
        return 1;
    }
    public static int[] runTest(int[] n, int t) {
        int[] answer = new int[3];
         answer[0] = Integer.MAX_VALUE;
         for (int i = 0; i < t; i++) {
             int rand = (int) (Math.random() * n.length) + 1;
             int calc = binarySearch(n, rand, 0, n.length - 1);

             answer[1] += calc;
             if (calc < answer[0]) {
                answer[0] = calc;
             }
             if (calc > answer[2]) {
                  answer[2] = calc;
            }
        }
         answer[1] /= t;
         return answer;
    }
    public static int[] makeTest(int n) {
           int[] r = new int[n];
          for (int i = 0; i < n; i++) {
               r[i] = i + 1;
        }
        return r;
    }
}
