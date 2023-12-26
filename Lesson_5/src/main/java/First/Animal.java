package First;

public abstract class Animal {
    protected String name;
    protected int staminaLand;
    protected int staminaWater;
    private static int singleThreadCounter;
    protected boolean satiety;

    public Animal(String name, int staminaLand, int staminaWater) {
        singleThreadCounter++;
        this.name = name;
        this.staminaLand = staminaLand;
        this.staminaWater = staminaWater;
    }

    public Animal() {
    }

    public void run(int length) {
        if (length <= staminaLand)
            System.out.println(name + " run: " + length);
        else
            System.out.println(name + " dont have stamina for this move");
    }

    public void swim(int length) {
        if (length <= staminaWater)
            System.out.println(name + " run: " + length);
        else
            System.out.println(name + " dont have stamina for this move");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void counterInfo() {
        System.out.println(singleThreadCounter);
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }
    public void eat(Bowl bowl) {
        satiety = bowl.minusFood();
    }
}
