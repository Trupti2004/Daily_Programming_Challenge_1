import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubarrays{

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        // To store the cumulative sum and its corresponding indices
        HashMap<Integer, List<Integer>> cumSumMap = new HashMap<>();
        // List to store the result subarrays as index pairs (start, end)
        List<int[]> result = new ArrayList<>();
        // Variable to store the cumulative sum
        int cumSum = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            cumSum += arr[i];

            // If the cumulative sum is zero, we found a subarray from index 0 to i
            if (cumSum == 0) {
                result.add(new int[]{0, i});
            }

            // If the cumulative sum has been seen before, we found subarrays summing to zero
            if (cumSumMap.containsKey(cumSum)) {
                // Get all the indices where this sum occurred before
                for (int startIndex : cumSumMap.get(cumSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            // Add the current index to the list of indices for this cumulative sum
            cumSumMap.putIfAbsent(cumSum, new ArrayList<>());
            cumSumMap.get(cumSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> output = findZeroSumSubarrays(arr);

        // Print the result
        for (int[] subarray : output) {
            System.out.println("Subarray found from Index " + subarray[0] + " to " + subarray[1]);
        }
    }
}

