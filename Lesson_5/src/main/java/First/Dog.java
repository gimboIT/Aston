package First;

public class Dog extends Animal {
    private static int counter;
    public Dog(String name, int staminaLand, int staminaWater) {
        super(name, staminaLand, staminaWater);
    }

    public Dog(String name) {
        super(name,500,10);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
