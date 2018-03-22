import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {

    /*
        public static int[] mergeSort(int[] arr) {
            if (arr.length <= 1) return arr;
            int mid = arr.length / 2;
            int[] leftSize = new int[mid];
            int[] rightSize = new int[mid + arr.length % 2];
            int j = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i < arr.length / 2) {
                    leftSize[i] = arr[i];
                } else {
                    rightSize[j] = arr[i];
                    j++;
                }
            }
            return merge(mergeSort(leftSize), mergeSort(rightSize));
        }

        //переделать чуток , книга Сэджвик
        /*public static int[] merge(int[] left, int[] right) {
            int k = 0;
            int a = 0, b = 0;
            int[] merged = new int[left.length + right.length];
            for (int i = 0; i < left.length + right.length; i++) {
                k++;
                if (b < right.length && a < left.length) {
                    if (left[a] > right[b] && b < right.length) {
                        merged[i] = right[b];
                        b++;
                    } else {
                        merged[i] = left[a];
                        a++;
                    }
                } else if (b < right.length) {
                    merged[i] = right[b];
                    b++;
                } else {
                    merged[i] = left[a];
                    a++;
                }
            }
            System.out.println(k);
            return merged;
        }
    private static int[] a;
*/

    public static void mergeSort(int[] a) {
        int[] a2 = new int[a.length];
        mergeSort(a, a2, 0, a.length - 1);

    }

    private static void mergeSort(int[] a, int[] a2, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, a2, left, mid);
            mergeSort(a, a2, mid + 1, right);
            merge(a, a2, left, mid + 1, right);
        }
    }

    private static int k = 0;

    private static void merge(int[] a, int[] a2, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] < (a[rightPos])) {
                a2[tmpPos++] = a[leftPos++];
            } else {
                a2[tmpPos++] = a[rightPos++];
            }
            k++;
        }
        while (leftPos <= leftEnd) {
            a2[tmpPos++] = a[leftPos++];
            k++;
        }
        while (rightPos <= rightEnd) {
            a2[tmpPos++] = a[rightPos++];
            k++;
        }
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = a2[rightEnd];
            k++;
        }
    }

    public static int[] toArray(int arr[]) {
        int n = arr.length;
        try {
            Scanner sc = new Scanner(new File("input.txt"));
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            sc.close();
            System.out.println("конец");
        } catch (FileNotFoundException e) {
            System.out.println("хэй, файла нет");
            return arr;
        }
        return arr;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Введите размер массива");
        int n = scanner.nextInt();
        int ar[] = new int[n];
        PrintWriter out = new PrintWriter("input.txt");
        out.println(" ");
        for (int i = 0; i < n; i++) {
            ar[i] = random.nextInt(1000);
            String text = Integer.toString(ar[i]);
            out.print(text + " ");
        }
        out.println(" ");
        out.close();
        toArray(ar);
        long start = System.currentTimeMillis();
        mergeSort(ar);
        for (int i = 0; i < n; i++) {
            System.out.print(" " + ar[i]);
        }
        long end = System.currentTimeMillis();
        System.out.println(" время");
        System.out.println("итерации " + k);
        System.out.println(end - start);
    }
}
