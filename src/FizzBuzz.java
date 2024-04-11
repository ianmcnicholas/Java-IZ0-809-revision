public class FizzBuzz {
    public static void main(String[] args) {
        fizzbuzz(1);
        fizzbuzz(3);
        fizzbuzz(10);
        fizzbuzz(15);
    }

    private static void fizzbuzz(int num) {

        if (num % 3 == 0) {
            System.out.println((num % 5 == 0 ? "Fizzbuzz" : "Fizz"));
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }


    }
}
