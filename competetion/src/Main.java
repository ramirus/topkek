import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("input.txt");
        Scanner sc = new Scanner(stream);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        System.out.println(n + " " + k + " " + l);

    }

    public static class Scanner {
        private static FileInputStream stream;

        public Scanner(FileInputStream stream) {
            this.stream = stream;
        }

        private static int nextInt() throws IOException {
            int out = 0;
            int k;
            boolean minusCheck = false;
            while (((k = stream.read()) != 32) && k <= 57 && k != -1)
                if (k == '-') {
                    minusCheck = true;
                } else
                    out = out * 10 + (k - 48);
            if (minusCheck) {
                out = -out;
                minusCheck = false;
            }
            return out;
        }
    }
}


