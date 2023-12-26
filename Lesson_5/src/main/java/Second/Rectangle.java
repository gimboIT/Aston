package Second;

public class Rectangle implements Figure {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
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
