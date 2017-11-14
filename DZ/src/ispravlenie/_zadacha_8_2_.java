package ispravlenie;//- ничего не поняла

import java.util.Random;
import java.util.Scanner;

public class _zadacha_8_2_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        int m = scanner.nextInt();
        int[] s = new int[m];
        int[] t = new int[m];
        int[] t1 = new int[m];
        int[] t2 = new int[m];
        int card1 = 0, q = 0, card2 = 0, count = 0;
        boolean sooth = false;

        for (int k = 0; k < m; k++) {
            s[k] = r.nextInt(10);
            System.out.print(s[k] + " ");
        }

        System.out.println(' ');

        for (int k = 0; k < m; k++) {
            t[k] = r.nextInt(10);
            System.out.print(t[k] + " ");
        }

        System.out.println(' ');

        for (int k = 0; k < m; k++) {
            q = s[k];
            for (int i = 0; i < m; i++) {
                if (q == t[i]) {
                    t1[k] = 1;
                }
            }
            if (t1[k] == 1) card1++;
            System.out.print(t1[k] + " ");
        }

        System.out.println(' ');

        for (int k = 0; k < m; k++) {
            t[k] = r.nextInt(10);
            System.out.print(t[k] + " ");
        }

        System.out.println(' ');

        for (int k = 0; k < m; k++) {
            q = s[k];
            for (int i = 0; i < m; i++) {
                if (q == t[i]) {
                    t2[k] = 1;
                }
            }
            if (t2[k] == 1) card2++;
            System.out.print(t2[k] + " ");
        }

        System.out.println(' ');

        for (int k = 0; k < m; k++) {
            if ( (t1[k] == 1) || (t2[k] == 1))
                System.out.print('1' + " ");
            else System.out.print('0' + " ");
        }

        System.out.println(' ');

        for (int k = 0; k < m; k++) {
            if ( (t1[k] == 1) && (t2[k] == 1))
                System.out.print(t1[k] + " ");
            else System.out.print('0' + " ");
        }

        System.out.println(' ');

        for (int k = 0; k < m; k++) {
            if ( (t1[k] == 1) && (t2[k] == 0))
                System.out.print(t1[k] + " ");
            else System.out.print('0' + " ");
        }
    }
}

