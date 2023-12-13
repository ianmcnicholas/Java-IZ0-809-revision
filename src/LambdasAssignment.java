
public class LambdasAssignment {
    public static void main(String[] args) {
        consumer("This is the string");
    }

    public static void consumer(String string) {
//        Cannot find correct Printable interface so have made my own
        Printable<String> printing = s -> System.out.println(s);
        printing.print(string);

    }
}

interface Printable<String> {
    void print(String string);
}
