package zadachi;

public class useVector2d {
    public static void main(String[] args) {
        Vector2D vector = new Vector2D(13, 21);
        Vector2D vector1 = new Vector2D(3, 15);
        System.out.println(vector.toString());
        System.out.println(vector1.toString());
        vector.mult2(12);
        System.out.println(vector1.toString());
    }
}
