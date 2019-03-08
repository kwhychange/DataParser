public class County {
    private String name;
    private int fips;
    private Election2016 vote2016;
    private Education2016 educ2016;
    private Employment2016 employ2016;

    public County(String name, int fips, Election2016 vote2016, Education2016 educ2016, Employment2016 employ2016) {
        this.name = name;
        this.fips = fips;
        this.vote2016 = vote2016;
        this.educ2016 = educ2016;
        this.employ2016 = employ2016;
    }
}
