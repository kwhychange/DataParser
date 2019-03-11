import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<State> states;

    public DataManager() {
        this.states = new ArrayList<State>();
    }

    public int stateIndex(String name) {
        for (int i = 0; i < states.size(); i++) {
            State state = states.get(i);
            if (state.getName().equals(name)) return i;
        }
        return -1;
    }

    public List<State> getStates() {
        return states;
    }

    public void add(State state) {
        states.add(state);
    }

    public void setState(List<State> state) {
        this.states = state;
    }
}
