import java.lang.Math;

public class Shapes {
    public static void main(String[] args) {
        Polygon p;
        p = new Triangle(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        System.out.println("Area: " + p.area());
        System.out.println("Perimeter: " + p.perimeter());
    }
}

interface Polygon {
    double area();
    double perimeter();
}

class Triangle implements Polygon {
    final private double a;
    final private double b;
    final private double c;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Side lengths must be positive.");
        }
        if (!Double.isFinite(a) || !Double.isFinite(b) || !Double.isFinite(c)) {
            throw new IllegalArgumentException("Side lengths must be finite.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Triangle inequality must be satisfied.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @SuppressWarnings("unused")
    public double getA() {
        return a;
    }
    @SuppressWarnings("unused")
    public double getB() {
        return b;
    }
    @SuppressWarnings("unused")
    public double getC() {
        return c;
    }
    @Override
    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}
