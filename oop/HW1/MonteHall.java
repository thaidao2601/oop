import java.util.Scanner;

public class MonteHall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int trytimes = scanner.nextInt();
        int winifchange = 0;
        for (int i = 0; i < trytimes; i++) {
            int gift  = (int) (3 * Math.random());
            int firstchoice = (int) (3 * Math.random());
            int openone;
            do {
                openone = (int) (3 * Math.random());
            } while ((openone == firstchoice) || (openone == gift));
            int secondchoice = 3 - openone - firstchoice;
            if (secondchoice == gift) winifchange++;
        }
        System.out.println(1.0 * winifchange / trytimes);
    }
}
