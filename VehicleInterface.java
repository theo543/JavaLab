public class VehicleInterface {
    public static void main(String[] args) {
        Vehicle v = new CarVehicle(12);
        v.accelerate();
        v.activateAlarm();
        v.deactivateAlarm();
        System.out.println(Vehicle.getPosition(v));
    }
}

interface Vehicle {
    void accelerate();
    default void activateAlarm() {
        System.out.println("Alarm activated");
    }
    default void deactivateAlarm() {
        System.out.println("Alarm deactivated");
    }
    static int getPosition(@SuppressWarnings("unused")  Vehicle v) {
        System.out.println("Placeholder: returning 0");
        return 0;
    }
}

class CarVehicle implements Vehicle {
    final private int position;
    public CarVehicle(int position) {
        this.position = position;
    }
    @Override
    public void accelerate() {
        System.out.println("Car is accelerating");
    }
    @Override
    public void activateAlarm() {
        System.out.println("Car alarm activated");
    }
    @Override
    public void deactivateAlarm() {
        System.out.println("Car alarm deactivated");
    }

    // Doesn't work, can't override static method
    // @Override
    @SuppressWarnings("unused")
    public static int getPosition(Vehicle v) {
        if(v instanceof CarVehicle) {
            System.out.println("Car getPosition overridden");
            return ((CarVehicle) v).position;
        }
        return Vehicle.getPosition(v);
    }
}
