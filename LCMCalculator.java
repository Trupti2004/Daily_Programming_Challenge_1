import java.util.Scanner;

public class LCMCalculator {
    
    // Method to calculate GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Method to calculate LCM
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two integers
        System.out.print("Enter first number: ");
        int N = scanner.nextInt();
        System.out.print("Enter second number: ");
        int M = scanner.nextInt();

        // Calculate and print the LCM
        int result = lcm(N, M);
        System.out.println("LCM of " + N + " and " + M + " is: " + result);
        
        scanner.close();
    }
}

