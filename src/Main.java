import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();

        while(cinema.isWorking()) {
            cinema.printLabel();
            cinema.handler(scanner.next());

            System.out.println();
        }
    }
}
