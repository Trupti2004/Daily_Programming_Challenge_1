import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        reverseStack(stack);

        System.out.println("Reversed Stack: " + stack);
    }

    // Function to reverse the stack using recursion
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Remove the bottom element
        int bottom = stack.pop();
        
        // Recursively reverse the rest of the stack
        reverseStack(stack);

        // Insert the removed element at the bottom
        insertAtBottom(stack, bottom);
    }

    // Helper function to insert an element at the bottom of the stack
    public static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, value);
        stack.push(top);
    }
}
