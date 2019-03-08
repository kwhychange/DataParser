import java.util.List;

public class DataManager {
    private List<State> state;

    public DataManager(List<State> statse) {
        this.state = statse;
    }

    public List<State> getState() {
        return state;
    }

    public void setState(List<State> state) {
        this.state = state;
    }
}
