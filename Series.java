public class Series {
    @FunctionalInterface
    public interface SeriesFunction {
        int calculate(int n);
    }
    public static int calculateSeries(int from, int to, SeriesFunction callback) {
        if (from > to) {
            throw new IllegalArgumentException("from must be less than or equal to to");
        }
        int result = 0;
        for(int x = from; x <= to; x++) {
            result += callback.calculate(x);
        }
        return result;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("Sum from 1 to " + n + ": " + calculateSeries(1, n, x -> x));
        System.out.println("Sum of squares from 1 to " + n + ": " + calculateSeries(1, n, x -> x * x));
    }
}
