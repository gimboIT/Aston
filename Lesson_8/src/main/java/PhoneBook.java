import java.util.*;

public class PhoneBook {

    private Map<String, List<Integer>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void add(String name, int number) {
        contacts.put(name, Collections.singletonList(number));
    }

    public void add(String name, List<Integer> numbers) {
        contacts.put(name, numbers);
    }

    public List<Integer> get(String surname) {
        return contacts.get(surname);
    }
}