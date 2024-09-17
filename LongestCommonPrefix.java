public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string as a reference
        String prefix = strs[0];

        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // Shrink the prefix until it matches the start of the string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));
    }
}

