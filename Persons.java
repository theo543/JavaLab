import java.time.Year;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// Read persons, read a name to replace, print in tabular form, print average salary.

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
final class PersonBuilder {
    private String name;
    private Integer birthYear;
    private Integer salary;
    PersonBuilder name(String name_) {
        name = name_;
        return this;
    }
    PersonBuilder birthYear(int birthYear_) {
        birthYear = birthYear_;
        return this;
    }
    PersonBuilder salary(int salary_) {
        salary = salary_;
        return this;
    }
    Person build() {
        return new Person(Objects.requireNonNull(name), Objects.requireNonNull(birthYear), Objects.requireNonNull(salary));
    }
}
public class Persons {
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
            Person p = new PersonBuilder().name(members[0]).birthYear(Integer.parseInt(members[1])).salary(Integer.parseInt(members[2])).build();
            persons.add(p);
        }
        System.out.println("Enter a name to replace, and the replacement, separated by commas.");
        String[] data = in.nextLine().split(" *, *");
        for(int x = 0;x < persons.size();x++) {
            Person p = persons.get(x);
            if(p.name().equals(data[0])) {
                persons.set(x, new PersonBuilder().name(data[1]).birthYear(p.birthYear()).salary(p.salary()).build());
            }
        }
        double avgSalary = 0;
        System.out.println("NAME | AGE | SALARY");
        for(Person p : persons) {
            System.out.println(p);
            avgSalary += p.salary();
        }
        avgSalary /= persons.size();
        System.out.println("Average salary: " + avgSalary);
    }
}
