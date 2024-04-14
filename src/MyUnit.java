public class MyUnit {

    public String concatenate(String one, String two) {
        return one + two;
    }

    public String fizzbuzz(int num) {
        if (num % 3 == 0) {
            return(num % 5 == 0 ? "Fizzbuzz" : "Fizz");
        } else if (num % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(num);
        }
    }
}
