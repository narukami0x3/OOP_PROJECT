package service;

import model.BoardGame;
import model.ConsoleGame;
import model.Customer;
import model.Game;
import model.PCGame;
import model.Rental;

import java.util.ArrayList;
import java.util.Scanner;

public class GameRentalSystem {

    private Scanner scanner;

    private ArrayList<Customer> customers;
    private ArrayList<Game> games;
    private ArrayList<Rental> rentals;

    public GameRentalSystem() {

        scanner = new Scanner(System.in);

        customers = new ArrayList<>();
        games = new ArrayList<>();
        rentals = new ArrayList<>();

        addSampleGames();
    }

    public void start() {

        boolean running = true;

        while (running) {

            showMenu();

            int choice = readInt("Enter choice: ");

            switch (choice) {

                case 1:
                    registerCustomer();
                    break;

                case 2:
                    showCustomers();
                    break;

                case 3:
                    showGames();
                    break;

                case 4:
                    rentGame();
                    break;

                case 5:
                    returnGame();
                    break;

                case 6:
                    showRentalHistory();
                    break;

                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }

    private void showMenu() {

        System.out.println();
        System.out.println("==============================");
        System.out.println("       GAME RENTAL SYSTEM");
        System.out.println("==============================");
        System.out.println("1. Register Customer");
        System.out.println("2. Show Customers");
        System.out.println("3. Show Games");
        System.out.println("4. Rent Game");
        System.out.println("5. Return Game");
        System.out.println("6. Rental History");
        System.out.println("0. Exit");
        System.out.println("==============================");
    }

    private void registerCustomer() {

        System.out.println("\n=== Register Customer ===");

        System.out.print("Customer ID: ");
        String id = scanner.nextLine();

        if (findCustomer(id) != null) {
            System.out.println("Customer ID already exists.");
            return;
        }

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        customers.add(
                new Customer(id, name, phone)
        );

        System.out.println(
                "Customer registered successfully."
        );
    }

    private Customer findCustomer(String id) {

        for (Customer customer : customers) {

            if (customer.hasId(id)) {
                return customer;
            }
        }

        return null;
    }

    private void showCustomers() {

        System.out.println("\n=== Customers ===");

        if (customers.isEmpty()) {
            System.out.println("No customers.");
            return;
        }

        for (Customer customer : customers) {
            customer.showInfo();
        }
    }

    private void showGames() {

        System.out.println("\n=== Games ===");

        for (Game game : games) {
            game.showInfo();
        }
    }

    private Game findGame(String id) {

        for (Game game : games) {

            if (game.hasId(id)) {
                return game;
            }
        }

        return null;
    }

    private void addSampleGames() {

        games.add(
                new PCGame(
                        "G001",
                        "Minecraft",
                        50,
                        "PC"
                )
        );

        games.add(
                new ConsoleGame(
                        "G002",
                        "God of War",
                        80,
                        "PS5"
                )
        );

        games.add(
                new BoardGame(
                        "G003",
                        "Catan",
                        40,
                        3,
                        4
                )
        );
    }

    private void rentGame() {

        System.out.println("\n=== Rent Game ===");

        System.out.print("Rental ID: ");
        String rentalId = scanner.nextLine();

        if (findRental(rentalId) != null) {
            System.out.println("Rental ID already exists.");
            return;
        }

        System.out.print("Customer ID: ");
        String customerId = scanner.nextLine();

        Customer customer = findCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Game ID: ");
        String gameId = scanner.nextLine();

        Game game = findGame(gameId);

        if (game == null) {
            System.out.println("Game not found.");
            return;
        }

        if (!game.isAvailable()) {
            System.out.println("Game is not available.");
            return;
        }

        int days = readInt("Rental days: ");

        if (days <= 0) {
            System.out.println("Invalid rental days.");
            return;
        }

        System.out.print("Payment method: ");
        String method = scanner.nextLine();

        if (!game.rent()) {
            System.out.println("Unable to rent game.");
            return;
        }

        Rental rental =
                new Rental(
                        rentalId,
                        customer,
                        game,
                        days,
                        method
                );

        rentals.add(rental);

        System.out.println("Game rented successfully.");
        System.out.println(
                "Total price: "
                        + rental.getTotalPrice()
        );
    }

    private void returnGame() {

        System.out.println("\n=== Return Game ===");

        System.out.print("Rental ID: ");
        String id = scanner.nextLine();

        Rental rental = findRental(id);

        if (rental == null) {
            System.out.println("Rental not found.");
            return;
        }

        if (!rental.returnGame()) {
            System.out.println("Game already returned.");
            return;
        }

        System.out.println("Game returned successfully.");

        System.out.println(
                "Late fine: "
                        + rental.calculateFine()
        );
    }

    private Rental findRental(String id) {

        for (Rental rental : rentals) {

            if (rental.hasId(id)) {
                return rental;
            }
        }

        return null;
    }

    private void showRentalHistory() {

        System.out.println("\n=== Rental History ===");

        if (rentals.isEmpty()) {
            System.out.println("No rental history.");
            return;
        }

        for (Rental rental : rentals) {
            rental.showInfo();
        }
    }

    private int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}