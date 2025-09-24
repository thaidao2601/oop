import java.util.Scanner;

public class PrimeGap {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int bestLen = 0;
        int currLen = 0;

        for (int i = 2; i <= n; i++) {
            if (!isPrime(i)) {
                currLen++;
                if (currLen > bestLen) {
                    bestLen = currLen;
                }
            }
            else {
                currLen = 0;
            }
        }
        System.out.println(bestLen);
        }
    }
