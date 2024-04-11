public class QuestionTwo {

    public static void main(String[] args) {
        Dog barny = new Dog("Barny", 4, 5);
        GoldenRetriever bella = new GoldenRetriever("Bella", 7, 10);
        System.out.println(oldest_dog(barny, bella));
    }

    private static String oldest_dog(Dog dog1, Dog dog2) {
        if (dog1.getAge() == dog2.getAge()) {
            return "The dogs are the same age";
        }
        Dog eldestDog = dog1.getAge() > dog2.getAge() ? dog1 : dog2;
        return eldestDog.getName() + " is the oldest dog";
    }

    static class Dog {
        private String name;
        private int age;
        private int weight;

        public Dog(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        void move() {
        }

        void bark() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    static class GoldenRetriever extends Dog {
        public GoldenRetriever(String name, int age, int weight) {
            super(name, age, weight);
        }

        @Override
        void move() {
            System.out.println("Running Fast");
        }

        @Override
        void bark() {
            System.out.println("WOOF WOOF!");
        }
    }

}
