public class DivisorCount {
    public static void main(String[] args) {
        int N = 12; // Example input
        int count = 0;

        // Loop to find all divisors
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                // If i divides N, it is a divisor
                count++;
                if (i != N / i) {
                    // If i and N/i are different, count both
                    count++;
                }
            }
        }

        System.out.println("Number of divisors: " + count);
    }
}

