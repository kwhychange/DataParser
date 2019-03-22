public class HomelessData {
    private String state;
    private double Data2013, Data2012;

    public String toString(){
        return state + "," + Utils.restoreDouble(Data2013) + "," + Utils.restoreDouble(Data2012);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getData2013() {
        return Data2013;
    }

    public void setData2013(double data2013) {
        Data2013 = data2013;
    }

    public double getData2012() {
        return Data2012;
    }

    public void setData2012(double data2012) {
        Data2012 = data2012;
    }

    public HomelessData(String state, double data2013, double data2012) {
        this.state = state;
        this.Data2013 = data2013;
        this.Data2012 = data2012;
    }
}
