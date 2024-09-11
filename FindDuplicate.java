public class FindDuplicate {
    
    public static int findDuplicate(int[] arr) {
        
        int tortoise = arr[0];
        int hare = arr[0];
        
        
        do {
            tortoise = arr[tortoise]; 
            hare = arr[arr[hare]]; 
        } while (tortoise != hare);
        
        
        tortoise = arr[0]; 
        while (tortoise != hare) {
            tortoise = arr[tortoise]; 
            hare = arr[hare];
        }
        
        
        return hare;
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {1, 3, 4, 2, 2};
        int[] arr2 = {3, 1, 3, 4, 2};
        int[] arr3 = {1, 1};
        int[] arr4 = {1, 4, 4, 2, 3};
        int[] arr5 = new int[100001];
        for (int i = 1; i <= 100000; i++) {
            arr5[i - 1] = i;
        }
        arr5[100000] = 50000;
        
        System.out.println("Test Case 1: Duplicate number: " + findDuplicate(arr1)); 
        System.out.println("Test Case 2: Duplicate number: " + findDuplicate(arr2)); 
        System.out.println("Test Case 3: Duplicate number: " + findDuplicate(arr3)); 
        System.out.println("Test Case 4: Duplicate number: " + findDuplicate(arr4)); 
        System.out.println("Test Case 5: Duplicate number: " + findDuplicate(arr5)); 
    }
}
