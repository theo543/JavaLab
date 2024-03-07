import java.util.*;

public class StringSorter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var strings = new ArrayList<String>();
        while(true) {
            try {
                String input = in.nextLine();
                if(input.isEmpty()) {
                    break;
                }
                strings.add(input);
            } catch (NoSuchElementException e) {
                // no more input
                break;
            }
        }
        strings.sort(null);
        System.out.println(strings);
    }
}
