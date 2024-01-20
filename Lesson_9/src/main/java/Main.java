import util.ComparatorNumbersIncreaseWithSymbols;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1
        System.out.println(CollectionsHelper.evenCounter(List.of(1, 3, 2, 3, 1, 6, 73, 12)));
        //2.1
        List<String> list = new ArrayList<>(List.of("Highload", "High", "Load", "Highload"));
        System.out.println(list.stream().filter(x -> x.equals("High")).toList().size());
        //2.2
        System.out.println(CollectionsHelper.getFirstElement(list));
        //2.3
        System.out.println(CollectionsHelper.getLastElement(list));
        //3
        List<String> stringList = new ArrayList<>(List.of("f10", "f15", "f2", "f4", "f4"));
        System.out.println(stringList);
        stringList.sort(new ComparatorNumbersIncreaseWithSymbols());
        System.out.println(stringList);

        List<Student> students = new ArrayList<>(List.of(
                new Student("Artem", 18, Gender.MAN),
                new Student("Igor", 22, Gender.MAN),
                new Student("Anna", 21, Gender.WOMAN),
                new Student("Tomas", 25, Gender.MAN),
                new Student("Karl", 30, Gender.MAN)
        ));
        //4.1
        double averageManAge = students.stream().filter(x -> x.getGender() == Gender.MAN).mapToInt(Student::getAge).average().orElse(0);
        System.out.println(averageManAge);
        //4.2
        List<Student> studentWithRiskReceivingSummons = students.stream().filter(x -> x.getGender() == Gender.MAN && x.getAge() > 17 && x.getAge() < 28).toList();
        System.out.println(studentWithRiskReceivingSummons);
        //5
        Scanner scanner = new Scanner(System.in);
        List<String> logins = new ArrayList<>();
        while (true) {
            String login = scanner.nextLine();
            if (login.equals(""))
                break;
            logins.add(login);
        }
        logins.stream().filter(x -> x.charAt(0) == 'f').forEach(System.out::println);
    }
}
