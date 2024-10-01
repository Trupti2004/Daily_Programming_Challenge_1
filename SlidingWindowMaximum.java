import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(result));
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || k <= 0) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of this window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove smaller elements as they are useless
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add current element at the end
            deque.offer(i);

            // Add the maximum of the current window to the result
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peek()];
            }
        }

        return result;
    }
}
