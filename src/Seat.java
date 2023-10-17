public class Seat {
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