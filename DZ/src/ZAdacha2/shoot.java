package ZAdacha2;

public class shoot {
    private int x;
    private int y;
    private double radius;

    public shoot(int x, int y) {
        this.x = x;
        this.y = y;
        radius = Radius(x, y);
    }

    private double Radius(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

