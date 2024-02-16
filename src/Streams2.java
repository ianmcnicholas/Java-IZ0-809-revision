import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams2 {
    public static void main(String[] args) {

        Stream<List<String>> listStream = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"), Arrays.asList("b", "c"));
        System.out.println(listStream);
        listStream
                .filter((list) -> list.contains("c"))
                .flatMap(list -> list.stream())
                .forEach(o -> System.out.print(o + " "));

        System.out.println("-----------QUESTION 5------------------");
        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(55);
        System.out.println(grade1.orElse("UNKNOWN")); // grade1 is a EMPTY OPTIONAL, due to the method code below.
        if (grade2.isPresent()) {
            grade2.ifPresent(x -> System.out.println(x));
        } else {
            System.out.println(grade2.orElse("Empty"));
        }

        System.out.println("-----------QUESTION 6------------------");

        List<Book> bookList = Arrays.asList(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24hrs", 20.0),
                new Book("Java Recipes", 10.0)
        );
        System.out.println(bookList);

        double averagePrice = bookList.stream()
                .filter(i -> i.getPrice() > 10)
                .mapToDouble(i -> i.getPrice())
                .average()
                .getAsDouble();

        System.out.println(averagePrice + " is the average price when over 10.0");

        double averagePrice2 = bookList.stream()
                .filter(i -> i.getPrice() > 90)
                .mapToDouble(i -> i.getPrice())
                .average()
                .orElse(0.0);

        System.out.println(averagePrice2 + " is the average price when over 90.0");

        System.out.println("-----------QUESTION 7------------------");

        List<Book> books = Arrays.asList(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone With The Wind", 5.0)
        );
        System.out.println(books);

        Map<String, Double> bookMap = books.stream()
                .collect(Collectors.toMap(a -> a.getTitle(), a -> a.getPrice()));
        System.out.println(bookMap);

        bookMap.forEach(
                (a, b) -> {
                    if (a.startsWith("A")) {
                        System.out.println(b);
                    }
                }
        );

        System.out.println("-----------QUESTION 8------------------");
        List<Book> books2 = Arrays.asList(
                new Book("Atlas Shrugged", 15.0),
                new Book("Gone With The Wind", 10.0),
                new Book("Gone With The Wind", 5.0)
        );
        System.out.println(books2);

        books2.stream()
//                .collect(Collectors.toMap(a->a.getTitle(), a->a.getPrice()))
                // the above line will result in an IllegalStateException as the List has duplicate keys in it.
                .collect(Collectors.toMap(a -> a.getTitle(), a -> a.getPrice(), (v1, v2) -> v1 * v2))
                // the above method will collect the values of the duplicate keys with the operation stated, here *
                .forEach((a, b) -> System.out.println(a + " " + b));


    }

    public static Optional<String> getGrade(int marks) {
        Optional<String> grade = Optional.empty();
        if (marks > 50) {
            grade = Optional.of("PASS"); // we are RE-INITIALISING / RE-ASSIGNING grade here.
        } else {
            grade.of("FAIL"); // Optionals are IMMUTABLE, therefore this line has no effect.
        }
        return grade;
    }
}

class Book {
    private String title;
    private double price;

    Book(String title, double price) {
        this.price = price;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return title + " " + price;
    }
}
