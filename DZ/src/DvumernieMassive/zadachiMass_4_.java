package DvumernieMassive;//-

import java.util.Random;
import java.util.Scanner;

public class zadachiMass_4_ {
    public static void showMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ran.nextInt(10);
            }
        }
        showMatrix(matrix);
        boolean f;
        int l = 0;
        int[] b = new int[n];
        for (int i = 0; i < matrix.length; i++) {
            f = false;
            for (int j = 0; j < matrix[i].length && !f; j++) {
                b[j] = matrix[i][j];                               //I did not understand your idea
                for (int k = 0; k < matrix.length; k++) {
                    if (b[j] == matrix[k][0]) {
                        l++;
                    }
                }
            }
        }
        if (l == n) {
            f = true;
            System.out.println(" ");
            System.out.println("В массиве есть одинаковая строка и столбец");
        } else {
            System.out.println(" ");
            System.out.println("В массиве нет одинаковой строки и столбца");
        }
    }
}

