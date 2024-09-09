
import java.util.Arrays;

public class Sort012 {
    public static void sortArray(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid]
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high]
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
    	System.out.println("The sorted array, arranged in increasing order of 0s, 1s, and 2s ");
        int[] arr = {0, 1, 2, 1, 0, 2, 1, 0};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}

