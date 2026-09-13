package model;

public class Customer extends Person {

    private String customerId;

    public Customer(String customerId, String name, String phone) {
        super(name, phone);
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public boolean hasId(String id) {
        return customerId.equalsIgnoreCase(id);
    }

    @Override
    public void showInfo() {

        System.out.println("-------------------------");
        System.out.println("Customer ID : " + customerId);
        System.out.println("Name        : " + getName());
        System.out.println("Phone       : " + getPhone());
        System.out.println("-------------------------");
    }
}