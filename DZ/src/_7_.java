// 7 задача на циклы
public class _7_ {
    public static void main(String[]args){
        int  n=1;
        double ep=0.001, S=1, Pi=3.1415926;
        while(Math.abs(S-(Pi/2))>=ep){
            S=S*(2.0*n/(2.0*n-1.0))*(2.0*n/(2.0*n+1.0));
            n++;
        }
        System.out.println(n);
    }
}

