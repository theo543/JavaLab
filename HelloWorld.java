public class HelloWorld {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Usage: <prog> <your name>");
            System.exit(1);
        }
        System.out.println("Hello, " + args[0] + "!");
    }
}
