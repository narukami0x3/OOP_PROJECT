package model;

import java.time.LocalDate;

public class Payment {

    private String paymentId;
    private double amount;
    private String method;
    private LocalDate paymentDate;

    public Payment(
            String paymentId,
            double amount,
            String method) {

        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
        this.paymentDate = LocalDate.now();
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void showPayment() {

        System.out.println("Payment ID   : " + paymentId);
        System.out.println("Amount       : " + amount);
        System.out.println("Method       : " + method);
        System.out.println("Payment Date : " + paymentDate);
    }
}