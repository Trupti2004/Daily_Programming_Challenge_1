import java.util.*;

public class StringPermutations {
    
    public static List<String> getPermutations(String s) {
        List<String> result = new ArrayList<>();
        // Convert the string to a character array to process permutations
        char[] charArray = s.toCharArray();
        // Sort the character array to handle duplicates
        Arrays.sort(charArray);
        // Start the permutation process
        backtrack(charArray, result, new boolean[charArray.length], new StringBuilder());
        return result;
    }
    
    private static void backtrack(char[] charArray, List<String> result, boolean[] used, StringBuilder current) {
        if (current.length() == charArray.length) {
            result.add(current.toString());
            return;
        }
        
        for (int i = 0; i < charArray.length; i++) {
            if (used[i]) continue;
            // Skip duplicates
            if (i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1]) continue;
            
            // Mark the character as used
            used[i] = true;
            current.append(charArray[i]);
            
            // Recurse to generate permutations
            backtrack(charArray, result, used, current);
            
            // Backtrack and reset
            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        List<String> permutations = getPermutations(s);
        System.out.println(permutations);
    }
}

