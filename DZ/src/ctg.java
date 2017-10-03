import  java.util.Scanner;

public class ctg{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, i=1 ;
        double t=1;
        double l=Math.tan(i);
        n=sc.nextInt();
        for(i=1;i<=n;i++) {
            t=t+(1/l);
        }
        System.out.println(t);
    }
}
