package hw2;

import java.lang.Integer;

public class algorithm {


    /**
     * Input: Sorted Array A
     * Design divide-and-conquer alg
     *
     * Define overlap of two intervals in A
     * Return the highest overlap
     */
    public static int recFunction(int[][] A, int index1, int index2, int L) {
        if (index2 >= index1) {
            int middle = index1 + (index2-index1) / 2;

            if (index2 == index1) {
                return 0;
            } else {
                int ValOverlap = (Integer.min(A[index1][1], A[index2][1]) - Integer.max(A[index2][0], A[index1][0])) + 1;

                if(index1 != L) {
                    ValOverlap = Integer.max(ValOverlap, (Integer.min(A[index1][1], A[L][1]) - Integer.max(A[index1][0], A[L][0])) + 1);
                }

                if(index2 != L) {
                    ValOverlap = Integer.max(ValOverlap, (Integer.min(A[index2][1], A[L][1]) - Integer.max(A[index2][0], A[L][0])) + 1);
                }

                if ((A[index1][0] - A[index1][1]) - (A[index2][0] - A[index2][1]) > 0) {
                    if ((A[index1][0] - A[index1][1]) - (A[L][0] - A[L][1]) > 0) {
                        L = index1;
                    } else {
                        L = L;
                    }
                } else {
                    if (A[index2][0] - A[index2][1] - A[L][0] - A[L][1] > 0) {
                        L = index2;
                    } else {
                        L = L;
                    }
                }
                int maxLeft = Integer.max(ValOverlap, recFunction(A, index1, middle, L));
                int maxTotal = Integer.max(maxLeft, recFunction(A, middle + 1, index2, L));
                return maxTotal;
            }

        }
        return -1;
    }

    public void problem4NaiveApproach(int[][] a) {
        int overlapLength;

        for(int i = 0; i < a.length-1; i++) {
            int x1 = a[i][0];
            int x2 = a[i][1];
            int z1 = a[i+1][0];
            int z2 = a[i+1][1];


            if(z1 > x1) {

            }

        }
    }
    /**
     * Algorithm based off of binary search. Instead of looking for a specific value
     * and taking in an additional parameter, just compare the calculated index middle
     * to the value in the array at index middle.
     *
     * Runtime: O(logn) //same as binary search
     *
     * @param arr
     * @param left
     * @param right
     * @return index where the index and value stored at that index are the same
     */
    static int indexSearch(int arr[], int left, int right)
    {
        if (right >= left) {
            int middle = left + (right - left) / 2;

            if (arr[middle] == middle)
                return middle;

            if (arr[middle] > middle)
                return indexSearch(arr, left, middle - 1);

            return indexSearch(arr, middle + 1, right);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        int[][] A = {{3,6}, {5,8}, {10, 20}, {15, 25}};
        //int[] arr = {-2, 0, 1, 2, 3, 5, 7};

        // problem 3
        //int indexFound = indexSearch(arr, 0, arr.length);

        System.out.println(recFunction(A, 0, A.length-1, 0));

        //System.out.println(indexFound);
    }
}
