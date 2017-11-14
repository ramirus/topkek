package massiv;//+-

import java.util.Scanner;
import java.util.Random;

public class _zadacha15_1_ {
    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);
        Random ran=new Random();
        int n, k = 1, c = 0, min, max;
        System.out.println("введите n");
        n = q.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ran.nextInt(30);
            System.out.print(a[i]+" ");
        }
        for (int i = 0; i < n; i++) {
            b[i] = 0;
        }
        for (int i = 1; i < n; i++) {
            if (a[i] >= a[i - 1]) {
                k++;
            }
            if (a[i] < a[i - 1]) {
                b[c] = k;
                k = 1;
                c++;
            }
            if (i == n - 1) {  //тот же вопрос, что и в 13г.
                b[c] = k;
            }
        }
        min = b[0];
        max = b[0];
        for (int i = 1; i < n; i++) {   //конечно этот проход здесь явно лишний, 
            if (min > b[i]&& b[i]>=1) {  //да еще с такой корявенькой проверкой.
                min = b[i];
            }
            if (max < b[i]) {
                max = b[i];
            }
        }
        System.out.println();
        System.out.println("самая длинная"+max);
        System.out.println("самая короткая"+min);
    }
}
