package model;

public class ConsoleGame extends Game {

    private String consoleType;

    public ConsoleGame(
            String gameId,
            String title,
            double rentalPrice,
            String consoleType) {

        super(gameId, title, rentalPrice);
        this.consoleType = consoleType;
    }

    public String getConsoleType() {
        return consoleType;
    }

    @Override
    public double calculateRentalFee(int days) {
        return calculateBaseFee(days) + 50;
    }

    @Override
    public void showInfo() {

        System.out.println("-------------------------");
        System.out.println("Type      : Console Game");
        System.out.println("Game ID   : " + getGameId());
        System.out.println("Title     : " + getTitle());
        System.out.println("Price     : " + getRentalPrice());
        System.out.println("Console   : " + consoleType);
        System.out.println("Available : "
                + (isAvailable() ? "Yes" : "No"));
        System.out.println("-------------------------");
    }
}