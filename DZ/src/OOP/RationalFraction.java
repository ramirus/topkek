package OOP;

//050
public class RationalFraction {
    private int x;
    private int y;

    public RationalFraction() {
        int x = 0;
        int y = 0;
    }

    public RationalFraction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void reduce() {
        if (y != 0) {
            double m = this.x / this.y;
        }
    }

    public RationalFraction add(RationalFraction rationalFunction) {
        RationalFraction sum = new RationalFraction();
        sum.x = rationalFunction.x * this.y + rationalFunction.y * this.x;
        sum.y = rationalFunction.y * this.y;
        reduce();
        return sum;
    }

    public void add2(RationalFraction rationalFunction) {
        this.x += (rationalFunction.y * this.x + rationalFunction.x);
        this.y *= rationalFunction.y;
        reduce();
    }

    public RationalFraction sub(RationalFraction rationalFunction) {
        RationalFraction sum = new RationalFraction();
        sum.x = rationalFunction.x * this.y - rationalFunction.y * this.x;
        sum.y = rationalFunction.y * this.y;
        reduce();
        return sum;
    }

    public void sub2(RationalFraction rationalFunction) {
        this.x -= (rationalFunction.y * this.x - rationalFunction.x);
        this.y *= rationalFunction.y;
        reduce();
    }

    public RationalFraction mult(RationalFraction rationalFunction) {
        RationalFraction pr = new RationalFraction();
        pr.x = this.x * rationalFunction.x;
        pr.y = this.y * rationalFunction.y;
        reduce();
        return pr;
    }

    public void mult2(RationalFraction rationalFunction) {
        this.x *= rationalFunction.x;
        this.y *= rationalFunction.y;
    }

    public RationalFraction div(RationalFraction rationalFunction) {
        RationalFraction dive = new RationalFraction();
        dive.x = this.x * rationalFunction.y;
        dive.y = this.y * rationalFunction.x;
        reduce();
        return dive;
    }

    public void div2(RationalFraction rationalFunction) {
        this.x *= rationalFunction.y;
        this.y *= rationalFunction.x;
        reduce();
    }

    public int numberPart() {
        RationalFraction zC = new RationalFraction();
        int cel = x / y;
        return numberPart();
    }

    public boolean equals(RationalFraction rationalFraction) {
        return super.equals(((RationalFraction) rationalFraction).y) && super.equals(((RationalFraction) rationalFraction).y);
    }

    @Override
    public String toString() {
        return x + "/" + y;
    }

    public static void main(String[] args) {
        RationalFraction a = new RationalFraction(1, 3);
        RationalFraction b = new RationalFraction(1, 6);
        RationalFraction c = new RationalFraction(1, 2);
        System.out.println(true == c.equals(a.add(b)));
    }
}
