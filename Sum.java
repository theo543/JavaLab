sealed interface Shape permits Circle, Square, Rectangle {}
record Circle(double radius) implements Shape {}
record Square(double side) implements Shape {}
record Rectangle(double length, double width) implements Shape {}

public class Sum {
    public static void main(String[] args) {
        Shape shape1 = new Circle(5);
        Shape shape2 = new Square(4);
        Shape shape3 = new Rectangle(3, 6);

        System.out.println(getArea(shape1));
        System.out.println(getArea(shape2));
        System.out.println(getArea(shape3));
    }

    private static double getArea(Shape shape) {
        return switch(shape) {
            case Circle(double r) -> r * r * Math.PI;
            case Rectangle(double l, double h) -> l * h;
            case Square(double l) -> l * l;
        };
    }
}
