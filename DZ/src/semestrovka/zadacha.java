package semestrovka;

import java.util.Scanner;

//1.4 гг
public class zadacha {
    public static void main(String[] args) {
        int n;
        double y, x1, x2, x3, x, u0 = 1, u;
        Scanner sc = new Scanner(System.in);
        System.out.println("введите n");
        n = sc.nextInt();//23
        System.out.println("введите x1");
        x1 = sc.nextDouble();//-0,4
        x = x1;
        y = 3.5 * (Math.sin(x) * Math.sin(x)) - 2.7 * (Math.cos(x) * Math.cos(x)) + 1.0;
        for (int j = 0; j < n; j++) {
            u = (2.0 / 3.0) * u0 + y / (3.0 * (u0 * u0));
            u0 = u;
        }
        System.out.println();
        System.out.println("первый корень" + u0);
        System.out.println("введите x2");
        x2 = sc.nextDouble();//2,4
        x = x2;
        y = 3.5 * (Math.sin(x) * Math.sin(x)) - 2.7 * (Math.cos(x) * Math.cos(x)) + 1.0;
        for (int j = 0; j < n; j++) {
            u = (2.0 / 3.0) * u0 + y / (3.0 * (u0 * u0));
            u0 = u;
        }
        System.out.println();
        System.out.println("второй корень" + u0);
        System.out.println("введите x3");
        x3 = sc.nextDouble();//5
        x = x3;
        y = 3.5 * (Math.sin(x) * Math.sin(x)) - 2.7 * (Math.cos(x) * Math.cos(x)) + 1.0;
        for (int j = 0; j < n; j++) {
            u = (2.0 / 3.0) * u0 + y / (3.0 * (u0 * u0));
            u0 = u;
        }
        System.out.println();
        System.out.println("второй корень" + u0);

    }
}