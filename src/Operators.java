import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Operators {
    public static void main(String[] args) {
        // UnaryOperator - transforms input into output of same type.
        // T apply(T t);
        UnaryOperator<String> unOp = name -> "My name is: " + name;
        System.out.println(unOp.apply("Ian"));

        // BinaryOperator takes in 2 args of the same type and returns the same type.
        // T apply(T t1, T t2);
        BinaryOperator<String> biOp = (s1, s2) -> s1.concat(s2);
        System.out.println(biOp.apply("Ian ", "McNicholas"));


    }
}
