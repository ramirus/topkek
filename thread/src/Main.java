import java.util.Random;
import java.util.Scanner;

public class Main {
    int sumThreads;
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int array[] = new int[n];

    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        int sumThreads = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        int sumFor = 0;
        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt(1000);
            sumFor += array[i];
        }
        System.out.println("For " + sumFor);
        int k = sc.nextInt();
        MyThread myThread[] = new MyThread[k];
        for (int i = 0; i < k; i++) {
            myThread[i]=new MyThread((n / k) * i, (n / k) * (i + 1), array);
            myThread[i].start();
            myThread[i].join();
            sumThreads+=myThread[i].getSum();
        }
        System.out.println("Thread " + sumThreads);

    }

    public static class MyThread extends Thread {
        private int st, k;
        private int[] array;
        private int sum = 0;

        public MyThread(int st, int k, int[] array) {
            super();
            this.st = st;
            this.k = k;
            this.array = array;
        }

        @Override
        public void run() {
            for (int i = st; i < k; i++) {
                sum += array[i];
            }
        }

        public int getSum() {
            return sum;
        }
    }
}

