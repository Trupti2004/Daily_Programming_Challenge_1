import java.util.HashMap;

public class FirstElementToRepeatKTimes {
    public static int findElement(int[] arr, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Calculate the frequency of each element
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the first element that appears exactly k times
        for (int num : arr) {
            if (frequencyMap.get(num) == k) {
                return num;
            }
        }

        // If no element is found with exactly k occurrences, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1, 4};
        int k = 2;
        int result = findElement(arr, k);
        System.out.println(result);  // Output: 1
    }
}

