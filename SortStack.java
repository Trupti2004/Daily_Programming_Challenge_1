import java.util.Stack;

public class SortStack {
    
    public static void sort(Stack<Integer> stack) {
        // Base case: if the stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Remove the top element
        int top = stack.pop();

        // Step 2: Sort the remaining stack
        sort(stack);

        // Step 3: Insert the popped element back in sorted order
        sortedInsert(stack, top);
    }

    private static void sortedInsert(Stack<Integer> stack, int element) {
        // If the stack is empty or the element is greater than the top element
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        // If the top element is greater than the element
        int temp = stack.pop();
        sortedInsert(stack, element);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);
        
        sort(stack);
        
        System.out.println("Sorted Stack: " + stack);
    }
}
