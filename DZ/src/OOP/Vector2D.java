package OOP;
//049
public class Vector2D {
    double x, y;

    public Vector2D() {
        double x = 0;
        double y = 0;
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
}
