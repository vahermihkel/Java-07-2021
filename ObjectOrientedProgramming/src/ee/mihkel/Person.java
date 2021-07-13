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
}
