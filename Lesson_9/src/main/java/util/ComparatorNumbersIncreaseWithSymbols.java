package util;

import java.util.Comparator;

public class ComparatorNumbersIncreaseWithSymbols<T extends String> implements Comparator<T> {
    @Override
    public int compare(String s1, String s2) {
        int n1 = extractNumber(s1);
        int n2 = extractNumber(s2);
        return Integer.compare(n1, n2);
    }

    private int extractNumber(String s) {
        String number = s.replaceAll("\\D", "");
        return Integer.parseInt(number);
    }
}
