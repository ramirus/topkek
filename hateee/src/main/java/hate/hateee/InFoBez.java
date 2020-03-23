package hate.hateee;

public class InFoBez {
    public static void main(String[] args) {
        double P = Math.pow(10, -4);
        double V = 10 * 5;
        double T = 5;
        double A = 36;
        double k = (V * T * A) / P;
        System.out.println(k);
        int j = 1;
        double d=36;
        while (k >= d) {
            d=Math.pow(36,j);
            if(k>=d) {
                j++;
            }
        }
        System.out.println(j);
        String AlphaNumericString = "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(j);
        for (int i = 0; i < j; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        System.out.println(sb.toString());
    }
}
