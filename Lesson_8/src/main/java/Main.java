import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"one", "two", "three", "four", "one", "one", "three", "five", "six", "seven", "eight"};
        Set<String> uniqueWords = new HashSet<>(List.of(words));
        Map<String, Integer> wordsCounts = new HashMap<>();

        for (String word : words) {
            if (wordsCounts.containsKey(word)) {
                int count = wordsCounts.get(word);
                wordsCounts.put(word, count + 1);
            } else {
                wordsCounts.put(word, 1);
            }
        }

        wordsCounts.forEach((x, y) -> System.out.println(x + " " + y));

        System.out.println("-----");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivan",List.of(89153236));
        phoneBook.add("Timur",List.of(89153322,891268345));
        List<Integer> integerList = phoneBook.get("Timur");
        integerList.forEach(System.out::println);
    }
}
