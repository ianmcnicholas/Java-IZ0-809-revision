public class FizzBuzz {
    public static void main(String[] args) {
        fizzbuzz(1);
        fizzbuzz(3);
        fizzbuzz(10);
        fizzbuzz(15);
    }

    public static String fizzbuzz(int num) {
        if (num % 3 == 0) {
            return (num % 5 == 0 ? "Fizzbuzz" : "Fizz");
        } else if (num % 5 == 0) {
             return ("Buzz");
        } else {
            return String.valueOf(num);
        }
    }
}
