public class Fibonnaci {

    public static void main(String[] args) {
        System.out.println(fibonnaci(5)); // 11th number in sequence
        System.out.println(fibonnaci(8));
    }

    private static Integer fibonnaci(int num) {
        // adding two numbers before
        // 0,1

//        numbers = [0,1]
//        result = numbers[-1] + numbers[-2]
//        numbers.add(result)
//0, 1, 1, 2, 3, 5, 8, 13...
//1, 2, 3, 4, 5, 6, 7, 8...

        int a = 0;
        int b = 1;
        int fibo = 1;

        for (int i = 2; i < num; i++) {
            fibo = a + b;
            a = b;
            b = fibo;
        }
        return fibo;
    }

}
