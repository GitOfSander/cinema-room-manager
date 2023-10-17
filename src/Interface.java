public interface Interface {
    default int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Input should be a number!");
        }

        return -1;
    }
}