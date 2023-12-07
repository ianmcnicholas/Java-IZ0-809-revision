import java.util.function.BiPredicate;

public class BiPredicates {

    public static void main(String[] args) {
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;

        System.out.println("False test: " + checkLength.test("This is my falsey string", 8));
        System.out.println("True test: " + checkLength.test("This is my true string", 22));

    }


}
