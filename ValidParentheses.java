import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Traverse the string
        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Check for matching closing brackets
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
            // If no match is found or stack is empty
            else {
                return false;
            }
        }
        // If the stack is empty, all parentheses matched correctly
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[{()}]";
        System.out.println(isValid(s));  // Output: true
    }
}

