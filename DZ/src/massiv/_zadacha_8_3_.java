package massiv;//-

import java.util.Random;
import java.util.Scanner;

public class _zadacha_8_3_ {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int n, card = 0, q, m;
        System.out.print("введите n");
        m = sc.nextInt();
        int[] s = new int[m];
        int[] s1 = new int[m];
        int[] t = new int[m];
        int[] t1 = new int[m];
        int[] t2 = new int[m];
        for (int k = 0; k < m; k++) {
            s[k] = r.nextInt(80);
            System.out.print(s[k] + " ");
        }

        System.out.println(' ');

        for (int k = 0; k < m; k++) {
            t[k] = r.nextInt(80);
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
            if (t1[k] == 1) ;
            System.out.print(t1[k] + " ");
        }
        for (int k = 0; k < m; k++) {
            q = s[k];
            for (int i = 0; i < m; i++) {
                if (q == t[i]) {
                    t2[k] = 1;
                }
            }
            if (t2[k] == 1) ;
            System.out.print(t2[k] + " ");
        }
        System.out.println(" ");
        System.out.println("пересечение векторов ");

        for (int k = 0; k < m; k++) //пересечение векторов
        {
            if (t1[k] == t2[k] && t1[k] == 1) {
                System.out.print(t1[k] + " ");
            } else {
                System.out.print("0 ");
            }
        }
        System.out.println(" ");
        System.out.println("объединение векторов ");
        for (int k = 0; k < m; k++) //объединение векторов
        {
            if (t1[k] == 1 || t2[k] == 1) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
        System.out.println(" ");
        System.out.println("разность векторов ");
        for (int k = 0; k < m; k++) //разность векторов
        {
            if (t1[k] == 1 && t2[k] == 0) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }

        System.out.println(' ');
    }
}   //опять принты
