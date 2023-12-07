import java.util.function.Predicate;

interface Evaluate<T> {
    boolean isNegative(T t); // Type T refers to "any generic"
}

public class TestPredicate {
    public static void main(String[] args) {

        Evaluate<Integer> lambda = i -> i < 0;
        Evaluate<Integer> lambda2 = i -> { return i < 0;}; // this is the same as above
        // in this case, i is in place of (), as the method isNegative takes one argument.
        // i < 0 is the implementation of the method itself.
        // Can use any generic, not just Integer.
        System.out.println("Evaluate -1: " + lambda.isNegative(-1)); // true
        System.out.println("Evaluate +1: " + lambda.isNegative(1)); // false
        System.out.println("Evaluate -1: " + lambda2.isNegative(-1)); // true
        System.out.println("Evaluate +1: " + lambda2.isNegative(1)); // false

        // Predicate has one abstract method: boolean test(T t).
        Predicate<Integer> predicate = i -> i < 0;
        System.out.println(predicate.test(2));
        System.out.println(predicate.test(-2));

        boolean result1 = check(5, predicate);
        System.out.println("Result 1 is: " + result1);

        boolean result2 = check(-5, predicate);
        System.out.println("Result 2 is: " + result2);

    }
    public static <T> boolean check(T t, Predicate<T> lambdaFunction){
        return lambdaFunction.test(t);
    }
}
