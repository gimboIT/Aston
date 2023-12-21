public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Ivanov1 Ivan Ivanov","QA","Ivanov1@mail.ru","891622135",60000,18),
                new Employee("Ivanov2 Ivan Ivanov","Lead QA","Ivanov2@mail.ru","89252135",260000,28),
                new Employee("Ivanov3 Ivan Ivanov","Java developer","Ivanov3@mail.ru","893622135",160000,38),
                new Employee("Ivanov4 Ivan Ivanov","Architect","Ivanov4@mail.ru","894622135",260000,56),
                new Employee("Ivanov5 Ivan Ivanov","QA","Ivanov5@mail.ru","895622135",50000,19)
        };

        for (int i = 0; i < employees.length; i++) {
           employees[i].getInfo();
        }

        System.out.println("-----");

        Park park = new Park("Disney");
        park.addAttraction(new Park.Attraction("Ferris wheel","9:00 - 17:00",200));
        park.addAttraction(new Park.Attraction("Phantom Manor","12:00 - 17:00",500));

        park.getAttractions().forEach(Park.Attraction::getInfo);
    }
}
