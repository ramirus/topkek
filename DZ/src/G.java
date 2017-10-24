import java.util.Scanner;
// 10 г
public class G {
    public static int power(double a, double b){
        int result = 1;
        int temp = (int)b;
        for(int i=temp; i>0; i--){
            result *= a;
        }
        return result;}

    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int n;
        double k=1, x, t=1;
        double S=0 ;
        System.out.println("Введите n");
        n=sc.nextInt();
        System.out.println("Введите х");
        x=sc.nextInt();
        for(k=1; k <=2*n; k++) {

            t=1;
            int temp=(int)k;
            if(k%2==0)
            {
                for(temp=2;temp<=k;temp+=2){t*=temp;}

            }
            else for(temp=1;temp<=k;temp+=2) {t*=temp;}


            S=S+power( x , k)/t;


            for(k= 2; k<=n; k++){
                if (k%2 !=0)
                    t*= k;
                }
             S=S+power( x , k)/t;

        }
        System.out.println(S);
    }

}
//такое решение меня не устраивает
