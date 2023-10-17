import java.util.ArrayList;
import java.util.List;

public class Row {
    private int rowNumber;

    private List<Seat> seats = new ArrayList<Seat>();

    public Row(int rowNumber, List<Seat> seats) {
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