package massiv;
//13 3
public class _zadacha_13_3_ {
    public static void main(String[] args) {
        int k = 1;
        int b[] = {2, 2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7};
        int v[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 1; i < b.length; i++) {
            if (b[i] != b[i +1]) {
                k++;
                v[k-1] += 1;
            }
            if(b[i]!=b[i+2]){
                k++;
                v[k-1]+=1;
            }
            k=1;
        }
        for(int i=0; i<b.length; i++){
        System.out.print(v[i]+" ");
        }
    }
}
