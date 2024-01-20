import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CollectionsHelper {
    public static int evenCounter(List<Integer> numbers) {
        AtomicInteger counter = new AtomicInteger();
        numbers.forEach(x -> {
            if (x % 2 == 0) {
                counter.getAndIncrement();
            }
        });
        return counter.get();
    }

    public static String getFirstElement(List<String> collection) {
        if (collection == null || collection.isEmpty())
            return "0";
        return collection.get(0);
    }

    public static String getLastElement(List<String> collection) {
        if (collection == null || collection.isEmpty())
            return "0";
        return collection.get(collection.size() - 1);
    }
}
