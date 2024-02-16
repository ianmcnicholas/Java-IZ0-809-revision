import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Streams3 {
    public static void main(String[] args) {

        System.out.println("-----------QUESTION 10------------------");

        Optional<Double> price = Optional.ofNullable(20.0);
        price.ifPresent(System.out::println);
        System.out.println(price.orElse(0.0));
        System.out.println(price.orElseGet(() -> 0.0));

        Optional<Double> price2 = Optional.ofNullable(null);
        ;
        if (price2.isEmpty()) {
            System.out.println("EMPTY");
        }
        if (price2.isPresent()) {
            System.out.println("PRESENT");
        }

        Double x = price2.orElse(44.0);
        System.out.println(x);

        Optional<Double> price3 = Optional.ofNullable(null);
//        Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));

        System.out.println("-----------QUESTION 11------------------");
        List<AnotherBook> books = Arrays.asList(
                new AnotherBook("Atlas Shrugged", "Ficton"),
                new AnotherBook("Gone With The Wind", "Thriller"),
                new AnotherBook("LOTR", "Fantasy"),
                new AnotherBook("Stormlight", "Fantasy")
        );
        System.out.println(books);
        List<String> genreList = new ArrayList<>();
        books.stream()
                .map(book -> book.getGenre())
                .forEach(a -> genreList.add(a));

        System.out.println(genreList);

        System.out.println("-----------QUESTION 12------------------");
        DoubleStream doubleStream = DoubleStream.of(0, 2, 4);
        System.out.println(doubleStream
                .filter(a -> a % 2 != 0)
                .sum());

        Stream<Double> doubles = Stream.of(1.0, 3.0);
        System.out.println(doubles.mapToDouble(a -> a)
                .filter(a -> a % 2 == 0).average().orElse(0.0));


    }
}

class AnotherBook {
    private String title;
    private String genre;

    public AnotherBook(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}
