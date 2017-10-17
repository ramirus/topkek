package _14_23_24;

import java.util.Scanner;
public class _14_b {
    public static void main(String[] args) {
        double S = 0, ep = 0.001, x, t = 1;
        int k = 1, a;
        Scanner sc = new Scanner(System.in);
        System.out.println("введите х");
        x = sc.nextDouble();
        System.out.println("введите a");
        a = sc.nextInt();
        while (t >= ep) {
            S += t * Math.log10(t * x);
            t *= 1.0 / a;

        }
        System.out.println(S);
    }
}