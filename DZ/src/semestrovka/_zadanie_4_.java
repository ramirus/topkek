package semestrovka;
//1.2 ввв

import java.util.Scanner;

public class _zadanie_4_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, j = 1;
        double h, e = 2.71828, z0, z1, y, z, fi = 0, zk;
        System.out.println("введите h");//0.7
        h = sc.nextDouble();
        System.out.println("введите z0");//0.5
        z0 = sc.nextDouble();
        System.out.println("введите z1");//-2.7
        z1 = sc.nextDouble();
        System.out.println("введите n");//50
        n = sc.nextInt();
        System.out.println("введите m");//9
        m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            y = -(z1 * z1 + 2.0 * z0 + 0.7);
            z = Math.exp(y);
            while (j <= m) {
                zk = z * z;
                if (zk < j * h && zk >= ((j - 1) * h)) {
                    fi += z;
                    j++;
                    System.out.println("fi=" + fi);
                }
            }
            z1 = z0;
            z0 = z;
        }
    }
}