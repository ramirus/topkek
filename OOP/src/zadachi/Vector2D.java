package zadachi;

public class Vector2D {
    double x, y, r;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(Vector2D vector) {
        Vector2D vec = new Vector2D();
        vec.x = vector.x + this.x;
        vec.y = vector.y + this.y;
        return vec;
    }

    public void add2(Vector2D vector) {
        this.x += vector.x;
        this.y += vector.y;
    }

    public Vector2D sub(Vector2D vector) {
        Vector2D pl = new Vector2D();
        pl.x = vector.x - this.x;
        pl.y = vector.y - this.y;
        return pl;
    }

    public void sub2(Vector2D vector) {
        this.x -= vector.x;
        this.y -= vector.y;
    }

    public Vector2D mult(double k) {
        Vector2D pl = new Vector2D();
        pl.x *= k;
        pl.y *= k;
        return pl;
    }

    public void mult2(double k) {
        this.x *= k;
        this.y *= k;
    }

    double dl;

    public double lenght(double x, double y) {
        Vector2D leng = new Vector2D();
        leng.dl = Math.sqrt(x * x + y * y);
        return leng.dl;
    }

    public double scalarProduct(double x, double y) {
        Vector2D sc = new Vector2D();
        sc.x = x * x;
        sc.y = y * y;
        sc.r = sc.x + sc.y;
        return sc.r;
    }

double cos;
    public double cos(Vector2D vector) {
        Vector2D cs = new Vector2D();
        double m, l;
        l = Math.sqrt(this.x * this.x + vector.x * vector.x);
        m = Math.sqrt(this.y * this.y + vector.y * vector.y);
        cs.cos = (this.x * vector.x + this.y * vector.y) / (m * l);
        return cs.cos;
    }
}
