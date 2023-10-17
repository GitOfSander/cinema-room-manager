import java.math.BigDecimal;
import java.math.RoundingMode;

public class Statistics {
    private int totalTickets = 0;

    private int soldTickets= 0;

    private int maximumIncome = 0;

    private int currentIncome = 0;

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getSoldTickets() {
        return soldTickets;
    }

    public void addSoldTickets(int soldTickets) {
        this.soldTickets += soldTickets;
    }

    public int getMaximumIncome() {
        return maximumIncome;
    }

    public void addMaximumIncome(int maximumIncome) {
        this.maximumIncome += maximumIncome;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void addCurrentIncome(int currentIncome) {
        this.currentIncome += currentIncome;
    }

    public String toString() {
        BigDecimal percentage = new BigDecimal((100.00 / totalTickets) * soldTickets).setScale(2, RoundingMode.HALF_UP);

        return  "\nNumber of purchased tickets: " + soldTickets + "\n" +
                "Percentage: " + percentage + "%\n" +
                "Current income: $" + currentIncome + "\n" +
                "Total income: $" + maximumIncome;
    }
}
