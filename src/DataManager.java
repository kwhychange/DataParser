import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<State> states;

    public DataManager() {
        this.states = new ArrayList<State>();
    }

    public List<State> getState() {
        return states;
    }

    public void add(State state){
        states.add(state);
    }

    public void setState(List<State> state) {
        this.states = state;
    }
}
