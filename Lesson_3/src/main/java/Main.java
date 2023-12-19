import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("1");
        System.out.println(Math.amountRangingFrom10To20(10, 3));
        System.out.println("2");
        Math.printNumberSign(-3);
        System.out.println("3");
        System.out.println(Math.numberSign(5));
        System.out.println("4");
        Printer.printSomeText("hi hi ", 2);
        System.out.println("\n5");
        System.out.println(Date.leapYear(800));
        System.out.println("6");
        int[] array1 = new int[10];
        ArraysHelper.fillAndReverb01(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println("7");
        int[] array2 = new int[100];
        ArraysHelper.fillArray1to100(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println("8");
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        ArraysHelper.multiplyX2NumberLower6(array3);
        System.out.println(Arrays.toString(array3));
        System.out.println("9");
        int[][] array4 = new int[5][5];
        ArraysHelper.fillDiagonal2DArray(array4);
        ArraysHelper.print2DArray(array4);
        System.out.println("10");
        System.out.println(Arrays.toString(ArraysHelper.createAndFillArrayWithNumber(10,10)));
    }
}
