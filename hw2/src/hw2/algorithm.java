package hw2;

public class algorithm {

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
        int[][] A = {{3,6}, {5,8}};
        int[] arr = {-2, 0, 1, 2, 3, 5, 7};

        // problem 3
        int indexFound = indexSearch(arr, 0, arr.length);

        System.out.println(indexFound);
    }
}
