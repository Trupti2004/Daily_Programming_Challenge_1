import java.util.Arrays;

public class MergeSortedArraysInPlace {
    public static void mergeInPlace(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        // Start from the end of arr1 and the start of arr2
        int i = m - 1;
        int j = 0;

        // Traverse from end of arr1 and start of arr2
        while (i >= 0 && j < n) {
            if (arr1[i] > arr2[j]) {
                // Swap elements
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;

                // Sort arr2 to maintain its sorted order
                int key = arr2[j];
                int k = j + 1;
                while (k < n && arr2[k] < key) {
                    arr2[k - 1] = arr2[k];
                    k++;
                }
                arr2[k - 1] = key;
            }
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        System.out.println("Before merge:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));

        mergeInPlace(arr1, arr2);

        System.out.println("After merge:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }
}
