import java.util.Scanner;
// 10 г
public class G {
    public static int power(int a, int b){
        int result = 1;
        for(int i=b; i>0; i--){
            result *= a;
        }
        return result;}

    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int k, n, x, t=1;
        int S=0 ;
        System.out.println("Введите n");
        n=sc.nextInt();
        System.out.println("Введите х");
        x=sc.nextInt();
        for(k=1; k <=2*n; k++) {
            for(k= 2; k<=n; k++){
                if (k%2 !=0)
                    t*= k;
                }
             S=S+power( x , k)/t;
  // те же замечания
        }
        System.out.println(S);
    }

}
