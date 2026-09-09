package Model;

public class Person {
    private String name,phone;
    protected Person(String name , String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
