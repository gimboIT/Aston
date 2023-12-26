package Second;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2, "Green", "Red");
        circle.showCharacteristics();
        System.out.println("---");
        Rectangle rectangle = new Rectangle(3, 3, "Blue", "Grey");
        rectangle.showCharacteristics();
        System.out.println("---");
        Triangle triangle = new Triangle(3, 3, 3, "White", "Black");
        triangle.showCharacteristics();
        System.out.println("---");
    }
}
