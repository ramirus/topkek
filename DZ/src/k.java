import  java.util.Scanner;
//11 г
public class k {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i = 1;
        double v = 1, l = (Math.sin(i) / Math.cos(i));
        n = sc.nextInt();
        for (i = 1; i <= n; i++) {   //вы трассировку делали?
            v = v * l;
            l *= l;
            System.out.println(v);
        }
    }
}
