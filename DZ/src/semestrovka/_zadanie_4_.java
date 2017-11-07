package semestrovka;
//1.2 ввв
import java.util.Scanner;

public class _zadanie_4_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m = 9, j = 1;
        double h = 0.7, e = 2.71828, z0, z1, y, z, fi = 0, zk;
        z0 = sc.nextDouble();
        z1 = sc.nextDouble();
        n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            z = -(z1 * z1 + 2.0 * z0 + 0.7);
            y = Math.pow(e, z);
            while (j <= m) {
                zk = z * z;
                if ((zk < j * h) || (zk >= (j - 1) * h) && (j < m)) {
                    fi += y;
                    j++;
                    System.out.println(" fi =" + fi);
                }
            }
            z1 = z0;
            z0 = z;
        }
    }
}
