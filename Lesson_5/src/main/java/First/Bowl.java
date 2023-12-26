package First;

public class Bowl {

    private int amountFood;

    public int getAmountFood() {
        return amountFood;
    }

    public void addFood(int food) {
        amountFood += food;
    }

    public void setAmountFood(int amountFood) {
        this.amountFood = amountFood;
    }

    public boolean minusFood() {
        if (amountFood <= 0) {
            return false;
        } else {
            amountFood--;
            return true;
        }
    }
}
