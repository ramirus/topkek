package OOP;

//051
public class ComplexNumber {
    private double a; //действительная часть
    private double b;//мнимая часть

    public ComplexNumber() {
        double a = 0;
        double b = 0;
    }

    public ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public ComplexNumber add(ComplexNumber complexNumber) {
        ComplexNumber cN = new ComplexNumber();
        double a, b;
        cN.a = complexNumber.a + this.a;
        cN.b = complexNumber.b + this.b;
        return cN;
    }

    public void add2(ComplexNumber complexNumber) {
        this.a += complexNumber.a;
        this.b += complexNumber.b;
    }

    public ComplexNumber multNumber(double x) {
        ComplexNumber pl = new ComplexNumber();
        pl.a *= x;
        pl.b *= x;
        return pl;
    }

    public void multNumber2(double k) {
        this.a *= k;
        this.b *= k;
    }

    public ComplexNumber mult(ComplexNumber complexNumber) {
        ComplexNumber pl = new ComplexNumber();
        pl.a = (complexNumber.a + complexNumber.b) * this.a;
        pl.b = (complexNumber.b + complexNumber.b) * this.b;
        return pl;
    }

    public void mult2(ComplexNumber complexNumber) {
        this.a *= complexNumber.a + complexNumber.b;
        this.b *= complexNumber.b + complexNumber.a;
    }

    public ComplexNumber div(ComplexNumber complexNumber) {
        ComplexNumber pl = new ComplexNumber();
        pl.a = complexNumber.a / this.a;
        pl.b = complexNumber.b / this.b;
        return pl;
    }

    public void div2(ComplexNumber complexNumber) {
        this.a /= complexNumber.a;
        this.b /= complexNumber.b;
    }

    public double lenght() {
        double lenght = Math.sqrt(this.a * this.a + this.b * this.b);
        return lenght();
    }

    public double arg() {
        double l = this.b / this.a;
        double ar = Math.atan(l);
        return arg();
    }

    public ComplexNumber powe(double m) {
        double powe;
        double l = Math.sqrt(this.a * this.a + this.b * this.b);
        double ar = Math.atan(l);
        powe = Math.pow(l, m) * (Math.cos(m * ar) + Math.sin(m * ar));
        return powe(m);
    }

    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(1, 3);
        ComplexNumber b = new ComplexNumber(1, 6);
    }
}