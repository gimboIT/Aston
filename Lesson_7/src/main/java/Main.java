public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "1", "2", "1"},
                {"1", "0", "0", "0"},
                {"0", "0", "0", "0"},
                {"0", "0", "0", "0"}
        };
        int sum = 0;
        try {
            sum = Arrays.sumTwoDimensionalArray(array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}
