import java.util.function.BiFunction;
import java.util.function.Function;

public class Functions { // the final Type is the output type.
    public static void main(String[] args) {
        // A Function can take an input and output the same or a different type
        // Function<T, R>; R apply(T t)

        Function<String, Integer> fn1 = s -> s.length();
        System.out.println("Checking string length: " + fn1.apply("String to check"));

        // Bi Function: R apply(T t, U, u);
        BiFunction<String, String, Integer> biFn1 = (s1, s2) -> (s1.concat(s2)).length();
        System.out.println(biFn1.apply("This", "That")); // 8
    }
}
