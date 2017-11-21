package DvumernieMassive;

import java.util.Scanner;
import java.util.Random;

public class zadacha_037_ {
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
        int  n;
        n = sc.nextInt();
        int A[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = ran.nextInt(10);
            }
        }
        showMatrix(A);
        int x = 0;
        int z = 1;
        for (int i = n - 1; i > -1 && i < n; i--) {
            x++;
            for (int j = x; j < n && j < i; j++) {
                A[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - z; j++) {
                A[i][j] = 0;
            }
            z++;
        }
            System.out.println(" ");
            showMatrix(A);
        }
    }

