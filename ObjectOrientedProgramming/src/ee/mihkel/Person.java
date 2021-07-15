package ee.mihkel;

public class Person implements ProjectObject {
    private String name;
    private String telPhone;
    private String email;
    private String personalCode;
    private String address;


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // method overloading
    public void setName(String name, boolean nameBackwards) {
        if (nameBackwards) {
            this.name = new StringBuilder(name).reverse().toString();
        }
    }
}
