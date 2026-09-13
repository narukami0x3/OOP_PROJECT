package model;

public abstract class Person {

    private String name;
    private String phone;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    protected void showPersonInfo() {
        System.out.println("Name  : " + name);
        System.out.println("Phone : " + phone);
    }

    public abstract void showInfo();
}