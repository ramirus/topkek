import  java.util.Scanner;
//11 б
public class k{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, i=1 ;
        double v=1;
          n=sc.nextInt();
        for(i=1;i<=n;i++) {
            v=v*Math.tan(i);
        }
        System.out.println(v);
    }
}
