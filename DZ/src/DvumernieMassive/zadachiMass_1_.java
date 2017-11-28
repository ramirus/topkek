// не доделана
package DvumernieMassive;

import java.util.Random;
import java.util.Scanner;

public class zadachiMass_1_ {
    public static void showMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void sort(int matrix[][]) {
        int min = 0, r = 0, b = 0;
        for (int i = (matrix.length - 1); i >= 0; i--) {
            min = matrix[i][0];
            r = i;
            for (int j = i - 1; j >= 0; j--) {
                if (matrix[j][0] <= min) {
                    min = matrix[j][0];
                    r = j;
                }
            }
            b = matrix[i][0];
            matrix[i][0] = matrix[r][0];
            matrix[r][0] = b;
        }
    }

    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] matrix = new int[n + 1][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ran.nextInt(10);
            }
        }
        sort(matrix);
        showMatrix(matrix);
        for (int i = 0; i < m; i++) {
            matrix[n][i] = ran.nextInt(10);
        }
        System.out.println(" ");
        showMatrix(matrix);
        boolean f = false;
        int k, p = 0, r = 0;
        for (int i = 0; i < n + 1 && !f; i++) {
            p = matrix[n][i];
            if (p <= matrix[i][0] && p >= matrix[i + 1][0]) {
                f = true;
                r = i;
            }
        }
        System.out.println(" ");
        for (int i = n - 1; i > r; i--) {
            for (int j = 0; j < p; j++) {
                k = matrix[i + 1][j];
                matrix[i + 1][j] = matrix[i][j];
                matrix[i][j] = k;
            }
        }
        for (int i = 0; i < m; i++) {
            matrix[r+1][i] = matrix[n][i];
        }
        showMatrix(matrix);
    }
}