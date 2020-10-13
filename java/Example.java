import java.util.*;

interface Animal {
    default public String identifyMyself() {
        return "I am an animal.";
    }
}
interface EggLayer extends Animal {
    default public String identifyMyself() {
        return "I am able to lay eggs.";
    }
}
interface FireBreather extends Animal {
    // Compile time error to solve you must explicitly override this method
//    default public String identifyMyself() {
//        return "I am not able to lay eggs.";
//    }
}


class Dragon implements EggLayer, FireBreather {
    public static void main (String... args) {
        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
        System.out.println(myApp.getClass());
    }
}

/////// Equals and hash code ***********************************

class A{
    int a;
    int b;

    private static int a(A o1, A o2) {
        return o2.a() - o1.a();
    }

    public  int a() {
        return 1;
    }; public  int b() {
        return 1;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a1 = (A) o;
        return a == a1.a &&
                b == a1.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public void sort() {
        List<A> l = new ArrayList<>();
        Collections.sort(l, A::a);
    }
}

///


