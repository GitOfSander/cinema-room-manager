import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int rows = 7;
    private static int columns = 8;

    private static Scanner scanner = new Scanner(System.in);;

    private static class Ticket {
        private int rowNumber;

        private List<Seat> seats = new ArrayList<Seat>();

        public Ticket(int rowNumber, List<Seat> seats) {
            this.rowNumber = rowNumber;
            this.seats = seats;
        }

        public int getRowNumber() {
            return rowNumber;
        }

        public void setRowNumber(int rowNumber) {
            this.rowNumber = rowNumber;
        }

        public List<Seat> getSeats() {
            return seats;
        }

        public void setSeats(List<Seat> seats) {
            this.seats = seats;
        }
    }

    public static class Seat {
        public int price;
        public boolean available;

        public Seat(int price, boolean available) {
            this.price = price;
            this.available = available;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }
    }

    private static List<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        setRowsAndColumns();

        whileLoop:
        while(true) {

            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    printOverview();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    printStatistics();
                    break;
                case 0:
                    break whileLoop;
                default:
                    System.out.println("This is not an option!");
            }
        }

        scanner.close();
    }

    private static void setRowsAndColumns() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        columns = scanner.nextInt();

        int totalSeats = columns * rows;
        int firstSectionRows = (int) Math.floor((double) rows / 2);
        int price = 10;

        for (int i = 0; i < rows; i++) {
            List<Seat> seats = new ArrayList<>();;

            tickets.add(new Ticket(i, seats));

            Ticket ticket = tickets.get(i);
            seats = ticket.getSeats();

            if (totalSeats > 60) {
                price = (i < firstSectionRows ? 10 : 8);
            }

            for (int c = 0; c < columns; c++) {
                seats.add(c, new Seat(price, true));
            }

            ticket.setSeats(seats);
        }
    }

    private static void printOverview() {
        System.out.println("Cinema:");
        for(int c = 0; c <= columns; c++) {
            if(c == 0) {
                System.out.print("\s ");
            } else {
                System.out.print(c + " ");
            }
        }
        System.out.println();

        for(int r = 0; r < tickets.size(); r++) {

            System.out.print((r + 1) + " ");

            List<Seat> seats = tickets.get(r).getSeats();

            for(int c = 0; c < seats.size(); c++) {
                Boolean available = seats.get(c).available;
                System.out.print((available ? "S" : "B") + " ");
            }

            System.out.println();

        }
    }

    private static void buyTicket() {
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt() - 1;

        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt() - 1;

        try {
            Ticket ticket = tickets.get(rowNumber);
            Seat seat = ticket.getSeats().get(seatNumber);

            if(!seat.available) {
                System.out.println("That ticket has already been purchased!");

                buyTicket();
            } else {
                System.out.println("Ticket price: $" + seat.price);
                seat.setAvailable(false);
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Wrong input!");
        }
    }

    private static void printStatistics() {
        int soldTickets = 0;
        int currentIncome = 0;
        int maxIncome = 0;

        for(int i = 0; i < tickets.size(); i++) {

            List<Seat> seats = tickets.get(i).getSeats();

            for(int s = 0; s < seats.size(); s++) {
                Seat seat = seats.get(s);
                if (!seat.available) {
                    soldTickets++;
                    currentIncome += seat.price;
                }

                maxIncome += seat.price;
            }
        }

        int totalSeats = columns * rows;


        double percentage = (100.00 / totalSeats) * soldTickets;

        BigDecimal bd = new BigDecimal(percentage).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Number of purchased tickets: " + soldTickets + "\n" +
                "Percentage: " + bd + "%\n" +
                "Current income: $" + currentIncome + "\n" +
                "Total income: $" + maxIncome + "\n");
    }

    private static int getMaxRevenue() {
        int totalSeats = columns * rows;
        int max = 0;

        if (totalSeats <= 60) {
            max = 10 * totalSeats;
        } else {
            max = (int) (10 * (columns * Math.floor((double) rows / 2)));
            max += 8 * (columns * Math.ceil((double) rows / 2));
        }

        return max;
    }
}