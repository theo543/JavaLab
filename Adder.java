public class Adder {
    public static void main(String[] args) {
        int sum = 0;
        for(String arg : args) {
            try {
                sum += Integer.parseInt(arg);
            } catch (NumberFormatException ex) {
                System.err.println("Not a valid int: \"" + arg + "\"");
                System.exit(1);
            }
        }
        System.out.println(sum);
    }
}
