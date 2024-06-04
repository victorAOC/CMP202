public class Swap {
    public static void main(String[] args) {
        int number1 = 78;
        int number2 = 32;

        System.out.println("Before swapping - number1: " + number1 + ", number2: " + number2);

        // Swapping logic using a temporary variable
        int temp = number1;
        number1 = number2;
        number2 = temp;

        System.out.println("After swapping - number1: " + number1 + ", number2: " + number2);
    }
}
