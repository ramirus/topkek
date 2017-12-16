package испр.испр.ООП;


public class Matrix2x2 {
    private double Mmatrix2x2[][] = new double[2][2];

    public Matrix2x2() {
        matrix2x2(0);
    }

    public Matrix2x2(double x) {
        matrix2x2(x);
    }

    public Matrix2x2(double[][] Mmatrix2x2) {
        this.Mmatrix2x2 = Mmatrix2x2;
    }

    public Matrix2x2(double x, double y, double z, double w) {
        Mmatrix2x2[0][0] = x;
        Mmatrix2x2[0][1] = y;
        Mmatrix2x2[1][0] = z;
        Mmatrix2x2[1][1] = w;
    }

    public Matrix2x2 add(Matrix2x2 rmatrix2x2) {
        Matrix2x2 nm = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < 2; k++) {
                nm.Mmatrix2x2[i][k] = this.Mmatrix2x2[i][k] + rmatrix2x2.Mmatrix2x2[i][k];
            }
        }
        return nm;
    }

    public void add2(Matrix2x2 matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.Mmatrix2x2[i][j] = this.Mmatrix2x2[i][j] + matrix.Mmatrix2x2[i][j];
            }
        }
    }

    public Matrix2x2 sub(Matrix2x2 matrix) {
        Matrix2x2 m = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.Mmatrix2x2[i][j] = this.Mmatrix2x2[i][j] - matrix.Mmatrix2x2[i][j];
            }
        }
        return m;
    }

    public void sub2(Matrix2x2 matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.Mmatrix2x2[i][j] -= matrix.Mmatrix2x2[i][j];
            }
        }
    }

    public Matrix2x2 multNumber(double a) {
        Matrix2x2 m = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.Mmatrix2x2[i][j] *= a;
            }
        }
        return m;
    }

    public void multNumber2(double a) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.Mmatrix2x2[i][j] *= a;
            }
        }
    }

    public Matrix2x2 mult(Matrix2x2 matrix) {
        Matrix2x2 m = new Matrix2x2();
        for (int line = 0; line < 2; line++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < this.Mmatrix2x2.length; k++) {
                    m.Mmatrix2x2[line][j] += this.Mmatrix2x2[line][k] * matrix.Mmatrix2x2[k][j];
                }
            }
        }
        return m;
    }

    public void mult2(Matrix2x2 matrix) {
        double[][] m = new double[2][2];
        for (int line = 0; line < 2; line++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    m[line][j] += this.Mmatrix2x2[line][k] * matrix.Mmatrix2x2[k][j];
                }
            }
        }
        this.Mmatrix2x2 = m;
    }

    public double det() {
        return Mmatrix2x2[0][0] * Mmatrix2x2[1][1] - Mmatrix2x2[0][1] * Mmatrix2x2[1][0];
    }

    public void transpon() {
        double a = Mmatrix2x2[0][1];
        Mmatrix2x2[0][1] = Mmatrix2x2[1][0];
        Mmatrix2x2[1][0] = a;
    }

    public Matrix2x2 inverseMatrix() {
        Matrix2x2 m = new Matrix2x2();
        if (this.det() != 0) {
            m.Mmatrix2x2[0][0] = Mmatrix2x2[1][1] / det();
            m.Mmatrix2x2[0][1] = -Mmatrix2x2[1][0] / det();
            m.Mmatrix2x2[1][0] = -Mmatrix2x2[0][1];
            m.Mmatrix2x2[1][1] = Mmatrix2x2[0][0];
            m.transpon();
            return m;
        }
        System.out.println("Error");
        return m;
    }

    public void matrix2x2(double a) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Mmatrix2x2[i][j] = a;
            }
        }
    }
}
