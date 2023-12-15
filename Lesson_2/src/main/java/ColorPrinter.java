public class ColorPrinter {
    public static void printColor(int value) {
        if (value <= 0) System.out.println("Red");
        else if (value <= 100) System.out.println("Yellow");
        else System.out.println("Green");
    }
}
