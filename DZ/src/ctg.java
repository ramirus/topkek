import  java.util.Scanner;
//11 б
public class ctg{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, i=0;
        double t=1;
        double l=(Math.cos(i)/Math.sin(i));
        System.out.println("Введите n");
        n=sc.nextInt();
        for(i=0;i<=n;i++) {
            t+=l;
            l*=l;
        }
        System.out.println(t);
    }
}
