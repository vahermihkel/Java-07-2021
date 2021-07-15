package ee.mihkel;

public class Bird extends Animal {
    private BirdColor birdColor;

//    parem klõps - generate - constructor
    public Bird(int price, int age, String name, BirdColor birdColor) {
        super(price, age, name);
        this.birdColor = birdColor;
    }

    public BirdColor getBirdColor() {
        return birdColor;
    }

    public void setBirdColor(BirdColor birdColor) {
        this.birdColor = birdColor;
    }

    public void increaseBirdAge() throws Exception {
        increaseAgeByOne();
        if (getAge() > 50) {
            throw new Exception("Vanus läks linnul üle 50");
        }
    }

    //    parem klõps - generate - toString
    @Override
    public String toString() {
        return "Bird{" +
                "price=" + getPrice() +
                ", age=" + getAge() +
                ", name='" + getName() + '\'' +
                ", isSold=" + isSold() +
                ", birdColor=" + birdColor +
                '}';
    }
}
