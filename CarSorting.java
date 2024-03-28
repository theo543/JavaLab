import java.util.ArrayList;

public class CarSorting {
    public static void main(String[] _args) {
        final String[] brands = {"Audi", "BMW"};
        final int[] years = {2010, 2011};
        final int[] prices = {20000, 30000};
        final int[] emissions = {100, 200};
        ArrayList<Car> cars = new ArrayList<>();
        for(String brand : brands) {
            for(int year : years) {
                for(int price : prices) {
                    for(int emission : emissions) {
                        cars.add(new Car(brand, year, price, emission));
                    }
                }
            }
        }
        Car[] sortedCars = cars.toArray(new Car[0]);
        java.util.Arrays.sort(sortedCars);
        for(Car car : sortedCars) {
            System.out.println(car);
        }
    }
}

record Car(String brand, int year, int price, int emissions) implements Comparable<Car> {
    @Override
    public int compareTo(Car other) {
        int brandCmp = brand.compareTo(other.brand);
        if(brandCmp != 0) return brandCmp;
        if(year != other.year) return other.year - year;
        if(price != other.price) return price - other.price;
        return emissions - other.emissions;
    }
}
