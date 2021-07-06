package ee.mihkel;

public class Animal {
    int price;
    int age;
    String name;
    boolean isPuppy;
    boolean isSold;

//    constructor, sulgude sees antakse väärtusi kui see klass luuakse
    public Animal(int _price, int _age, String _name, boolean _isPuppy, boolean _isSold) {
        this.price = _price;
        this.age = _age;
        this.name = _name;
        this.isPuppy = _isPuppy;
        this.isSold = _isSold;
    }
}
