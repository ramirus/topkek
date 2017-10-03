import  java.util.Scanner;
//11 а
public class ctg{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, i=1 ;
        double t=1;
        double l=Math.tan(i);
        System.out.println("Введите n");
        n=sc.nextInt();
        for(i=1;i<=n;i++) {
            t=t+(1/l);
      /*      1) в задаче нет никаких тангенсов
            2) значение не меняется    */
        }
        System.out.println(t);
    }
}
