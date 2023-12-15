public class Math {

    /**
     * Первые две проверки если int c будет переполнена
     */
    public static void checkSumSign(int a, int b) {
        if (a > 0 && b > 0) {
            System.out.println("Sum is positive");
            return;
        }
        if (a < 0 && b < 0) {
            System.out.println("Sum is negative");
            return;
        }

        int c = a + b;
        if (c >= 0)
            System.out.println("Sum is positive");
        else
            System.out.println("Sum is negative");
    }

    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
            return;
        }
        System.out.println("a < b");
    }

}
