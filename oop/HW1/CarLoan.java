import java.util.Scanner;

public class CarLoan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vay = scanner.nextDouble();
        double nam = scanner.nextDouble();
        double laisuatnam = scanner.nextDouble();
        double thang = nam * 12;
        double laisuatthang = (laisuatnam / 100) / 12;
        double tra1thang = (vay * laisuatthang) / (1 - Math.pow(1 + laisuatthang, -thang));
        double lai = tra1thang * thang - vay;
        System.out.println(tra1thang);
        System.out.println(lai);
    }
}
