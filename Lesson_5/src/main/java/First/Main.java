package First;

public class Main {

    public static void main(String[] args) {
        Animal cat1 = new Cat("Boris");
        Animal cat2 = new Cat("Tom");
        Animal dog1 = new Dog("Bob");
        Animal dog2 = new Dog("Sam");

        cat1.run(305);
        cat2.run(200);
        dog1.run(700);
        dog2.run(30);
        cat1.swim(40);
        dog1.swim(10);
        Animal.counterInfo();
        System.out.println(Cat.getCounter());

        Cat[] cats = {new Cat(), new Cat(), new Cat(), new Cat(), new Cat()};
        Bowl bowl = new Bowl();
        bowl.setAmountFood(3);

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (Cat cat : cats) {
            System.out.println(cat.isSatiety());
        }
    }
}
