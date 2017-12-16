package испр.массивы;

import java.util.Scanner;
import java.util.Random;

public class zadacha_22_5_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int n = sc.nextInt();
        int[] a = new int[n];
        int el = 0;
        boolean f = true;
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10);
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < n; i++) {
            f = true;
            for (int j = 0; j < n; j++) {
                if (i != j && a[i] == a[j])
                    f = false;
            }
            if (f)
                el++;
        }

        System.out.println(el);
    }
}
