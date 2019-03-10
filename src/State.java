import java.util.ArrayList;
import java.util.List;

public class State {
    private String name;
    private List<County> counties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCounty(County county) {
        counties.add(county);
    }

    public void removeCounty(County county) {
        counties.remove(county);
    }

    public County removeCounty(int index){
        return counties.remove(index);
    }

    public List<County> getCounties() {
        return counties;
    }

    public State(String name) {
        this.name = name;
        counties = new ArrayList<County>();
    }
}
