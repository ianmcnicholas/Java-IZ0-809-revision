import java.util.Arrays;
import java.util.List;

public class Streams4 {
    public static void main(String[] args) {

        System.out.println("-----------QUESTION 13------------------");
        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        System.out.println(ls.stream()
                .distinct()
                .anyMatch(a -> a == 11));
        System.out.println(ls.stream()
                .noneMatch(a -> a % 11 > 0));

        ls.add(5);


    }
}
