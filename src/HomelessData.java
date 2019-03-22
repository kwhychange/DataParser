public class HomelessData {
    private String state;
    private int Data2013, Data2012;

    public String toString(){
        return state + "," + Utils.restoreInt(Data2013) + "," + Utils.restoreInt(Data2012);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getData2013() {
        return Data2013;
    }

    public void setData2013(int data2013) {
        Data2013 = data2013;
    }

    public int getData2012() {
        return Data2012;
    }

    public void setData2012(int data2012) {
        Data2012 = data2012;
    }

    public HomelessData(String state, int data2013, int data2012) {
        this.state = state;
        this.Data2013 = data2013;
        this.Data2012 = data2012;
    }
}
