public class Employment2016 {
    private int totalLaborForce;
    private int eployedLaborForce;
    private int unemployedLaborForce;
    private double unemployedPercent;

    public int getTotalLaborForce() {
        return totalLaborForce;
    }

    public void setTotalLaborForce(int totalLaborForce) {
        this.totalLaborForce = totalLaborForce;
    }

    public int getEployedLaborForce() {
        return eployedLaborForce;
    }

    public void setEployedLaborForce(int eployedLaborForce) {
        this.eployedLaborForce = eployedLaborForce;
    }

    public int getUnemployedLaborForce() {
        return unemployedLaborForce;
    }

    public void setUnemployedLaborForce(int unemployedLaborForce) {
        this.unemployedLaborForce = unemployedLaborForce;
    }

    public double getUnemployedPercent() {
        return unemployedPercent;
    }

    public void setUnemployedPercent(double unemployedPercent) {
        this.unemployedPercent = unemployedPercent;
    }

    public Employment2016(int totalLaborForce, int eployedLaborForce, int unemployedLaborForce, double unemployedPercent) {
        this.totalLaborForce = totalLaborForce;
        this.eployedLaborForce = eployedLaborForce;
        this.unemployedLaborForce = unemployedLaborForce;
        this.unemployedPercent = unemployedPercent;
    }
}
