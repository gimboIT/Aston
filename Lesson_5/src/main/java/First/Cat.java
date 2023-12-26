package First;

public class Cat extends Animal {
    private static int counter;
    public Cat(String name, int staminaLand, int staminaWater) {
        super(name, staminaLand, staminaWater);
    }

    public Cat(String name) {
        super(name,200,0);
        counter++;
    }

    public Cat() {
    }

    public static int getCounter() {
        return counter;
    }

}
