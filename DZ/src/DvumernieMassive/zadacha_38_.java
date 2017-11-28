package DvumernieMassive;
//не доделана
import java.util.Random;
import java.util.Scanner;

public class zadacha_38_ {
    public static void showMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int n, i = 0;
        n = sc.nextInt();
        int a[][] = new int[n][n];
        for (i = 0; i < n; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = ran.nextInt(10);
            }
        }
        showMatrix(a);
        while (i < n) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != a[i + 1][j]) {
                    a[i + 1][j] = a[i + 1][j] * a[i][j] - a[i + 1][j] * a[i][j];
                } else {
                    a[i + 1][j] = 0;
                }
            }
            i++;
        }
        System.out.println(" ");
        showMatrix(a);
    }
}
