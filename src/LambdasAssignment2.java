import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class LambdasAssignment2 {
    public static void main(String[] args) {
        staticMR();
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
        // Therefore here, Java knows that as there is only one argument allowed, only sort(List) can be used.
    }
}
