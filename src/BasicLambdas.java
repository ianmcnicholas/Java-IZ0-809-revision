interface I {
    void m(); // a functional interface i.e. it only has one abstract method
}

/**
 * Whilst before Java 8, you would have to explicitly name the interface method you were calling,
 * now, if it's a functional interface, you can simply use a lambda to assert the function.
 */
public class BasicLambdas {

    public static void main(String[] args) {
        //pre Java 8
        I i = new I() {
            @Override
            public void m() {
                System.out.println("I::m");
            }
        };
        i.m();

        // Java 8 - Lambda expression
        I lambdaI1 = () -> { // the () can be thought of as pointing at public void m();
            System.out.println("LambdaI1 version");
        };
        I lambdaI2 = () -> System.out.println("LambdaI2 version");
        lambdaI1.m();
        lambdaI2.m();
    }

}
