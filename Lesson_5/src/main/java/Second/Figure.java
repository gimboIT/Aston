package Second;

public interface Figure {
    default double getPerimeter() {
        throw new UnsupportedOperationException("Method not create");
    }

    double getArea();

    void setFillColor(String color);

    void setBorderColor(String color);

    void showCharacteristics();
}
