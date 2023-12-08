import java.util.function.Supplier;

public class Suppliers {

//    Supplier<T> is a functional interface.  It takes () and returns T with a method get()

    public static void main(String[] args) {
        Supplier<StringBuilder> supStringBuildier = () -> new StringBuilder();
        System.out.println("This is my string builder: " + supStringBuildier.get().append("appendingThis"));

        Supplier<Double> supDouble = () -> Math.random();
        System.out.println("This is my random number: " + supDouble.get());

    }



}
