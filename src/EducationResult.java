public class EducationResult {
    private String state, areaName;
    private double perNoHS2000, perHS2000, perCollege2000, perBachelor2000;
    private int noHS1216, HS1216, college1216, bachelor1216;
    private double perNoHS1216, perHS1216, perCollege1216, perBachelor1216;

    public void setNoHS1216(int noHS1216) {
        this.noHS1216 = noHS1216;
    }

    public void setHS1216(int HS1216) {
        this.HS1216 = HS1216;
    }

    public void setCollege1216(int college1216) {
        this.college1216 = college1216;
    }

    public void setBachelor1216(int bachelor1216) {
        this.bachelor1216 = bachelor1216;
    }

    public String toString() {
        return "State: " + state + "\nArea Name: " + areaName + "\n"
                + perNoHS2000 + ", " + perHS2000 + ", " + perCollege2000 + ", " + perBachelor2000 + ", "
                + noHS1216 + ", " + HS1216 + ", " + college1216 + ", " + bachelor1216 + ", "
                + perNoHS1216 + ", " + perHS1216 + ", " + perCollege1216 + ", " + perBachelor1216;
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

    public double getPerNoHS2000() {
        return perNoHS2000;
    }

    public void setPerNoHS2000(double perNoHS2000) {
        this.perNoHS2000 = perNoHS2000;
    }

    public double getPerHS2000() {
        return perHS2000;
    }

    public void setPerHS2000(double perHS2000) {
        this.perHS2000 = perHS2000;
    }

    public double getPerCollege2000() {
        return perCollege2000;
    }

    public void setPerCollege2000(double perCollege2000) {
        this.perCollege2000 = perCollege2000;
    }

    public double getPerBachelor2000() {
        return perBachelor2000;
    }

    public void setPerBachelor2000(double perBachelor2000) {
        this.perBachelor2000 = perBachelor2000;
    }

    public int getNoHS1216() {
        return noHS1216;
    }

    public int getHS1216() {
        return HS1216;
    }

    public int getCollege1216() {
        return college1216;
    }

    public int getBachelor1216() {
        return bachelor1216;
    }

    public double getPerNoHS1216() {
        return perNoHS1216;
    }

    public void setPerNoHS1216(double perNoHS1216) {
        this.perNoHS1216 = perNoHS1216;
    }

    public double getPerHS1216() {
        return perHS1216;
    }

    public void setPerHS1216(double perHS1216) {
        this.perHS1216 = perHS1216;
    }

    public double getPerCollege1216() {
        return perCollege1216;
    }

    public void setPerCollege1216(double perCollege1216) {
        this.perCollege1216 = perCollege1216;
    }

    public double getPerBachelor1216() {
        return perBachelor1216;
    }

    public void setPerBachelor1216(double perBachelor1216) {
        this.perBachelor1216 = perBachelor1216;
    }

    public EducationResult(String state, String areaName, double perNoHS2000, double perHS2000, double perCollege2000, double perBachelor2000, int noHS1216, int HS1216, int college1216, int bachelor1216, double perNoHS1216, double perHS1216, double perCollege1216, double perBachelor1216) {
        this.state = state;
        this.areaName = areaName;
        this.perNoHS2000 = perNoHS2000;
        this.perHS2000 = perHS2000;
        this.perCollege2000 = perCollege2000;
        this.perBachelor2000 = perBachelor2000;
        this.noHS1216 = noHS1216;
        this.HS1216 = HS1216;
        this.college1216 = college1216;
        this.bachelor1216 = bachelor1216;
        this.perNoHS1216 = perNoHS1216;
        this.perHS1216 = perHS1216;
        this.perCollege1216 = perCollege1216;
        this.perBachelor1216 = perBachelor1216;
    }
}
