import java.util.Arrays;
import java.util.Scanner;

public class ArraysMeanAndSortedDisplay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many numbers will you enter?");
        int amount = in.nextInt();
        double[] numbers = new double[amount];
        for(int x = 0;x < amount;x++) {
            double nr = in.nextDouble();
            numbers[x] = nr;
        }
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
        double avg = Arrays.stream(numbers).sum() / amount;
        System.out.println("Arithmetic mean: " + avg);
    }
}
