package _14_23_24;
import java.util.Scanner;
public class _24b_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double ep = 0.0001, c0 = 0, b0 = 1, b1, c1, c = 1, b=0, S = 0, t = 1;
        int n, x, k = 2, p = 1;
        System.out.println("введите n");
        n = sc.nextInt();
        System.out.println("введите x");
        x = sc.nextInt();
        c1 = Math.sin(x);
        b1 = Math.cos(x);
        while ((k <= n) || (Math.abs(c) >= ep)) {
            t = b / n;
            S += p * t;
            b = (b1 * b0) - (c1 * c0);
            c = c0 * b1 + c1 * b0;
            c0 = c;
            b0 = b;
            k++;
            p = -p;

        }
        System.out.println(S);
    }
}
