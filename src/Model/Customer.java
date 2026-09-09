package Model;

public class Customer extends Person{
    private String customerId;
    Customer(String customerId , String name , String phone){
        super(name,phone);
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
