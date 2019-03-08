import java.util.List;

public class State {
    private String name;
    private List<County> counties;

    public State(String name, List<County> counties) {
        this.name = name;
        this.counties = counties;
    }
}
