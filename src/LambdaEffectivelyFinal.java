import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEffectivelyFinal {
    String name = "";

    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>();
        al.add("John");

        int x = 12; // final or effectively final

        // Lambdas take a snapshot/picture of local variables
        // these MUST NOT change. Only setting up lambda here.
        Predicate<String> lambda = s -> {
//            x++;  cannot do this as x must be final or effectively final
            new LambdaEffectivelyFinal().name = "Davenport";
            System.out.println("x == " + x);
            return s.isEmpty() && x % 2 == 0;
        };
        filterData(al, lambda);
        System.out.println(al);

        new LambdaEffectivelyFinal().name = "Ian";
//        x++; cannot do this as x has already been used in the lambda function so is considered FINAL.
//        if the lambda WASN'T using x, then it could be changed here.
        filterData(al, lambda);

    }
    public static void filterData(List<String> list, Predicate<String> lambda){
        Iterator<String> i = list.iterator();
        while (i.hasNext()){
            if (lambda.test(i.next())){
                i.remove();
            }
        }
    }
}
