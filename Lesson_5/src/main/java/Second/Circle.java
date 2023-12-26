package Second;

public class Circle implements Figure {

    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * radius * radius;
    }

    @Override
    public void setFillColor(String color) {
        fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        borderColor = color;
    }

    @Override
    public void showCharacteristics() {
        System.out.println(getPerimeter());
        System.out.println(getArea());
        System.out.println(fillColor);
        System.out.println(borderColor);
    }
}
