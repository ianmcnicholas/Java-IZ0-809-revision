import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.*;

public class MethodReferences {
    public static void main(String[] args) {
//        boundMethodReferences();
//        unboundMethodReferences();
        staticdMethodReferences();
    }

    public static void boundMethodReferences() { // for compile time arguments
        String name = "Mr Ian McNicholas";
        // Supplier<T>
        // T get();
        Supplier<String> lowerL = () -> name.toLowerCase();
        Supplier<String> lowerMR = name::toLowerCase;
        // these are bound to "name", as that is used in the definition.

        System.out.println(lowerL.get());
        System.out.println(lowerMR.get());

        // Predicate<T>
        // boolean test(T t);
        Predicate<String> titleL = title -> name.startsWith(title);
        Predicate<String> titleMR = name::startsWith;

        System.out.println(titleL.test("Mr Ian"));
        System.out.println(titleMR.test("Mr Ian"));
    }

    public static void unboundMethodReferences() { // for run time arguments
        // Function<T, R>
        //     R apply(T t);
        //         String apply(String);
        Function<String, String> upperL = s -> s.toUpperCase();
        Function<String, String> upperMR = String::toUpperCase;
        // these are unbound, so just reference String. When being used, and instance will have to be specified.

        System.out.println(upperL.apply("ian"));
        System.out.println(upperMR.apply("james"));

        // Function<T, U, R>
        //     R apply(T t, U u);
        //         String apply(String, String);
        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMR = String::concat;

        // the 1st parameter is used for executing the instance method.

        System.out.println(concatL.apply("This and ", "that."));
        System.out.println(concatMR.apply("Here and ", "there."));
    }

    public static void staticdMethodReferences() {
        // also considered to be UN-BOUND
        Consumer<List<Integer>> sortL = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR = Collections::sort;

        List<Integer> listOfNumbers = Arrays.asList(2, 1, 7, 4, 8);
        sortL.accept(listOfNumbers);
        System.out.println(listOfNumbers);

        listOfNumbers = Arrays.asList(3, 1, 7, 4, 8);
        sortMR.accept(listOfNumbers);
        System.out.println(listOfNumbers);

    }
}
