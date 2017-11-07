package massiv;
public class _zadacha13_ {
    public static void main(String[] args) {
        int  k = 1, c = 0;
        System.out.println("Entering N");
        int[] a ={2, 2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7};
        int[] v ={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < a.length; i++) {
            v[i] = 0;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                k++;
            }
            if (a[i] != a[i - 1]) {
                v[c] = k;
                k = 1;
                c++;
            }
            if (i == a.length - 1) {
                if (a[i] == a[i-1]){
                    v[c] = k;
                }
                if(a[i] != a[i-1]) {
                    v[c]=k;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(v[i] + " ");
        }
    }
}
