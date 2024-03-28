public class Conflict {
    public static void main(String[] args) {
        C c = new C();
        c.write();
    }
}

interface A {
    @SuppressWarnings("unused")
    default void write() {
        System.out.println("A");
    }
}

interface B {
    @SuppressWarnings("unused")
    default void write() {
        System.out.println("B");
    }
}

class C implements A, B {
    // Must define method to fix default method conflict
    @Override
    public void write() {
        System.out.println("C");
    }
}
