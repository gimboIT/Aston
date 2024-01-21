import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> box;

    public Box(List<T> box) {
        this.box = box;
    }

    public Box() {
        box = new ArrayList<>();
    }

    public List<T> getBox() {
        return box;
    }

    public void setBox(List<T> box) {
        this.box = box;
    }

    public void add(T fruit) {
        box.add(fruit);
    }

    public double getWeight() {
        if (box.isEmpty()) return 0;
        return box.size() * box.get(0).weight;
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    public void moveToAnotherBox(Box<? super T> box) {
        if (this == box)
            return;

        for (int i = 0; i < this.getBox().size(); i++) {
            box.add(this.getBox().get(i));
        }
        this.getBox().clear();
    }
}
