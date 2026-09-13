package model;

public class BoardGame extends Game {

    private int minPlayers;
    private int maxPlayers;

    public BoardGame(
            String gameId,
            String title,
            double rentalPrice,
            int minPlayers,
            int maxPlayers) {

        super(gameId, title, rentalPrice);
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public double calculateRentalFee(int days) {
        return calculateBaseFee(days);
    }

    @Override
    public void showInfo() {

        System.out.println("-------------------------");
        System.out.println("Type      : Board Game");
        System.out.println("Game ID   : " + getGameId());
        System.out.println("Title     : " + getTitle());
        System.out.println("Price     : " + getRentalPrice());
        System.out.println("Players   : "
                + minPlayers + "-" + maxPlayers);
        System.out.println("Available : "
                + (isAvailable() ? "Yes" : "No"));
        System.out.println("-------------------------");
    }
}