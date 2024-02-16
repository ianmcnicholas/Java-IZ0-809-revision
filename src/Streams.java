import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {

    public static void main(String[] args) {

        IntStream is1 = IntStream.range(0, 5); // 0...4
        System.out.println(is1.average().orElse(0.0)); // 10/5 = 2.0
        IntStream is2 = IntStream.rangeClosed(0, 5); // 0...5
        System.out.println(is2.average().orElse(0.0)); // 15/6 = 2.5


        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item(1, "Screw"));
        itemList.add(new Item(2, "Nail"));
        itemList.add(new Item(3, "Bolt"));
        System.out.println(itemList);
        itemList.stream()
                .sorted(Comparator.comparing(Item::getName))
                .forEach(System.out::println);
        System.out.println(itemList);
        itemList.stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(System.out::println);

        //This method returns the Item, toString(), which returns the name.
        itemList.stream()
                .sorted(Comparator.comparing(a -> a.getName()))
                .forEach(System.out::println);

        //Similar to above, but it's mapped to return a String, instead of an Item.
        itemList.stream()
                .sorted(Comparator.comparing(a -> a.getName()))
                .map((item) -> item.getName())
                .forEach(System.out::println);
// Generally in the above examples, sorted() or map() can be in either order.  One sorts, and one get the names.


        System.out.println("-----------QUESTION 4a------------------");
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int sumOfList = integerList.stream()
                .mapToInt(i->i)
                .sum();

        System.out.println(integerList);
        System.out.println(sumOfList + " is the sum of the list.");

        OptionalInt maxInList = integerList.stream()
                .mapToInt(i->i)
                .max();
        System.out.println(maxInList.getAsInt() + " is the max value in the list.");

        System.out.println("-----------QUESTION 4b------------------");
        List<Human> humanList = Arrays.asList(
                new Human("Alan", "Burke", 22),
                new Human("Zoe", "Peters", 20),
                new Human("Peter", "Castle", 29)
        );
        System.out.println(humanList);
        Human oldestHuman = humanList.stream()
                .max(Comparator.comparing(Human::getAge))
                .get();
        System.out.println(oldestHuman + " is the older person in the list.");
        System.out.println("-----------QUESTION 4c------------------");
        List<Integer> integerList1 = Arrays.asList(10, 47, 33, 23);
        Integer max1 = integerList1.stream()
                .reduce((a, b) -> Integer.max(a, b)).get();
        System.out.println(max1 + " is the first max method in the list.");

        Integer max2 = integerList1.stream()
                .reduce(Integer.MIN_VALUE, (a, b)->Integer.max(a, b));
        System.out.println(max2 + " is the second method of getting the maximum value from the list.");


        System.out.println("-----------QUESTION 9------------------");

        List<Human> humans9 = Arrays.asList(
                new Human("Bob", "Burke", 31),
                new Human("Paul", "Peters", 32),
                new Human("John", "Castle", 33)
        );
        System.out.println(humans9);

        double averageAge = humans9.stream()
                .filter(h->h.getAge()<30)
                .mapToInt(Human::getAge)
                .average()
                .orElse(0.0);
        System.out.println(averageAge);




    }

    private static void sortAlphabetically(List<Item> itemList) {
//        itemList.stream().forEach(System.out::println);
        System.out.println(itemList.stream().sorted().collect(Collectors.toList()));


    }


}

class Item {
    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Human {
    private String firstName, lastName;
    private Integer age;

    Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
