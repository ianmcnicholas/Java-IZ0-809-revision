import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class LambdasAssignment2 {
    public static void main(String[] args) {
//        staticMR();
//        boundMR();
//        unboundMR();
        constructorMR();
    }

    private static void constructorMR() {
        Supplier<List<String>> stringSupplier = () -> new ArrayList<>();
        List<String> list = stringSupplier.get();
        list.add("Lambda");
        System.out.println(list);
        System.out.println("--------------");
        Supplier<List<String>> supplierMR = ArrayList::new;
        list = supplierMR.get();
        list.add("Method Reference");
        System.out.println(list);
        System.out.println("--------------");
        Function<Integer, List<String>> consFunc = i -> new ArrayList<>(i);
        list = consFunc.apply(10);
        list.add("test1");
        System.out.println(list);
        System.out.println("--------------");
        Function<Integer, List<String>> consFunc2 = ArrayList::new;
        // the above function knows to take Integer as the arg for ArrayList() - context!
        list = consFunc2.apply(10);
        list.add("MR VERSION");
        System.out.println(list);



    }

    private static void unboundMR() {
        Predicate<String> checkIfEmpty = s -> s.isEmpty();
        System.out.println(checkIfEmpty.test(""));
        System.out.println(checkIfEmpty.test("xyz"));
        Predicate<String> checkMR = String::isEmpty;
        System.out.println(checkMR.test(""));
        System.out.println(checkMR.test("abc"));
        System.out.println("-------");
        BiPredicate<String, String> biPredCheck = (s, x) -> s.startsWith(x);
        System.out.println(biPredCheck.test("Hello", "H"));
        System.out.println(biPredCheck.test("Hello", "h"));
        System.out.println(biPredCheck.test("Hello", "t"));
        System.out.println("-------");
        BiPredicate<String, String> biPredMR = String::startsWith;
        System.out.println(biPredMR.test("Hello", "H"));
        System.out.println(biPredMR.test("Hello", "h"));
        System.out.println(biPredMR.test("Hello", "t"));

    }

    private static void boundMR() {
        String name = "Mr. Joe Bloggs";
        Predicate<String> predString = s -> s.startsWith("Mr.");
        System.out.println(predString.test(name));
        System.out.println(predString.test("Mrs. Joe Bloggs"));

        Predicate<String> predMR = name::startsWith;
        System.out.println(predMR.test("Mr."));
        System.out.println(predMR.test("Mrs."));
    }

    private static void staticMR() {
        List<Integer> integerList = Arrays.asList(1, 2, 7, 4, 5);
        System.out.println(integerList + " - original list");
        Consumer<List<Integer>> consList = list -> Collections.sort(list);
        consList.accept(integerList);
        System.out.println(integerList + " - sorted list");

        integerList = Arrays.asList(1, 2, 7, 4, 5);
        System.out.println(integerList + " - reinitialised list");

        Consumer<List<Integer>> consList2 = Collections::sort;
        consList2.accept(integerList);
        System.out.println(integerList + " - sorted list");

        // Note - sort() is overloaded - sort(List) and sort(List, Comparator).
        // How does Java know which one to use?
        // Context is key - A Consumer instance can only receive one argument...
        // Therefore, Java knows that as there is only one argument allowed here; only sort(List) can be used.
    }
}
