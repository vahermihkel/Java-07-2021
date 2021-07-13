package ee.mihkel;

public class Reptile extends Animal {
    private String originCountry;

    public Reptile(int age, String name, String originCountry) {
        super(10000, age, name);
        this.originCountry = originCountry;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    @Override
    public String toString() {
        return "Reptile{" +
                "originCountry='" + originCountry + '\'' +
                '}';
    }
}
