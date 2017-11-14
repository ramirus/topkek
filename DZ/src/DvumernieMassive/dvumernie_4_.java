package DvumernieMassive;

import java.util.Random;
import java.util.Scanner;

//задача 1
public class dvumernie_4_ {

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
        int matrix[][];
        int n, m, t;
        System.out.println("введите размеры матрицы");
        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ran.nextInt(20);
            }
        }
        showMatrix(matrix);
        for(int k=0; k<matrix.length;k++) {
            for (int i = 0; i <= matrix.length - 1; i++) {
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[i][j] < matrix[i][j + 1]) {
                        t = matrix[i][j];
                        matrix[i][j] = matrix[i][j + 1];
                        matrix[i][j + 1] = t;
                    }
                }
            }
        }

        System.out.println();
        System.out.println("переделанная матрица: ");
        showMatrix(matrix);
    }
}

