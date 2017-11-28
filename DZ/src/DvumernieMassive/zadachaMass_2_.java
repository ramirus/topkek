package DvumernieMassive;

import java.util.Random;
import java.util.Scanner;

public class zadachaMass_2_ {
    public static void showMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void proizMatrix(int mat1[][], int mat2[][], int mat3[][]) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1.length; j++) {
                int Summ = 0;
                for (int k = 0; k < mat1[i].length; k++) {
                    Summ += mat1[j][k] * mat2[k][i];
                }
                mat3[j][i] = Summ;
            }
        }
    }

    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] mat1 = new int[n][n];
        int[][] mat2 = new int[n][n];
        int[][] mat3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                mat1[i][j] = ran.nextInt(10);
            }
        }
        showMatrix(mat1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mat2[i].length; j++) {
                mat2[i][j] = ran.nextInt(10);
            }
        }
        System.out.println(" ");
        showMatrix(mat2);
        proizMatrix(mat1, mat2, mat3);
        System.out.println(" ");
        showMatrix(mat3);

    }
}
