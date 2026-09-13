package model;

public abstract class Game {

    private String gameId;
    private String title;
    private double rentalPrice;
    private boolean available;

    public Game(String gameId, String title, double rentalPrice) {

        this.gameId = gameId;
        this.title = title;
        this.rentalPrice = rentalPrice;
        this.available = true;
    }

    public String getGameId() {
        return gameId;
    }

    public String getTitle() {
        return title;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean hasId(String id) {
        return gameId.equalsIgnoreCase(id);
    }

    public boolean rent() {

        if (!available) {
            return false;
        }

        available = false;
        return true;
    }

    public void returnGame() {
        available = true;
    }

    protected double calculateBaseFee(int days) {
        return rentalPrice * days;
    }

    public abstract double calculateRentalFee(int days);

    public abstract void showInfo();
}