import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

record Treatment(String name, int price) {}

abstract class Animal {
    protected String name;
    protected ArrayList<Treatment> treatmentList;
    protected Animal(String name) {
        this.name = name;
        this.treatmentList = new ArrayList<>();
    }
    public void addTreatment(Treatment t) {
        treatmentList.add(Objects.requireNonNull(t));
    }
    public abstract int getTotalPrice();
    public abstract String getSpecies();
    public String getName() {
        return name;
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public int getTotalPrice() {
        int price = 10;
        for(Treatment t : treatmentList) {
            int washExtraCost = t.name().equals("Wash") ? 2 : 1;
            price += (int) (t.price() * 1.5 * washExtraCost);
        }
        return price;
    }

    @Override
    public String getSpecies() {
        return "Cat";
    }
}
class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public int getTotalPrice() {
        int price = 0;
        for(Treatment t : treatmentList) {
            price += t.price();
        }
        return price;
    }

    @Override
    public String getSpecies() {
        return "Dog";
    }
}
class Horse extends Animal {

    public Horse(String name) {
        super(name);
    }

    @Override
    public int getTotalPrice() {
        int price = 100;
        for(int x = 0;x < treatmentList.size();x++) {
            price += treatmentList.get(x).price() + x * 10;
        }
        return price;
    }

    @Override
    public String getSpecies() {
        return "Horse";
    }
}

public class Animals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Name:");
        String name = in.nextLine().strip();
        System.out.println("Species:");
        Animal animal = switch(in.nextLine().strip()) {
            case "Cat" -> new Cat(name);
            case "Dog" -> new Dog(name);
            case "Horse" -> new Horse(name);
            default -> {
                System.err.println("Unknown species");
                System.exit(1);
                yield null;
            }
        };
        while(true) {
            System.out.println("Enter treatment name and price, separated by a space, or ENTER to stop.");
            String data = in.nextLine();
            if(data.isEmpty())  break;
            String[] members = data.split("\\s+");
            animal.addTreatment(new Treatment(members[0], Integer.parseInt(members[1])));
        }
        System.out.println("Price to treat " + animal.getName() + " the " + animal.getSpecies() + ": " + animal.getTotalPrice());
    }
}
