import java.util.HashSet;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        // Initialize a set to store characters of the current substring
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;
        
        // Loop through the string
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                // If the character is not in the set, add it and move right pointer
                set.add(s.charAt(right));
                right++;
                // Update the maximum length
                maxLength = Math.max(maxLength, right - left);
            } else {
                // If the character is already in the set, remove the leftmost character
                set.remove(s.charAt(left));
                left++;
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        String S = "abcabcbb";
        System.out.println("The length of the longest substring without repeating characters is: " + lengthOfLongestSubstring(S));
    }
}

