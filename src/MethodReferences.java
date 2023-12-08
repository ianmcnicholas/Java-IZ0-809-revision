import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferences {
    public static void main(String[] args) {
//        boundMethodReferences();
        unboundMethodReferences();
    }

    public static void boundMethodReferences() {
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

    public static void unboundMethodReferences() {
        // Function<T, R>
        //     R apply(T t);
        //         String apply(String);
        Function<String, String> upperL = s -> s.toUpperCase();
        Function<String, String> upperMR = String::toUpperCase;
        // the are unbound, so just reference String. When being used, and instance will have to be specified.

        System.out.println(upperL.apply("ian"));
        System.out.println(upperMR.apply("james"));

        // Function<T, U, R>
        //     R apply(T t, U u);
        //         String apply(String, String);
        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMR = String::concat;

        System.out.println(concatL.apply("This and ", "that."));
        System.out.println(concatMR.apply("Here and ", "there."));
    }
}
