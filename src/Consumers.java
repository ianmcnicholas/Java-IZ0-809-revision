import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Consumers {
    public static void main(String[] args) {
        // Consumer is a functional interface with void accept(T t), and return nothing.

        Consumer<String> conString = i -> System.out.println(i);
        conString.accept("This is my consumer string I want printed.");

        // BiConsumer takes two args, and returns nothing
        // void accept(T t, U u);

        var mapCapitalCities = new HashMap<String, String>();

        BiConsumer<String, String> biString = (key, value) -> mapCapitalCities.put(key, value);
        biString.accept("England", "London");
        biString.accept("France", "Paris");
        biString.accept("Japan", "Tokyo");

        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint = (key, value) -> System.out.println(value + " is the capital city of " + key);

        mapCapitalCities.forEach(mapPrint);

    }
}
