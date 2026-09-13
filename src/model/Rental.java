package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {

    private String rentalId;
    private Customer customer;
    private Game game;

    private LocalDate rentDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private double totalPrice;
    private Payment payment;

    public Rental(
            String rentalId,
            Customer customer,
            Game game,
            int days,
            String paymentMethod) {

        this.rentalId = rentalId;
        this.customer = customer;
        this.game = game;

        rentDate = LocalDate.now();
        dueDate = rentDate.plusDays(days);

        totalPrice = game.calculateRentalFee(days);

        payment = new Payment(
                "P" + rentalId,
                totalPrice,
                paymentMethod
        );
    }

    public String getRentalId() {
        return rentalId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Game getGame() {
        return game;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Payment getPayment() {
        return payment;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    public boolean returnGame() {

        if (returnDate != null) {
            return false;
        }

        returnDate = LocalDate.now();

        game.returnGame();

        return true;
    }

    public double calculateFine() {

        if (returnDate == null) {
            return 0;
        }

        if (!returnDate.isAfter(dueDate)) {
            return 0;
        }

        long lateDays =
                ChronoUnit.DAYS.between(
                        dueDate,
                        returnDate
                );

        return lateDays * 20;
    }

    public boolean hasId(String id) {
        return rentalId.equalsIgnoreCase(id);
    }

    public void showInfo() {

        System.out.println("==============================");

        System.out.println("Rental ID   : " + rentalId);
        System.out.println("Customer    : " + customer.getName());
        System.out.println("Game        : " + game.getTitle());
        System.out.println("Rent Date   : " + rentDate);
        System.out.println("Due Date    : " + dueDate);

        System.out.println(
                "Return Date : "
                        + (returnDate == null ? "-" : returnDate)
        );

        System.out.println("Rental Fee  : " + totalPrice);
        System.out.println("Late Fine   : " + calculateFine());

        System.out.println("--- Payment ---");

        payment.showPayment();

        System.out.println("==============================");
    }
}