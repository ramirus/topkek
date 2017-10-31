package massiv;

// 8.1

import java.util.Scanner;
import java.util.Random;

public class _zadacha_8_1_ {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int n, card=0 , q , m;
        System.out.print("введите n");
        m = sc.nextInt();
        int[] s = new int[m];
        int[] t = new int[m];
        int[] t1 = new int[m];
        for(int k = 0; k < m; k++) {
            s[k] = r.nextInt(80);
            System.out.print(s[k] + " ");
        }

        System.out.println(' ');

        for(int k = 0; k < m; k++) {
            t[k] = r.nextInt(80);
            System.out.print(t[k] + " ");
        }

        System.out.println(' ');

        for (int k = 0; k < m; k++){
            q = s[k];
            for ( int i = 0; i < m; i++){
                if (q == t[i]) {
                    t1[k] = 1;
                }
            }
            if (t1[k] == 1) card++;
            System.out.print(t1[k] + " ");
        }
        System.out.print("  "+card);
    }
}
