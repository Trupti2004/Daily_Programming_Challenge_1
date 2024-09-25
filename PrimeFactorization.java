import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        
        // Divide N by 2 to find all factors of 2
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Check for odd factors from 3 to sqrt(n)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // If n is a prime number greater than 2
        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        int N = 18;
        List<Integer> result = primeFactors(N);
        System.out.println(result);  // Output: [2, 3, 3]
    }
}

