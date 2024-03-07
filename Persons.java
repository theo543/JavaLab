import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

// Read persons, read a name to replace, print in tabular form, print average salary.

public class Persons {
    record Person(String name, int birthYear, int salary) {
        final static int currentYear = Year.now().getValue();
        public int age() {
            return currentYear - birthYear;
        }
        @Override
        public String toString() {
            return name + " | " + age() + " | " + salary;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var persons = new ArrayList<Person>();
        while(true) {
            System.out.println("Enter person's name, birth year and salary, separated by commas, or ENTER to stop.");
            String data = in.nextLine();
            if(data.isEmpty()) {
                break;
            }
            String[] members = data.split(" *, *");
            persons.add(new Person(members[0], Integer.parseInt(members[1]), Integer.parseInt(members[2])));
        }
        System.out.println("Enter a name to replace, and the replacement, separated by commas.");
        String[] data = in.nextLine().split(" *, *");
        for(int x = 0;x < persons.size();x++) {
            Person p = persons.get(x);
            if(p.name.equals(data[0])) {
                persons.set(x, new Person(data[1], p.birthYear, p.salary));
            }
        }
        double avgSalary = 0;
        System.out.println("NAME | AGE | SALARY");
        for(Person p : persons) {
            System.out.println(p);
            avgSalary += p.salary;
        }
        avgSalary /= persons.size();
        System.out.println("Average salary: " + avgSalary);
    }
}
