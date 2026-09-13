package model;

public class PCGame extends Game {

    private String platform;

    public PCGame(
            String gameId,
            String title,
            double rentalPrice,
            String platform) {

        super(gameId, title, rentalPrice);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    @Override
    public double calculateRentalFee(int days) {
        return calculateBaseFee(days);
    }

    @Override
    public void showInfo() {

        System.out.println("-------------------------");
        System.out.println("Type      : PC Game");
        System.out.println("Game ID   : " + getGameId());
        System.out.println("Title     : " + getTitle());
        System.out.println("Price     : " + getRentalPrice());
        System.out.println("Platform  : " + platform);
        System.out.println("Available : "
                + (isAvailable() ? "Yes" : "No"));
        System.out.println("-------------------------");
    }
}