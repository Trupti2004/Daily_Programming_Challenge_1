import java.util.HashMap;

public class CountSubstringsKDistinct {
    
    // Helper method to count substrings with at most K distinct characters
    private static int countAtMostKDistinct(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int left = 0, count = 0;
        
        for (int right = 0; right < n; right++) {
            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

            // Shrink the window until we have at most k distinct characters
            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }
            // Add the number of substrings with at most k distinct characters
            count += right - left + 1;
        }
        return count;
    }

    // Main method to count substrings with exactly K distinct characters
    public static int countExactlyKDistinct(String s, int k) {
        // The number of substrings with exactly k distinct characters is:
        // (substrings with at most k distinct characters) - (substrings with at most k-1 distinct characters)
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }

    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;
        System.out.println(countExactlyKDistinct(s, k));  // Output: 7
    }
}

