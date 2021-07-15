package ee.mihkel;

// extends = inheritance
public class Reptile extends Animal implements ProjectObject {
// ilma staticuta pöördun selle muutuja poole instantsi kaudu ehk igal instantsil on eraldi selle jaoks väärtus
    private int familyCount;
//    static on kõigile ühine, kui seda suurendada/vähendada, siis muutub kõigil, kutsun välja classi, mitte instantsi kaudu
    private static int breedCount;
    private String originCountry;

//    short 32,767
//    int 2,123,123,123,

    public Reptile(int age, String name, String originCountry) {
        super(10000, age, name);
        this.originCountry = originCountry;
        this.familyCount = 1;
        breedCount = 1;
        // suurendades MAX väärtust teeb ringi peale
//        this.familyCount = Integer.MAX_VALUE;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public int getFamilyCount() {
        return familyCount;
    }

    public void increaseFamilyCount() {
        this.familyCount++;
    }

    public int getBreedCount() {
        return breedCount;
    }

    public void increaseBreedCount() {
        Reptile.breedCount++;
    }

    @Override
    public String toString() {
        return "Reptile{" +
                "originCountry='" + originCountry + '\'' +
                '}';
    }
}
