package испр.циклы;
import java.util.Scanner;
public class _30_a {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double x0 , x1, eps = 0.0001, f, f1;
        int n = 1;
        System.out.println("введите число");
        x0 = sc.nextDouble();
        f = 2 * Math.sin(x0 / 2) - x0;
        f1 = 2 * Math.cos(x0 / 2) - 1;
        x1 = x0 - f / f1;
        while (Math.abs(x1 - x0) > eps) {
            x0 = x1;
            f = 2 * Math.sin(x0 / 2) - x0;
            f1 = 2 * Math.cos(x0 / 2);
            x1 = x0 - f / f1;
            n++;
        }
        System.out.println(x1);
    }
}
