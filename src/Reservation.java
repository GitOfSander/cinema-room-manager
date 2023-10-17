import java.util.List;

public class Reservation {
    private int rowNumber;

    private int seatNumber;

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber - 1;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber - 1;
    }

    public List<Row> buyTicket(List<Row> rows, Statistics statistics) throws Exception {
        try {
            Row row = rows.get(rowNumber);
            Seat seat = row.getSeats().get(seatNumber);

            if(!seat.available) {
                throw new Exception("That ticket has already been purchased!");
            } else {
                System.out.println("Ticket price: $" + seat.price);
                seat.setAvailable(false);
                statistics.addSoldTickets(1);
                statistics.addCurrentIncome(seat.price);
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Wrong input");
        }

        return rows;
    }
}
