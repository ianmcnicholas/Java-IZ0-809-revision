import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {

    public static void main(String[] args) {

        IntStream is1 = IntStream.range(0,5); // 0...4
        System.out.println(is1.average().orElse(0.0)); // 10/5 = 2.0
        IntStream is2 = IntStream.rangeClosed(0,5); // 0...5
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
                .sorted(Comparator.comparing(a->a.getName()))
                .forEach(System.out::println);

        //Similar to above, but it's mapped to return a String, instead of an Item.
        itemList.stream()
                .sorted(Comparator.comparing(a->a.getName()))
                .map((item)->item.getName())
                .forEach(System.out::println);
// Generally in the above examples, sorted() or map() can be in either order.  One sorts, and one get the names.

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
