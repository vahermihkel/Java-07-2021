package ee.mihkel;

import java.util.*;

// pangas konto class
// public int pangajääk;

// -1000000
// MAINIS - konto.pangajääk = +1000000;

// kui keeran kinni ehk teen muutuja private-ks, siis enam otse ligi ei pääse
// ja see sätestab tingimused kuidas ma seda muudan

// -1000000
// lisaPanka(1000)
// võtaPangast(10000)

public class Animal {
    private int price; // 12312
    private int age; // number
    private String name; // "asdasda" sõna
    private boolean isPuppy; // true või false
    private boolean isSold; // 0 või 1, "y" või "no", aga siis on ka kolmas valik
    private int birthYear; // 12312 int
    private AnimalType animalType; // AnimalType enumi sees olevad muutujad, saab välja kutsuda vaid AnimalType.MUUTUJA
    private List<Animal> children = new ArrayList<>(); // [Animal{}, Animal{}]
//    List<Animal> children ------ null    <----- siia ei saa juurde lisada elemente
//    List<Animal> children = new ArrayList<>() ----- []   <----- siia saab juurde lisada elemente


//    constructor, sulgude sees antakse väärtusi kui see klass luuakse
    public Animal(int _price, int _age, String _name, boolean _isPuppy, boolean _isSold, AnimalType _animalType) {
        this.price = _price;
        this.age = _age;
        this.name = _name;
        this.isPuppy = _isPuppy;
        this.isSold = _isSold;
        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        this.birthYear = year - _age;
        this.animalType = _animalType;
    }

    public void changeToSold() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kas on vajalikud dokumendid esitatud?");
        String input = scanner.nextLine();
        if (input.equals("jah")) {
            this.isSold = true;
            System.out.println("Müüdud!");
        } else {
            System.out.println("Ei saa dokumentideta müüa!");
        }
    }

    public void increaseAge() {
        this.age++;
        if (this.age > 0) {
            this.isPuppy = false;
        }
    }

    public void changePrice(int newPrice) {
        this.price = newPrice;
    }

    public int getPrice() {
        return this.price;
    }

    public List<Animal> getChildren() {
        return children;
    }

    public void addChild(Animal child) {
        if (this.isPuppy) {
            System.out.println("Tegemist on kutsikaga, lapsi lisada ei saa!");
        } else {
            this.children.add(child);
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "price=" + price +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", isPuppy=" + isPuppy +
                ", isSold=" + isSold +
                ", birthYear=" + birthYear +
                ", animalType=" + animalType +
                '}';
    }
}
