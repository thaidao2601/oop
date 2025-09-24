import java.util.Scanner;

public class InversePermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.trim().split("\\s+");
        int n = parts.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (a[i] < 0 || a[i] >= n) {
                System.out.println("Error: value out of range");
                return;
            }
            if (seen[a[i]]) {
                System.out.println("Error: duplicate value, not a permutation");
                return;
            }
            seen[a[i]] = true;
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[a[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(b[i]);
            if (i < n - 1) System.out.print(" ");
        }
        System.out.println();
    }
}