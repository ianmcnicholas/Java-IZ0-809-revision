import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasAssignment {
    public static void main(String[] args) {
//        consumer("This is the String");
//        supplier();
//        predicate();
//        function();
        List<Person> listPeople = getPeople();
        System.out.println(listPeople);
        listPeople.forEach(p -> System.out.println(p.age));
        sortAge(listPeople);
        System.out.println(listPeople);
        listPeople.forEach(p -> System.out.println(p.age));
        listPeople.forEach(p -> System.out.println(p.name));
        sortName(listPeople);
        System.out.println(listPeople);
        listPeople.forEach(p -> System.out.println(p.name));
    }


    public static void consumer(String string) {
//        Cannot find correct Printable interface so have made my own
        Printable<String> printing = s -> System.out.println(s);
        printing.print(string);
        Consumer<String> consLb = s -> System.out.println(s);
        Consumer<String> consMR = System.out::println;
        consLb.accept("lambda String");
        consMR.accept("MR String");
    }

    private static void supplier() {
        Retrievable<Integer> retriever = () -> {
            return 77;
        };
        retriever.get();
        System.out.println(retriever.get());

        Supplier<Integer> supLb = () -> {
            return 77;
        };
        System.out.println(supLb.get() + " is the lambda");
    }

    private static void predicate() {
        Evaluate<Integer> eval = i -> i < 0;
        System.out.println(eval.test(-1));
        System.out.println(eval.test(1));

        Predicate<Integer> pred = i -> i < 0;
        System.out.println(pred.test(-1));
        System.out.println(pred.test(1));

        System.out.println(check(4, i -> i % 2 == 0));
        System.out.println(check(7, i -> i % 2 == 0));
        System.out.println(check("Mr. Joe Bloggs", s -> s.startsWith("Mr.")));
        System.out.println(check("Mrs. Joanna Bloggs", s -> s.startsWith("Mr.")));

        System.out.println(check(new Person("Ian", 34, 1.77), p -> p.age >= 18));
        System.out.println(check(new Person("Rosa", 7, 0.95), p -> p.age >= 18));
    }

    private static <T> boolean check(T t, Predicate<T> function) {
        return function.test(t);
    }

    private static void function() {
        Functionable<Integer, String> func = i -> "Number is ".concat(i.toString());
        System.out.println(func.apply(25));

        Function<Integer, String> func2 = i -> "Number is ".concat(i.toString());
        System.out.println(func.apply(33));
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.85));
        return result;
    }

    private static void sortAge(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(p -> p.age));
        System.out.println("After sort by age");
    }

    private static void sortName(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(p -> p.name));
        System.out.println("After sort by name");
    }
}

interface Printable<T> {
    void print(T t);
}

interface Retrievable<T> {
    T get();
}

interface Evaluate<T> {
    boolean test(T t);
}

interface Functionable<T, R> {
    R apply(T t);
}

class Person {
    String name;
    int age;
    double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
