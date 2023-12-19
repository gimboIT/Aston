public class Math {

    public static boolean amountRangingFrom10To20(int firstNumber, int secondNumber) {
        int sum = firstNumber + secondNumber;
        if (sum >= 10 && sum <= 20) {
            return true;
        }
        return false;
    }

    public static void printNumberSign(int number) {
        if (number >= 0) System.out.println("Positive +");
        else System.out.println("Negative -");
    }

    public static boolean numberSign(int number) {
        if (number >= 0) return false;
        else return true;
    }
}
