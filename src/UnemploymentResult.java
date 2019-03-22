public class UnemploymentResult {
    private String state, areaName;
    private double rate07, rate08, rate09, rate10, rate11, rate12, rate13, rate14, rate15, rate16, rate17;

    public String toString() {
        return state + "," + areaName + "," + Utils.restoreDouble(rate07) + "," + Utils.restoreDouble(rate08) + "," + Utils.restoreDouble(rate09) + "," + Utils.restoreDouble(rate10) + ","
                + Utils.restoreDouble(rate11) + "," + Utils.restoreDouble(rate12) + "," + Utils.restoreDouble(rate13) + "," + Utils.restoreDouble(rate14) + ","
                + Utils.restoreDouble(rate15) + "," + Utils.restoreDouble(rate16) + "," + Utils.restoreDouble(rate17);
    }

    public UnemploymentResult(String state, String areaName, double rate07, double rate08, double rate09, double rate10, double rate11, double rate12, double rate13, double rate14, double rate15, double rate16, double rate17) {
        this.state = state;
        this.areaName = areaName;
        this.rate07 = rate07;
        this.rate08 = rate08;
        this.rate09 = rate09;
        this.rate10 = rate10;
        this.rate11 = rate11;
        this.rate12 = rate12;
        this.rate13 = rate13;
        this.rate14 = rate14;
        this.rate15 = rate15;
        this.rate16 = rate16;
        this.rate17 = rate17;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public double getRate07() {
        return rate07;
    }

    public void setRate07(double rate07) {
        this.rate07 = rate07;
    }

    public double getRate08() {
        return rate08;
    }

    public void setRate08(double rate08) {
        this.rate08 = rate08;
    }

    public double getRate09() {
        return rate09;
    }

    public void setRate09(double rate09) {
        this.rate09 = rate09;
    }

    public double getRate10() {
        return rate10;
    }

    public void setRate10(double rate10) {
        this.rate10 = rate10;
    }

    public double getRate11() {
        return rate11;
    }

    public void setRate11(double rate11) {
        this.rate11 = rate11;
    }

    public double getRate12() {
        return rate12;
    }

    public void setRate12(double rate12) {
        this.rate12 = rate12;
    }

    public double getRate13() {
        return rate13;
    }

    public void setRate13(double rate13) {
        this.rate13 = rate13;
    }

    public double getRate14() {
        return rate14;
    }

    public void setRate14(double rate14) {
        this.rate14 = rate14;
    }

    public double getRate15() {
        return rate15;
    }

    public void setRate15(double rate15) {
        this.rate15 = rate15;
    }

    public double getRate16() {
        return rate16;
    }

    public void setRate16(double rate16) {
        this.rate16 = rate16;
    }

    public double getRate17() {
        return rate17;
    }

    public void setRate17(double rate17) {
        this.rate17 = rate17;
    }
}
