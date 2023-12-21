import java.util.ArrayList;
import java.util.List;

public class Park {

    private String name;
    private List<Attraction> attractions;

    public Park(String name, List<Attraction> attractions) {
        this.name = name;
        this.attractions = attractions;
    }

    public Park(String name) {
        this.name = name;
        attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public static class Attraction {
        private String name;
        private String workingHours;
        private int cost;

        public Attraction(String name, String workingHours, int cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void getInfo() {
            System.out.println(name + " " + workingHours + " " + cost);
        }
    }
}
